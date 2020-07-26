const barsGraphHelper = (function () {
  const bgh = {};

  bgh.draw = function (svgId, idGraph, data) {
    const svg = d3.select(`#${svgId}`);

    //const gc = _.merge(defaults, config);
    const gc = lineGraphConfigs[idGraph];

    svg.attr('width', gc.width);
    svg.attr('height', gc.height);

    const margin = gc.margin;
    const [width, height] = [gc.width, gc.height];

    gc.innerWidth = width - margin.left - margin.right;
    gc.innerHeight = height - margin.top - margin.bottom;

    gc.xFieldName = data.columns[0];
    gc.yFieldName = data.columns[1];

    const viewPort = svg
      .append("g")
      .attr("transform",
        `translate(${margin.left}, ${margin.top})`);

    //const tooltip = d3.select("body").append("div").attr("class", "toolTip");

    const xScale = d3.scaleBand()
      .domain(data.map(d => d[gc.xFieldName]))
      //.domain(gc.xDomain)
      .range([0, gc.innerWidth])
      .padding(0.09);

    const yScale = d3.scaleLinear()
      //.domain([0, _.max(data)])
      .domain(gc.yDomain)
      .range([gc.innerHeight, 0]);

    const xAxisG = graphUtils.createXAxis(viewPort, gc);

    const yAxisG = graphUtils.createYAxis(viewPort, gc, gc.yAxisTitle);

    const xAxis = d3.axisBottom()
      .scale(xScale)
      .tickPadding(13)
      .tickFormat(d3.format(""));
      //.tickSize(-gc.innerHeight);

    const yAxis = d3.axisLeft()
      .scale(yScale)
      .tickPadding(13)
      .tickSize(-gc.innerWidth);

    graphUtils.applyIf.apply(xAxis, [{'tickValues': gc.xTickValues}]);

    graphUtils.applyIf.apply(yAxis, [{'tickValues': gc.yTickValues}]);

    xAxisG.call(xAxis);

    yAxisG.call(yAxis);

    viewPort.selectAll('rect')
      .data(data).enter()
      .append('rect')
      .attr('class', 'simpleBar')
        .attr('x', (d, i) => {
          let v = xScale(d[gc.xFieldName])
          return v;
        })
        .attr('y', gc.innerHeight - 1)
        .attr('width', xScale.bandwidth())
        .attr('height', 1)
        /*.on('mouseover', (d, i) => {
          tooltip
            .style('left', d3.event.pageX - 50 + 'px')
            .style('top', d3.event.pageY - 70 + 'px')
            .style('display', 'inline-block')
            .html(`${d['Year']} is ${d['Index value']}`);
        })
            .on('mouseout', () => tooltip.style('display', 'none'))*/
        .transition().duration(3000).delay(1000)
        .attr('y', (d, i) => {
          let v = yScale(d[gc.yFieldName]);
          debugger;
          return v;
        })
        .attr('height', (d, i) => gc.innerHeight - yScale(d[gc.yFieldName]));


    /*viewPort.append('g')
      //.attr('transform', `translate(${gd.ox}, ${gd.oy})`)
      //.call(d3.axisLeft(yscale));
      .call(d3.axisLeft(yScale));

    viewPort.append('g')
      .attr('transform', `translate(0, ${gc.innerHeight})`)
      .call(d3.axisBottom(xScale));*/

    return svg;
  };

  return bgh;

})();
