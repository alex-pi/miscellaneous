//const svg = d3.select('svg');


// TODO rename to graphEventHandler
const nodeHandler = (function () {
  const nh = {};
  let svgGraph;
  let svgOffSets;
  let tooltip;
  let linkTooltip;
  let linkTooltipTitle;
  let linkTooltipText;
  let node_radius;
  let selectedNode = {};
  let linksel;
  let nodesel;
  let simulation;
  let hooks;

  nh.mouseOverNode = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    //console.log('mouseOverNode');
    nh.transitionNodesSize(this, node_radius * 1.6);
    console.log(`${d3.event.pageX + 10}px , ${d3.event.pageY}px`);

    showNodesToolTip([d]);
  };

  nh.mouseOutNode = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    //console.log('mouseOutNode');
    tooltip.style('display', 'none');
    if (!_.isEmpty(selectedNode) && d.ind_id == selectedNode.d.ind_id) return;
    nh.transitionNodesSize(this, node_radius);
  };

  nh.clickedNode = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    console.log('clickedNode');
    const previousNode = selectedNode;
    if (!_.isEmpty(selectedNode)) {
      d3.select(selectedNode.circle).transition()
        .attr("r", node_radius)
        .style('opacity', 0.72)
        .attr("fill", d3.schemeTableau10[selectedNode.d.cat_id - 1]);
    }
    d3.select(this).transition()
      //.attr("fill", "black")
      .attr("r", node_radius * 1.6);
    selectedNode = {
      d: d,
      circle: this
    };
    hooks.clickedNode(selectedNode, previousNode);
  };

  nh.mouseOverLink = function (d, i) {
    if (d3.event.defaultPrevented) return;
    //debugger;
    console.log('mouseoverLink');
    d3.select(this).transition()
      .attr('class', 'linkh');

    linkTooltip
      .style('left', `${linkTooltip.calcPosition.x}px`)
      .style('top', `${linkTooltip.calcPosition.y}px`)
      .style('display', 'inline-block');
    linkTooltipText.html(`${d.desc}`);
    linkTooltipTitle.html(`${d.source.ind_desc} and  ${d.target.ind_desc}`);
  };

  nh.mouseOutLink = function (d, i) {
    if (d3.event.defaultPrevented) return;
    console.log('mouseoverLink');
    d3.select(this).transition()
      .attr('class', 'link');
    linkTooltip.style('display', 'none');
  };

  nh.transitionNodesSize = function (node, r) {
    d3.select(node).transition()
      //.attr("fill", "black")
      .attr("r", r);
  };

  nh.showAffords = function(d, i) {
    svgGraph.selectAll('line')
      .transition()
      .attr('class', 'linkh');

    svgGraph.selectAll('circle.affordOff')
      .transition()
      .attr('class', 'affordOn');
  };

  nh.hideAffords = function(d, i) {
    svgGraph.selectAll('line')
      .transition()
      .attr('class', 'link');

    svgGraph.selectAll('circle.affordOn')
      .transition()
      .attr('class', 'affordOff');
  };

  nh.drag = d3.drag()
    .on("start", dragstarted)
    .on("drag", dragged)
    .on("end", dragended);

  nh.ticked = function ticked() {
    linksel.attr('x1', d => d.source.x)
      .attr('y1', d => d.source.y)
      .attr('x2', d => d.target.x)
      .attr('y2', d => d.target.y);

    nodesel.attr('transform', d => `translate(${d.x}, ${d.y})`);
  };

  nh.init = function (graph, dataHelper) {
    svgGraph = graph.config.svg;
    node_radius = graph.config.node_radius;
    linksel = graph.linksel;
    nodesel = graph.nodesel;
    simulation = graph.simulation;
    //tooltip = d3.select("body").append("div").attr("class", "toolTip");
    tooltip = d3.select("#nodesTooltip.toolTip");
    //linkTooltip = d3.select("body").append("div").attr("class", "toolTip");
    linkTooltip = d3.select("#linksTooltip");
    linkTooltipTitle = d3.select("#linksTooltip #title");
    linkTooltipText = d3.select("#linksTooltip #text");
    nh.calculateLinkTooltipPosition();
    hooks = graph.config.hooks;

  };

  nh.calculateLinkTooltipPosition = function () {
    const pos = graphUtils.calculateElementPosition('#main-graph');

    svgOffSets = pos;

    linkTooltip.calcPosition = {
      x: pos.left + 500,
      y: pos.top + 150
    };
  };

  function showNodesToolTip(nodesD) {
    _.forEach(nodesD, nd => {
      //const x = nd
      tooltip
        //.style('left', `${d3.event.pageX + 10}px`)
        //.style('top', `${d3.event.pageY}px`)
        .style('left', `${svgOffSets.left + nd.x + 10}px`)
        .style('top', `${svgOffSets.top + nd.y}px`)
        .style('display', 'inline-block')
        .html(`${nd.ind_desc}`);
    });
  }

  function dragstarted(d) {
    if (!d3.event.active)
      simulation.alphaTarget(0.19).restart();
    d.fx = d.x;
    d.fy = d.y;
  };

  function dragged(d) {
    d.fx = d3.event.x;
    d.fy = d3.event.y;
  };

  function dragended(d) {
    if (!d3.event.active)
      simulation.alphaTarget(0);
    d.fx = null;
    d.fy = null;
  };

  return nh;
});

