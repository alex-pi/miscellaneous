const lineGraphHelper = (function () {
  const lgh = {};

  const applyIf = function(props) {
    const d3Chain = this;
    const collectionCheck = (c) => !_.isEmpty(c);
    const valueCheck = (v) => !_.isNil(v);

    _.forEach(props, (v, k) => {
      const check = (v) => {
        if (_.isArray(v))
          return collectionCheck;
        else
          return valueCheck;
      };
      if (check(v))
        d3Chain[k](v);
    });
  };

  const createXAxis = function(g, conf) {
    var xAxisG = g.append('g')
      .attr('transform', `translate(0, ${conf.innerHeight})`);

    xAxisG.append('text')
      .attr('class', 'axis-label')
      .attr('x', conf.innerWidth / 2)
      .attr('y', 40)
      .text(conf.xAxisTitle);

    return xAxisG;
  };

  const createYAxis = function(g, conf, title) {
    const yAxisG = g.append('g');

    yAxisG.append('text')
      .attr('class', 'axis-label')
      .attr('x', -conf.innerHeight / 2)
      .attr('y', () => title.yShift || -40)
      .attr('transform', `rotate(-90)`)
      .style('text-anchor', 'middle')
      .text(() => title.text || title);

    return yAxisG
  };

  const createSecondYAxis = function(g, conf, title) {
    const yAxisG2 = g.append('g')
      .attr('transform', `translate(${conf.innerWidth}, 0)`);

    yAxisG2.append('text')
      .attr('class', 'axis-label')
      .attr('x', conf.innerHeight / 2)
      .attr('y', -50)
      .attr('transform', `rotate(90)`)
      .style('text-anchor', 'middle')
      .text(title);

    return yAxisG2;
  };

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

    const xAxisG = createXAxis(viewPort, lgc);

    const yAxisG = createYAxis(viewPort, lgc, ySeries[0].axisTitle);

    _.forEach(ySeries, (s) => {
      s.scale = d3.scaleLinear()
        .domain(s.domain)
        .range([lgc.innerHeight, 0]);
    });

    if(lgc.separateScales) {
      //TODO correlate which series correspond to the second yAxis
      const yAxisG2 = createSecondYAxis(viewPort, lgc, ySeries[1].axisTitle);
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

    var xAxis = d3.axisBottom()
      .scale(xScale)
      .tickPadding(15)
      .tickFormat(d3.format(""))
      .tickSize(-lgc.innerHeight);

    applyIf.apply(xAxis, [{'tickValues': lgc.xTickValues}]);

    xAxisG.call(xAxis);

    const yAxis = d3.axisLeft()
      .scale(ySeries[0].scale)
      //.scale(yScale1)
      .tickPadding(15)
      //.tickFormat(d3.format('.0s'))
      .tickSize(-lgc.innerWidth);

    //applyIf.apply(yAxis, [{'tickValues': lgc.yTickValues}]);
    yAxisG.call(yAxis);

    if (baseLine.point != undefined) {
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
    }

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
    console.log(series);

    const line = d3.line()
      .defined(d => d.yval != null)
      .x(d => xScale(d.xval))
      .y((d, i, allData) => {
        //debugger;
        let v = allData.scale(d.yval);
        //console.log(`${d.yval}, ${v}`);
        return v;
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

    addLegends(svg, lgc);

    lgh.svg = svg;
    return svg;
  }

  lgh.clean = function() {
    if(!_.isNil(lgh.svg))
      lgh.svg.selectAll('*').remove();
  }

  return lgh;
})();


