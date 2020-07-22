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
      },
      legends: {
        x: 90,
        y: 190
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
      },
      legends: {
        x: width/4,
        y: 45
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
      //yAxisTitle: '',
      xDomain: xDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+5, 5),
      ySeries: [{
        //name: 'Incidence Rate',
        domain: yDomain,
        styleClass: '',
        axisTitle: 'Incidents (cases per 100,000 people)'
      }]
    };

    return gc;
  })();

  configs['cyclones_fig'] = (function() {
    const xDomain = [1950, 2020];
    const yDomain = [0, 7];
    const yDomain2 = [81.2, 83.2];
    const [width, height] = [600, 350];

    const ySeries = [{
      //name: 'Smoothed Power Dissipation Index',
      domain: yDomain,
      axisTitle: 'Power Dissipation Index'
    }, {
      domain: yDomain2,
      styleClass: 'lineSeriesDashed lineSeriesMid',
      axisTitle: 'Sea surface temperature (F)'
    }];

    const gc = {
      width: width,
      height: height,
      margin: {left: 60, right: 60, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      separateScales: true,
      ySeries: ySeries,
      xDomain: xDomain,
      xTickValues: _.range(xDomain[0], xDomain[1]+10, 10),
      legends: {
        x: 100,
        y: 53
      }
    };

    return gc;
  })();

  configs['ocean-acidity_fig'] = (function() {
    const xDomain = [1985, 2016];
    const yDomain = [250, 500];
    const yDomain2 = [7.95, 8.20];
    const [width, height] = [600, 350];

    const ySeries = [{
      //name: 'Smoothed Power Dissipation Index',
      domain: yDomain,
      styleClass: 'lineSeriesThin',
      axisTitle: 'Disolved carbon dioxide'
    }, {
      domain: yDomain2,
      styleClass: 'lineSeriesThin',
      axisTitle: 'pH (lower pH= more acidic)'
    }];

    const gc = {
      width: width,
      height: height,
      margin: {left: 60, right: 60, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      separateScales: true,
      ySeries: ySeries,
      xDomain: xDomain,
      legends: {
        x: width-180,
        y: 50
      },
      xTickValues: [1985, 1990, 1995, 2000, 2005, 2010, 2015]
    };

    return gc;
  })();

  //arctic-sea-ice_fig
  configs['arctic-sea-ice_fig'] = (function() {
    const xDomain = [1975, 2020];
    const yDomain = [0, 7];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Sea ice extent (million square miles)',
      xDomain: xDomain,
      yDomain: yDomain,
      legends: {
        x: 90,
        y: height-120
      },
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5)
    };

    return gc;

  })();

  //bird-ranges_fig
  configs['bird-ranges_fig'] = (function() {
    const xDomain = [1965, 2015];
    const yDomain = [-20, 80];
    const [width, height] = [550, 350];
    const colorBounds = d3.schemeSet3[5];

    const ySeries = [{
      domain: yDomain,
      axisTitle: 'Average distance moved north (miles)'
    }, {
      domain: yDomain,
      styleClass: 'lineSeriesThin'
    }, {
      domain: yDomain,
      styleClass: 'lineSeriesThin'
    }];

    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      separateScales: false,
      ySeries: ySeries,
      xDomain: xDomain,
      colorScheme: [d3.schemePaired[7], d3.schemePaired[0], d3.schemePaired[1]],
      //colorScheme: d3.schemeSet4,
      xTickValues: _.range(xDomain[0], xDomain[1]+5, 5),
      baseLine: {
        point: 0
      },
      legends: {
        x: 100,
        y: 53,
        bg: {
          width: 155,
          height: 63
        }
      }
    };

    return gc;
  })();

  //ghg-concentrations_fig
  configs['ghg-concentrations_fig'] = (function() {
    const xDomain = [0, 2016];
    const yDomain = [0, 450];
    const [width, height] = [600, 350];
    const gc = {
      margin: {left: 60, right: 20, top: 20, bottom: 55},
      width: width,
      height: height,
      xAxisTitle: 'Year (from CE)',
      yAxisTitle: 'Carbon dioxide concentration (ppm)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 100, 200)
    };

    return gc;

  })();

  //heat-illnesses_fig
  configs['heat-illnesses_fig'] = (function() {
    const xDomain = [2000, 2011];
    const yDomain = [0, 3];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Hospitalizations per 100,000 people',
      xDomain: xDomain,
      yDomain: yDomain
      //xTickValues: _.range(xDomain[0], xDomain[1] + 2, 2)
    };

    return gc;

  })();

  //marine-species_fig
  configs['marine-species_fig'] = (function() {
    const xDomain = [1980, 2016];
    const yDomain = [0, 30];
    const yDomain2 = [50, 0];
    const [width, height] = [600, 350];

    const ySeries = [{
      //name: 'Smoothed Power Dissipation Index',
      domain: yDomain,
      axisTitle: 'Average Distance Moved (miles)'
    }, {
      domain: yDomain2,
      axisTitle: 'Average Change in Depth (feet)'
    }];

    const gc = {
      width: width,
      height: height,
      margin: {left: 60, right: 60, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      separateScales: true,
      ySeries: ySeries,
      xDomain: xDomain,
      xTickValues: _.range(xDomain[0], xDomain[1], 5),
      legends: {
        x: width/3,
        y: 36
      }
    };

    return gc;
  })();

  //sea-level_fig
  configs['sea-level_fig'] = (function() {
    const xDomain = [1880, 2020];
    const yDomain = [-2, 12];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Cumulative sea level change (inches)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 10, 10),
      baseLine: {
        point: 0
      },
      legends: {
        x: width/4,
        y: 50
      }
    };

    return gc;
  })();

  //sea-surface-temp_fig
  configs['sea-surface-temp_fig'] = (function() {
    const xDomain = [1880, 2020];
    const yDomain = [-2, 2];
    const [width, height] = [550, 350];
    const colorBounds = d3.schemeSet3[5];

    const ySeries = [{
      domain: yDomain,
      axisTitle: 'Temperature anomaly (F)'
    }, {
      domain: yDomain,
      styleClass: 'lineSeriesThin'
    }, {
      domain: yDomain,
      styleClass: 'lineSeriesThin'
    }];

    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      separateScales: false,
      ySeries: ySeries,
      xDomain: xDomain,
      colorScheme: [d3.schemeSet3[2], colorBounds, colorBounds],
      xTickValues: _.range(xDomain[0], xDomain[1]+20, 20),
      baseLine: {
        point: 0,
        text: "1971-2000 Average",
        xy: [20,height/2-45],
      }
    };

    return gc;
  })();

  //snow-cover_fig
  configs['snow-cover_fig'] = (function() {
    const xDomain = [1970, 2020];
    const yDomain = [0, 7];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Snow covered area (million square miles)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5)
    };

    return gc;
  })();

  //wildfires_fig
  configs['wildfires_fig'] = (function() {
    const xDomain = [1980, 2015];
    const yDomain = [0, 12];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Area burned (million acres)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
      legends: {
        x: width/4,
        y: 55
      }
    };

    return gc;
  })();


  return configs;

})();