const forceGraph = (function (config, eventHandler, dh) {
  const svg = config.svg;
  const [width, height] = [svg.attr('width'), svg.attr('height')];
  const [labelsx, labelsy] = [10, 20]
  //const svg = DOM.svg(width, height);
  const node_radius = config.node_radius;
  //const fg = {};

  const init = function () {
    const simulation = d3.forceSimulation()
      .force('link', d3.forceLink()
        .distance(50)
        .id(d => d.ind_id))
      .force('charge', d3.forceManyBody().strength(-40))
      .force('center', d3.forceCenter(width / 2 - 20, height / 2 - 20))
      .nodes(dh.nodes);
    //.alphaMin(0.222);

    simulation.force('link').links(dh.links);

    const ggraph = svg.append('g');
    //.attr('transform', `translate(0,0)`);

    const linksel = ggraph
      .selectAll('.link') // difference between selecting .link vs line
      .data(dh.links).enter()
      //.append('g')
      .append('line')
      .attr('class', 'link')
      .attr('id', dl => `${dl.source.ind_id}:${dl.target.ind_id}`)
      .on('mouseover', eventHandler.mouseOverLink)
      .on('mouseout', eventHandler.mouseOutLink);

    const nodesel = ggraph
      .selectAll('.node')
      .data(dh.nodes)
      .enter().append('g')
      .attr('class', 'node')
      .call(eventHandler.drag);

    nodesel.append('circle')
      .attr('class', 'affordOff')
      .attr('id', d => d.ind_id)
      .attr("fill", (d, i) => d3.schemeTableau10[d.cat_id - 1])
      .attr('r', node_radius);

    nodesel.selectAll("circle")
      .on('click', eventHandler.clickedNode)
      .on('mouseover', eventHandler.mouseOverNode)
      .on('mouseout', eventHandler.mouseOutNode);

    graphUtils.addAffordanceLegends({
      g: ggraph,
      node_radius: node_radius,
      x: width/2+150,
      y: 30,
      mouseOver: eventHandler.showAffords,
      mouseOut: eventHandler.hideAffords
    });

    graphUtils.addLegends({
      svg: svg,
      x: labelsx,
      y: labelsy,
      colors: function (d, i) {
        return d3.schemeTableau10[d.cat_id - 1];
      },
      legendsData: dh.indsByCategory,
      texts: function (d, i) {
        return d.cat_desc;
      },
      styleClass: 'glegends'
    });

    const graphConfig = {
      ggraph: ggraph,
      linksel: linksel,
      nodesel: nodesel,
      simulation: simulation,
      config: config
    };

    eventHandler.init(graphConfig);

    simulation.on('tick', eventHandler.ticked);

    return graphConfig;
  }

  return init();

});

const main = (function () {
  const mo = {};
  let indSection;
  let indOverview;
  let indFigText;
  let indTitle;
  let bodyPage;
  let svg;

  const hooks = {
    clickedNode: function (selectedNode, previousNode) {
      console.log('hook!');

      if (!_.isEmpty(previousNode)) {
        //indSection.fadeTo('fast', 0);
        graphUtils.clean(svg);
      } else graphUtils.show(indSection);

      const figId = selectedNode.d.fig_id;
      const figType = selectedNode.d.fig_type;
      if (_.isNil(figId)) {
        console.log(`fig_id not found for node: ${selectedNode.d.ind_desc}`);
        return;
      }
      dataHelper.loadData(figId, `data/${figId}.csv`)
        .then(data => {
          if('stackedBars' == figType)
            svg = stackBarsGraphHelper.draw('ind_fig', figId, data);
          else if('bars' == figType)
            svg = barsGraphHelper.draw('ind_fig', figId, data);
          else
            svg = lineGraphHelper.draw('ind_fig', figId, data);
          const indDetails = dataHelper.find('fig_id', figId);
          indTitle.innerHTML = indDetails.ind_desc;
          indOverview.innerHTML = `<q>${indDetails.ind_text}</q>`;
          indFigText.innerHTML = `<q>${indDetails.fig_desc}</q>`;
          //indSection.fadeTo('medium', 1);
        });
    }
  };

  mo.init = async function () {
    indSection = document.getElementById('ind_section');
    graphUtils.hide(indSection);
    indOverview = document.getElementById('ind_overview');
    indFigText = document.getElementById('ind_fig_text');
    indTitle = document.getElementById('ind_title');
    bodyPage = document.getElementById('body_page');
    mo.graphData = await dataHelper.init();
    mo.svgForceGraph = d3.select('#main-graph');
    mo.geh = nodeHandler();
    mo.fg = forceGraph({
      svg: mo.svgForceGraph,
      node_radius: 13,
      hooks: hooks
    }, mo.geh, mo.graphData);

    bodyPage.onresize = mo.geh.calculateLinkTooltipPosition;
  };

  return mo;

})();




