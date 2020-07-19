const lineGraphHelper = (function () {
  const lgh = {};

  lgh.draw = function (svgId, idGraph, data) {

    const svg = d3.select(`#${svgId}`);
    const config = lineGraphConfigs[idGraph];

    const defaults = {
      width: svg.attr('width'),
      height: svg.attr('height'),
      margin: {left: 60, right: 20, top: 20, bottom: 55},
      seriesNames: _.slice(data.columns, 1),
      xSeriesName: data.columns[0],
      colorSchema: d3.schemeSet2,
      xTickValues: null,
      yTickValues: null,
      baseLine: {},
      yDomain2: {}
    };

    const lgc = _.merge(defaults, config);
    console.log(lgc);

    const margin = lgc.margin;
    const [width, height] = [lgc.width, lgc.height];
    //const svg = lgc.svg;
    const xAxisTitle = lgc.xAxisTitle;
    const yAxisTitle = lgc.yAxisTitle;
    const seriesNames = lgc.seriesNames;
    const xSeriesName = lgc.xSeriesName;
    const xDomain = lgc.xDomain;
    const yDomain = lgc.yDomain;
    const baseLine = lgc.baseLine;
    const xTickValues = lgc.xTickValues;
    const yTickValues = lgc.yTickValues;
    //const data = lgc.data;
    const colorSchema = d3.schemeSet2;

    const innerWidth = width - margin.left - margin.right;
    const innerHeight = height - margin.top - margin.bottom;

    function applyIf(props) {
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

    const series = _.reduce(data, (memo, row) => {
      //debugger;
      _.forEach(memo, (e) => {
        e.values.push({
          'xval': row[xSeriesName],
          'yval': row[e.name]
        });
      });
      return memo;
    }, _.map(seriesNames, (s) => ({name: s, values: []})));
    //console.log(series);

    var g = svg.append("g")
      .attr("transform",
        `translate(${margin.left}, ${margin.top})`);
    var xAxisG = g.append('g')
      .attr('transform', `translate(0, ${innerHeight})`);

    var yAxisG = g.append('g');
    // Add X axis
    xAxisG.append('text')
      .attr('class', 'axis-label')
      .attr('x', innerWidth / 2)
      .attr('y', 40)
      .text(xAxisTitle);

    yAxisG.append('text')
      .attr('class', 'axis-label')
      .attr('x', -innerHeight / 2)
      .attr('y', -40)
      .attr('transform', `rotate(-90)`)
      .style('text-anchor', 'middle')
      .text(yAxisTitle);

    var colors = d3.scaleOrdinal()
      .domain(seriesNames)
      .range(colorSchema);

    //console.log(_.map(data, d => +d.year));

    var xScale = d3.scaleLinear()
      //.domain(_.map(data, d => +d.year))
      .domain(xDomain)
      .range([0, innerWidth]);

    //console.log(_.map(data, d => xScale(+d.year)));

    // Add Y axis
    var yScale = d3.scaleLinear()
      .domain(yDomain)
      .range([innerHeight, 0]);

    var xAxis = d3.axisBottom()
      .scale(xScale)
      .tickPadding(15)
      .tickFormat(d3.format(""))
      //.tickValues(xTickValues)
      .tickSize(-innerHeight);

    applyIf.apply(xAxis, [{'tickValues': xTickValues}]);

    //const yTicks = 5;
    var yAxis = d3.axisLeft()
      .scale(yScale)
      .tickPadding(15)
      //.tickFormat(d3.format('.0s'))
      .tickSize(-innerWidth);

    applyIf.apply(yAxis, [{'tickValues': yTickValues}]);

    xAxisG.call(xAxis);
    yAxisG.call(yAxis);

    if (baseLine.point != undefined) {
      yAxisG.selectAll("g")
        .filter(d => d == baseLine.point)
        .attr('class', 'baseLine');
      //.style("stroke-width", 2)
      //.style("stroke-dasharray", 6);
    }

    if (!_.isNil(baseLine.text)) {
      g.append('text')
        .attr('class', 'baseLineText')
        .attr('x', baseLine.xy[0])
        .attr('y', baseLine.xy[1])
        .text(baseLine.text);
    }

    var line = d3.line()
      .defined(d => d.yval != null)
      .x(d => xScale(d.xval))
      .y(d => yScale(d.yval));

    g.selectAll("series")
      .data(series)
      .enter()
      .append("path")
      .attr("d", d => line(d.values))
      .attr("stroke", d => colors(d.name))
      .style("stroke-width", 3)
      .style("fill", "none");

    lgh.svg = svg;
    return svg;
  }

  lgh.clean = function() {
    lgh.svg.selectAll('*').remove();
  }

  return lgh;
})();

const lineGraphConfigs = (function () {
  const configs = {};

  configs['glaciers_fig'] = (function () {
    const xDomain = [1955, 2015];
    const yDomain = [-35, 5];
    const gc = {
      width: 550,
      height: 350,
      xAxisTitle: 'Year',
      yAxisTitle: 'Cumulative mass balance',
      //seriesNames: ['scg', 'gg', 'wg'],
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
      baseLine: {
        point: 0
      }
    }

    return gc;
  })();

  configs['growing_season_fig'] = (function() {
    const xDomain = [1890, 2020];
    const yDomain = [-15, 15];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Deviation from average (days)',
      //seriesNames: ['dev'],
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+10, 10),
      baseLine: {
        point: 0,
        text: "Long-term average",
        xy: [20,height/2-43],
      }
    };

    return gc;
  })();

  //ocean_heat_fig
  configs['ocean_heat_fig'] = (function() {
    const xDomain = [1955, 2015];
    const yDomain = [-10, 20];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Ocean heat content (10^22 joules)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+10, 10),
      baseLine: {
        point: 0,
        text: "1971-2000 Average",
        xy: [20,height/2+3],
      }
    };

    return gc;
  })();

  configs['lyme_fig'] = (function() {
    const xDomain = [1990, 2015];
    const yDomain = [0, 12];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Incidents (cases per 100,000 people)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+5, 5)
    };

    return gc;
  })();

  configs['cyclones_fig'] = (function() {
    const xDomain = [1950, 2020];
    const yDomain = [0, 7];
    const yDomain2 = [81.2, 83.2];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Power Dissipation Index',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+10, 10)
    };

    return gc;
  })();

  return configs;

})();
