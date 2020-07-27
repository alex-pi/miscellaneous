
const graphUtils = (function(){

  const utils = {};

  utils.createXAxis = function(g, conf) {
    var xAxisG = g.append('g')
      .attr('transform', `translate(0, ${conf.innerHeight})`);

    xAxisG.append('text')
      .attr('class', 'axis-label')
      .attr('x', conf.innerWidth / 2)
      .attr('y', 40)
      .text(conf.xAxisTitle);

    return xAxisG;
  };

  utils.createYAxis = function(g, conf, title) {
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

  utils.createSecondYAxis = function(g, conf, title) {
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
  }

  utils.addAnnotation = function(conf) {

    const annXOffset = (conf.xOffSet || 0) + conf.x;
    const annYOffset = (conf.yOffSet || 0) + conf.y;
    const annotation = conf.g
      .append('g')
      //.style('background-color', '#7b7a7a')
      .attr('transform', `translate(${annXOffset},${annYOffset})`);
      //.attr('transform', `translate(${conf.x},${conf.y})`);

    annotation.append('text')
      //.attr('x', 10)
      //.attr('y', 0)
      //.attr('alignment-baseline', 'middle')
      .attr('class', 'indAnnotations')
      .attr('text-anchor', 'middle')
      .text(conf.text);

    console.log(annotation.select('text').node().getBBox());
    if(conf.markPoint) {
      conf.g
        .append('circle')
        .attr('cx', conf.x)
        .attr('cy', conf.y)
        .attr("opacity", .6)
        .attr("fill", 'green')
        //.attr("stroke", "gray")
        .attr('r', 10);

      conf.g.append("polyline")
        .attr("stroke", "green")
        .attr("opacity", .6)
        //.style("fill", "green")
        .attr("stroke-width", 2)
        .style("stroke-dasharray", 2)
        .attr("points", `${annXOffset},${annYOffset} , ${conf.x},${conf.y}`);
    }
  };

  utils.addLegends = function(conf) {

    const glegends = conf.svg
      .append('g')
      //.style('background-color', '#7b7a7a')
      .attr('transform', `translate(${conf.x},${conf.y})`);

    if(!_.isNil(conf.bg)) {
      glegends.append("rect")
        .attr('y', -10)
        .attr("width", conf.bg.width)
        .attr("height", conf.bg.height)
        .attr("fill", '#F8F8F8');
    }

    const glegend = glegends.selectAll('g')
      .data(conf.legendsData).enter()
      .append('g')
      .attr('transform', (d, i) => `translate(10,${i * 20})`);

    glegend.append('circle')
      .attr('r', 4.2)
      .attr("fill", conf.colors);

    glegend.append('text')
      .attr('x', 10)
      //.attr('y', 0)
      .attr('alignment-baseline', 'middle')
      .attr('class', conf.styleClass)
      .text(conf.texts);

    // TODO figure out how to add background to the legends
    //https://stackoverflow.com/questions/32026194/how-to-add-a-background-color-to-d3-text-elements
    //console.log(`glegends : ${glegends.getBBox().height}`);
    /*if(!_.isNil(conf.bg)) {
      debugger;
      glegends.append("rect")
        .attr("width", conf.bg.width)
        .attr("height", conf.bg.height)
        .attr("class", 'xxx');
    }*/

    return glegends;

  };

  utils.calculateElementPosition = function(elementId) {
    let element = document.querySelector(elementId);
    let bodyRect = document.body.getBoundingClientRect(),
      elemRect = element.getBoundingClientRect(),
      offsettop   = elemRect.top - bodyRect.top,
      offsetleft   = elemRect.left - bodyRect.left;

    console.log(bodyRect);
    console.log(elemRect);
    console.log(`${offsetleft} , ${offsettop}`);

    return {
      left: offsetleft,
      top: offsettop
    }
  };

  utils.applyIf = function(props) {
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

  utils.show = function(elem) {
    elem.style.display = 'flex';
  }

  utils.hide = function(elem) {
    elem.style.display = 'none';
  }

  utils.clean = function(svg) {
    if(!_.isNil(svg))
      svg.selectAll('*').remove();
  };

  return utils;

})();
