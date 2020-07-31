const lineGraphHelper = (function () {
  const lgh = {};

  const prepareYSeries = function(conf, data) {
    conf.ySeriesNames = _.slice(data.columns, 1);

    if(!_.isNil(conf.ySeries)) {
      _.forEach(conf.ySeriesNames, (n, i) => conf.ySeries[i].name = n);
      return conf.ySeries;
    }

    return _.map(conf.ySeriesNames, name => {
      return {
        name: name,
        domain: conf.yDomain,
        styleClass: conf.styleClass,
        axisTitle: conf.yAxisTitle
      };
    });
  };

  const addLegends = function(svg, conf) {
    if(_.isNil(conf.legends)) return;
    return graphUtils.addLegends({
      svg: svg,
      x: conf.legends.x,
      y: conf.legends.y,
      colors: function(d, i) {
        return conf.colorScheme[i];
      },
      legendsData: conf.ySeriesNames,
      texts: function (d, i) {
        return d;
      },
      styleClass: 'indlegends',
      bg: conf.legends.bg
    });
  };

  lgh.draw = function (svgId, idGraph, data) {

    const svg = d3.select(`#${svgId}`);
    const config = lineGraphConfigs[idGraph];

    const defaults = {
      width: svg.attr('width'),
      height: svg.attr('height'),
      margin: {left: 60, right: 20, top: 20, bottom: 55},
      //ySeriesNames: _.slice(data.columns, 1),
      xSeriesName: data.columns[0],
      colorScheme: config.colorScheme || d3.schemeSet2,
      xTickValues: null,
      //yTickValues: null,
      baseLine: {},
      separateScales: false
      //yDomain2: {}
    };

    const lgc = _.merge(defaults, config);
    console.log(lgc);

    svg.attr('width', lgc.width);
    svg.attr('height', lgc.height);

    const margin = lgc.margin;
    const [width, height] = [lgc.width, lgc.height];
    const baseLine = lgc.baseLine;

    lgc.innerWidth = width - margin.left - margin.right;
    lgc.innerHeight = height - margin.top - margin.bottom;

    let ySeries = prepareYSeries(lgc, data);
    //const ySeriesNames = assignSeriesNames(data, ySeries);

    const viewPort = svg.append("g")
      .attr("transform",
        `translate(${margin.left}, ${margin.top})`);

    const xAxisG = graphUtils.createXAxis(viewPort, lgc);

    const yAxisG = graphUtils.createYAxis(viewPort, lgc, ySeries[0].axisTitle);

    _.forEach(ySeries, (s) => {
      s.scale = d3.scaleLinear()
        .domain(s.domain)
        .range([lgc.innerHeight, 0]);
    });

    if(lgc.separateScales) {
      //TODO correlate which series correspond to the second yAxis
      const yAxisG2 = graphUtils.createSecondYAxis(viewPort, lgc, ySeries[1].axisTitle);
      const yAxis2 = d3.axisRight()
        .scale(ySeries[1].scale)
        .tickPadding(15);
      //.tickFormat(d3.format('.0s'))
      //.tickSize(-innerWidth);

      yAxisG2.call(yAxis2);
    }

    const colors = d3.scaleOrdinal()
      .domain(lgc.ySeriesNames)
      .range(lgc.colorScheme);

    const xScale = d3.scaleLinear()
      .domain(lgc.xDomain)
      .range([0, lgc.innerWidth]);

    const xAxis = d3.axisBottom()
      .scale(xScale)
      .tickPadding(15)
      .tickFormat(d3.format(""))
      .tickSize(-lgc.innerHeight);

    graphUtils.applyIf.apply(xAxis, [{'tickValues': lgc.xTickValues}]);

    xAxisG.call(xAxis);

    const yAxis = d3.axisLeft()
      .scale(ySeries[0].scale)
      //.scale(yScale1)
      .tickPadding(15)
      //.tickFormat(d3.format('.0s'))
      .tickSize(-lgc.innerWidth);

    //applyIf.apply(yAxis, [{'tickValues': lgc.yTickValues}]);
    yAxisG.call(yAxis);

    /*if (baseLine.point != undefined) {
      yAxisG.selectAll("g")
        .filter(d => d == baseLine.point)
        .attr('class', 'baseLine');
      //.style("stroke-width", 2)
      //.style("stroke-dasharray", 6);
    }

    if (!_.isNil(baseLine.text)) {
      viewPort.append('text')
        .attr('class', 'baseLineText')
        .attr('x', baseLine.xy[0])
        .attr('y', baseLine.xy[1])
        .text(baseLine.text);
    }*/

    graphUtils.addBaseLine(viewPort, yAxisG, baseLine);

    const series = _.reduce(data, (memo, row) => {
      //debugger;
      _.forEach(memo, (ys) => {
        ys.values.push({
          'xval': row[lgc.xSeriesName],
          'yval': row[ys.name]
        });
        ys.values.scale = ys.scale;
      });
      return memo;
    }, _.map(ySeries, (s) => {
      s.values = [];
      return s;
    }));

    const line = d3.line()
      .defined(d => d.yval != null)
      .x(d => {
        d.xg = xScale(d.xval);
        return d.xg;
      })
      .y((d, i, allData) => {
        let y = allData.scale(d.yval);
        d.yg = y;
        return y;
      });

    viewPort.selectAll("series")
      .data(series)
      .enter()
      .append("path")
        .attr("d", (d, i) => {
          let p = line(d.values);
          return p;
        })
        .attr("stroke", d => colors(d.name))
        .attr('class', d => d.styleClass || 'lineSeriesMid');
        //.style("stroke-width", 3)
        //.style("fill", "none");

    addLegends(svg, lgc); //TODO I should use the viewPort not the svg
    graphUtils.addAnnotations(viewPort, lgc, series);
    graphUtils.addFreeTexts(viewPort, lgc);
    console.log(series);

    lgh.svg = svg;
    return svg;
  };

  return lgh;
})();


