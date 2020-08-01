const graphConfigs = (function () {
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
        point: 0,
        text: 'Negative values indicate loss of mass',
        xy: [270, 30]
      },
      legends: {
        x: 90,
        y: 190,
        bg: {
          width: 144,
          height: 60
        }
      }
    }

    return gc;
  })();

  configs['growing_season_fig'] = (function () {
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
      xTickValues: _.range(xDomain[0], xDomain[1] + 10, 10),
      baseLine: {
        point: 0,
        text: "Long-term average",
        xy: [20, height / 2 - 43]
      },
      annotations: [{
        text: point => `${point.yval.toFixed(2)} days deviation from average`,
        xDataPoint: 2015,
        yOffSet: 170,
        xOffSet: -120,
        seriesIndex: 0,
        markPoint: true
      }, {
        text: point => `A steady increase started in ${point.xval}`,
        xDataPoint: 1980,
        yOffSet: -80,
        xOffSet: -40,
        seriesIndex: 0,
        markPoint: true
      }]
    };

    return gc;
  })();

  //ocean_heat_fig
  configs['ocean_heat_fig'] = (function () {
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
      xTickValues: _.range(xDomain[0], xDomain[1] + 10, 10),
      baseLine: {
        point: 0,
        text: "1971-2000 Average (set at zero for reference)",
        xy: [5, height / 2 -13],
      },
      legends: {
        x: width / 4,
        y: 45,
        bg: {
          width: 70,
          height: 60
        }
      },
      freeTexts: [{
        x: 290,
        y: 33,
        text: 'Ocean heat measured by',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 290,
        y: 48,
        text: 'different agencies',
        styleClass: 'indAnnotationsSmall'
      }]
    };

    return gc;
  })();

  configs['lyme_fig'] = (function () {
    const xDomain = [1990, 2015];
    const yDomain = [0, 12];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      //yAxisTitle: '',
      xDomain: xDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
      ySeries: [{
        domain: yDomain,
        styleClass: '',
        axisTitle: 'Incidents (cases per 100,000 people)'
      }],
      annotations: [{
        text: '3.74 reported cases',
        xDataPoint: 1991,
        yOffSet: 55,
        xOffSet: 80,
        seriesIndex: 0,
        markPoint: true
      },{
        text: '7.95 reported cases',
        xDataPoint: 2014,
        yOffSet: -58,
        xOffSet: -55,
        seriesIndex: 0,
        markPoint: true
      }],
      freeTexts: [{
        x: 120,
        y: 20,
        text: 'Lyme disease in the United States',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 120,
        y: 35,
        text: 'has approximately doubled since 1991',
        styleClass: 'indAnnotationsSmall'
      }]
    };

    return gc;
  })();

  configs['cyclones_fig'] = (function () {
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
      xTickValues: _.range(xDomain[0], xDomain[1] + 10, 10),
      legends: {
        x: 85,
        y: 53,
        bg: {
          width: 277,
          height: 41
        }
      },
      annotations: [{
        text: 'Divergence from temperature',
        xDataPoint: 2007,
        yOffSet: 100,
        xOffSet: -60,
        seriesIndex: 0,
        markPoint: true
      }]
    };

    return gc;
  })();

  configs['ocean-acidity_fig'] = (function () {
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
        x: width - 180,
        y: 240,
        bg: {
          width: 92,
          height: 37
        }
      },
      xTickValues: [1985, 1990, 1995, 2000, 2005, 2010, 2015],
      freeTexts: [{
        x: 120,
        y: 20,
        text: 'As the disolved CO2 increases',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 120,
        y: 35,
        text: 'the pH decreases.',
        styleClass: 'indAnnotationsSmall'
      }]
    };

    return gc;
  })();

  //arctic-sea-ice_fig
  configs['arctic-sea-ice_fig'] = (function () {
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
        y: height - 120,
        bg: {
          width: 170,
          height: 41
        }
      },
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
      annotations: [{
        text: 'Lowest extent on record for September',
        xDataPoint: 2016,
        yOffSet: -53,
        xOffSet: -90,
        seriesIndex: 0,
        markPoint: true
      },{
        text: 'Lowest extent on record for March',
        xDataPoint: 2015,
        yOffSet: 30,
        xOffSet: -80,
        seriesIndex: 1,
        markPoint: true
      }]
    };

    return gc;

  })();

  //bird-ranges_fig
  configs['bird-ranges_fig'] = (function () {
    const xDomain = [1965, 2015];
    const yDomain = [-20, 80];
    const [width, height] = [550, 350];
    //const colorBounds = d3.schemeSet3[5];

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
      xAxisTitle: "Each Year's winter",
      separateScales: false,
      ySeries: ySeries,
      xDomain: xDomain,
      colorScheme: [d3.schemePaired[7], d3.schemePaired[0], d3.schemePaired[1]],
      //colorScheme: d3.schemeSet4,
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
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
      },
      annotations: [{
        text: '305 species have moved an average of 40 miles north',
        xDataPoint: 2013,
        yOffSet: 140,
        xOffSet: -150,
        seriesIndex: 0,
        markPoint: true
      }]
    };

    return gc;
  })();

  //ghg-concentrations_fig
  configs['ghg-concentrations_fig'] = (function () {
    const xDomain = [0, 2016];
    const yDomain = [240, 450];
    const [width, height] = [600, 350];
    const gc = {
      margin: {left: 60, right: 20, top: 20, bottom: 55},
      width: width,
      height: height,
      xAxisTitle: 'Year (from CE)',
      yAxisTitle: 'Carbon dioxide concentration (ppm)',
      xDomain: xDomain,
      yDomain: yDomain,
      xTickValues: _.range(xDomain[0], xDomain[1] + 100, 200),
      annotations: [{
        text: 'Beginning of the industrial era',
        xDataPoint: (dp) => dp.xval >= 1760 && !_.isNil(dp.yval),
        yOffSet: -86,
        xOffSet: -80,
        seriesIndex: 1,
        markPoint: true
      }],
      freeTexts: [{
        x: 200,
        y: 80,
        text: 'Each colored line are measures from a different ice core.',
        styleClass: 'indAnnotationsSmall'
      }]
    };

    return gc;

  })();

  //heat-illnesses_fig
  configs['heat-illnesses_fig'] = (function () {
    const xDomain = [2000, 2011];
    const yDomain = [0, 3];
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      xAxisTitle: 'Year',
      yAxisTitle: 'Hospitalizations per 100,000 people',
      xDomain: xDomain,
      yDomain: yDomain,
      freeTexts: [{
        x: 270,
        y: 255,
        text: 'Pattern matches the data for heat related deaths',
        styleClass: 'indAnnotationsSmall'
      }],
      annotations: [{
        text: '2.5 cases',
        xDataPoint: 2006,
        yOffSet: -30,
        xOffSet: -80,
        seriesIndex: 0,
        markPoint: true
      },{
        text: '1.1 cases',
        xDataPoint: 2004,
        yOffSet: 40,
        xOffSet: 10,
        seriesIndex: 0,
        markPoint: true
      }]
      //xTickValues: _.range(xDomain[0], xDomain[1] + 2, 2)
    };

    return gc;

  })();

  //marine-species_fig
  configs['marine-species_fig'] = (function () {
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
        x: width / 5,
        y: 36,
        bg: {
          width: 186,
          height: 38
        }
      },
      annotations: [{
        text: 'Moved northward about 10 mi',
        xDataPoint: 2015,
        yOffSet: -30,
        xOffSet: -83,
        seriesIndex: 0,
        markPoint: true
      },{
        text: 'Moved 20 feet deeper',
        xDataPoint: 2015,
        yOffSet: 20,
        xOffSet: -75,
        seriesIndex: 1,
        markPoint: true
      }]
    };

    return gc;
  })();

  //sea-level_fig
  configs['sea-level_fig'] = (function () {
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
        x: width / 4,
        y: 50,
        bg: {
          width: 190,
          height: 40
        }
      },
      freeTexts: [{
        x: 130,
        y: 114,
        text: 'Since 1993, average sea level has risen',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 130,
        y: 129,
        text: 'at a rate of 0.11 to 0.14 inches per year',
        styleClass: 'indAnnotationsSmall'
      }]
    };

    return gc;
  })();

  //sea-surface-temp_fig
  configs['sea-surface-temp_fig'] = (function () {
    const xDomain = [1880, 2020];
    const yDomain = [-2, 2];
    const [width, height] = [550, 350];
    const colorBounds = '#9acb8d';

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
      colorScheme: [d3.schemeSet3[3], '#8da0cb', '#9acb8d'],
      xTickValues: _.range(xDomain[0], xDomain[1] + 20, 20),
      baseLine: {
        point: 0,
        text: "1971-2000 Average",
        xy: [20, height / 2 - 45],
      },
      legends: {
        x: 80,
        y: 40,
        bg: {
          width: 198,
          height: 62
        }
      },
      annotations: [{
        text: "Sea surface temperature has been increasing since 1970",
        xDataPoint: 1970,
        yOffSet: 100,
        xOffSet: -80,
        seriesIndex: 0,
        markPoint: true
      }]
    };

    return gc;
  })();

  //snow-cover_fig
  configs['snow-cover_fig'] = (function () {
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
      xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5),
      annotations: [
        {
          text: 'Snow cover in Winter has been steady',
          xDataPoint: 1990,
          yOffSet: -20,
          xOffSet: 10,
          styleClass: 'indAnnotationsSmall'
        },
        {
          text: 'Snow cover in Spring has decreased',
          xDataPoint: 1990,
          yOffSet: -30,
          xOffSet: 10,
          styleClass: 'indBadAnnotationsSmall'
        },
        {
          text: 'Snow cover in Summer has decrease',
          xDataPoint: 1990,
          yOffSet: -30,
          xOffSet: 10,
          styleClass: 'indBadAnnotationsSmall'
        },
        {
          text: 'Snow cover in Fall has been steady',
          xDataPoint: 1990,
          yOffSet: -34,
          xOffSet: 10,
          styleClass: 'indAnnotationsSmall'
        }
      ]
    };

    return gc;
  })();

  //wildfires_fig
  configs['wildfires_fig'] = (function () {
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
        x: width / 2,
        y: 280,
        bg: {
          width: 196,
          height: 17
        }
      },
      annotations: [{
        text: 'Peaks coincide with warmest years on record',
        xDataPoint: 2006,
        yOffSet: -30,
        xOffSet: -80,
        seriesIndex: 0,
        markPoint: true
      }]
    };

    return gc;
  })();

  //global-ghg-emissions
  configs['global-ghg-emissions'] = (function () {
    const [width, height] = [550, 350];
    const gc = {
      width: width,
      height: height,
      margin: {left: 60, right: 20, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      yAxisTitle: 'CO2 Emissions (million metric tons)',
      legends: {
        x: width - 220,
        y: height - 180,
        bg: {
          width: 190,
          height: 120
        }
      },
      freeTexts: [{
        x: 150,
        y: 40,
        text: '35% percent increase from 1990 to 2010',
        styleClass: 'indAnnotationsSmall'
      }]
      //xTickValues: _.range(xDomain[0], xDomain[1] + 5, 5)
    }
    return gc;
  })();

  //heavy-precip_fig
  configs['heavy-precip_fig'] = (function () {
    const [width, height] = [630, 350];
    //const xDomain = [1910, 2020];
    const yDomain = [0, 25];
    const gc = {
      width: width,
      height: height,
      margin: {left: 50, right: 5, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      yAxisTitle: 'Percent of land area',
      yDomain: yDomain,
      yTickValues: _.range(0, 30, 5),
      xTickValues: _.range(1910, 2020, 10),
      barStyle: fn => {
        debugger;
        return d => d[fn] < 10.5? 'neutralBar':'redBar'
      },
      baseLine: {
        point: scale => scale(10.5),
        text: "1910–2015 average is 10.5",
        xy: [158, height / 2 - 25],
      },
      freeTexts: [{
        x: 160,
        y: 20,
        text: 'The percentage of land with extreme',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 160,
        y: 35,
        text: 'single-day precipitation events has increased',
        styleClass: 'indAnnotationsSmall'
      }]
    }
    return gc;
  })();

  //temperature_fig
  configs['temperature_fig'] = (function () {
    const [width, height] = [630, 350];
    //const xDomain = [1910, 2020];
    const yDomain = [-2, 2];
    const gc = {
      width: width,
      height: height,
      margin: {left: 50, right: 5, top: 20, bottom: 55},
      xAxisTitle: 'Year',
      yAxisTitle: 'Temperature anomaly (F)',
      yDomain: yDomain,
      yTickValues: _.range(-3, 5),
      xTickValues: _.range(1900, 2020, 10),
      baseDataPoint: 0,
      barStyle: fieldName => {
        return d => d[fieldName] <= 0? 'blueBar':'redBar'
      },
      baseLine: {
        //point: 0,
        text: "1901–2000 average as a baseline",
        xy: [20, height / 2 - 43],
      }, freeTexts: [{
        x: 120,
        y: 40,
        text: 'Each bar represents the deviation',
        styleClass: 'indAnnotationsSmall'
      },{
        x: 120,
        y: 55,
        text: 'from the baseline for a particular year.',
        styleClass: 'indAnnotationsSmall'
      }]
    }
    return gc;
  })();


  return configs;

})();
