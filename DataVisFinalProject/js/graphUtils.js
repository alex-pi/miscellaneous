
const graphUtils = (function(){

  const utils = {};

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
    /*console.log(`glegends : ${glegends.node().getBBox().height}`);
    if(!_.isNil(conf.bg)) {
      debugger;
      glegends.append("rect")
        .attr("width", conf.bg.width)
        .attr("height", conf.bg.height)
        .attr("class", 'xxx');
    }*/

    return glegends;

  };



  return utils;

})();
