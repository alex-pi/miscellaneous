const barsGraphHelper = (function () {
  const bgh = {};

  bgh.draw = function (svgId, idGraph, data) {
    const svg = d3.select(`#${svgId}`);

    //const gc = _.merge(defaults, config);
    const gc = graphConfigs[idGraph];

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

    graphUtils.addBaseLine(viewPort, yAxisG, gc.baseLine, yScale, gc);

    let rectY = d => yScale(d[gc.yFieldName]);
    let rectH = d => gc.innerHeight - yScale(d[gc.yFieldName]);

    if(!_.isNil(gc.baseDataPoint)) {
      const baseYPoint = yScale(gc.baseDataPoint);
      rectY = d => d[gc.yFieldName] <= 0 ? baseYPoint:yScale(d[gc.yFieldName]);
      rectH = d => Math.abs(yScale(d[gc.yFieldName]) - baseYPoint);
    }

    viewPort.selectAll('rect')
      .data(data).enter()
      .append('rect')
      .attr('class', (d,a,b) => {
        if(_.isFunction(gc.barStyle))
          return gc.barStyle(gc.yFieldName)(d);
        return gc.barStyle || 'neutralBar';
      })
      .attr('x', (d, i) => xScale(d[gc.xFieldName]))
      .attr('width', xScale.bandwidth())
      .attr('y', yScale(0))
      .attr('height', 0)
      .transition().duration(3000).delay(300)
      .attr('y', rectY)
      .attr('height', rectH);

    viewPort.selectAll('rect')
      .append("title")
        .text(d => `Year: ${d[gc.xFieldName]}, Average: ${d[gc.yFieldName]}`);

    graphUtils.addFreeTexts(viewPort, gc);

    return svg;
  };

  return bgh;

})();
