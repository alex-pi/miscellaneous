const stackBarsGraphHelper = (function () {
  const sbgh = {};

  sbgh.draw = function (svgId, idGraph, data) {
    const svg = d3.select(`#${svgId}`);

    //const gc = _.merge(defaults, config);
    const gc = graphConfigs[idGraph];

    const formatValue = x => isNaN(x) ? "N/A" : x.toLocaleString("en")

    svg.attr('width', gc.width);
    svg.attr('height', gc.height);

    const margin = gc.margin;
    const [width, height] = [gc.width, gc.height];

    gc.innerWidth = width - margin.left - margin.right;
    gc.innerHeight = height - margin.top - margin.bottom;

    const viewPort = svg.append("g")
      .attr("transform",
        `translate(${margin.left}, ${margin.top})`);

    gc.ySeriesNames = data.columns.slice(1);

    const dataP = _.map(data, d => {
      d.total = d3.sum(gc.ySeriesNames, c => d[c]);
      return d;
    });//.sort((a, b) => b.total - a.total);

    const series = d3.stack()
      .keys(gc.ySeriesNames)
      (data)
      .map(d => (d.forEach(v => v.key = d.key), d));

    console.log(series);

    const xScale = d3.scaleBand()
      .domain(dataP.map(d => d['Year']))
      .range([0, gc.innerWidth])
      .padding(0.32);

    const yScale = d3.scaleLinear()
      .domain([0, d3.max(series, d => d3.max(d, d => d[1]))])
      .rangeRound([gc.innerHeight, margin.top]);

    gc.colorScheme = d3.schemeSpectral[series.length];

    const color = d3.scaleOrdinal()
      .domain(series.map(d => d.key))
      .range(gc.colorScheme);

    const xAxisG = graphUtils.createXAxis(viewPort, gc);

    const yAxisG = graphUtils.createYAxis(viewPort, gc, gc.yAxisTitle);

    const xAxis = d3.axisBottom(xScale).tickSizeOuter(0);

    const yAxis = d3.axisLeft(yScale).tickSize(-gc.innerWidth);

    xAxisG.call(xAxis);

    yAxisG.call(yAxis);

    viewPort.append("g")
      .selectAll("g")
      .data(series)
      .join("g")
        .attr("fill", d => color(d.key))
      .selectAll("rect")
      .data(d => d)
      .join("rect")
        .attr("x", (d, i) => xScale(d.data['Year']))
        .attr("y", d => yScale(d[1]))
        .attr("height", d => yScale(d[0]) - yScale(d[1]))
        .attr("width", xScale.bandwidth())
      .append("title")
        .text(d => `${d.data['Year']}, ${d.key} -> ${formatValue(d.data[d.key])}`);

    graphUtils.addLegends({
      svg: svg,
      x: gc.legends.x,
      y: gc.legends.y,
      colors: function(d, i) {
        return gc.colorScheme[i];
      },
      legendsData: gc.ySeriesNames,
      texts: function (d, i) {
        return d;
      },
      styleClass: 'indlegends',
      bg: gc.legends.bg
    });

    graphUtils.addFreeTexts(viewPort, gc);

    return svg;

  };

  return sbgh;

})();
