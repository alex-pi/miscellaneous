//const svg = d3.select('svg');


// TODO rename to graphEventHandler
const nodeHandler = (function() {
  const nh = {};
  let tooltip;
  let node_radius;
  let selectedNode = {};
  let linksel;
  let nodesel;
  let simulation;
  let hooks;

  nh.mouseOverNode = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    console.log('mouseOverNode');
    nh.transitionNodesSize(this, node_radius * 1.6);
    tooltip
      .style('left', `${d3.event.pageX + 10}px`)
      .style('top', `${d3.event.pageY}px`)
      .style('display', 'inline-block')
      .html(`${d.ind_desc}`);
  };

  nh.mouseOutNode = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    console.log('mouseOutNode');
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
    if (d3.event.defaultPrevented) return; // dragged
    //debugger;
    console.log('mouseoverLink');
    d3.select(this).transition()
      .attr('class', 'linkh');
    /*Decide where to show the link text*/
  };

  nh.mouseOutLink = function (d, i) {
    if (d3.event.defaultPrevented) return; // dragged
    //debugger;
    console.log('mouseoverLink');
    d3.select(this).transition()
      .attr('class', 'link');
    /*Decide where to show the link text*/
  };

  nh.transitionNodesSize = function (node, r) {
    d3.select(node).transition()
      //.attr("fill", "black")
      .attr("r", r);
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

  nh.init = function(graph, dataHelper) {
    node_radius = graph.config.node_radius;
    linksel = graph.linksel;
    nodesel = graph.nodesel;
    simulation = graph.simulation;
    tooltip = d3.select("body").append("div").attr("class", "toolTip");
    hooks = graph.config.hooks;
  };

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

const forceGraph = (function(config, eventHandler, dh) {
  const svg = config.svg;
  const [width, height] = [svg.attr('width'), svg.attr('height')];
  const [labelsx, labelsy] = [width - 160, 20]
  //const svg = DOM.svg(width, height);
  const node_radius = config.node_radius;
  //const fg = {};

  const init = function() {
    const simulation = d3.forceSimulation()
      .force('link', d3.forceLink()
        .distance(50)
        .id(d => d.ind_id))
      .force('charge', d3.forceManyBody().strength(-40))
      .force('center', d3.forceCenter(width / 2 - 130, height / 2 - 40))
      .nodes(dh.nodes);
    //.alphaMin(0.222);

    simulation.force('link').links(dh.links);

    const ggraph = svg.append('g');

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
    //.on('click', clicked);

    nodesel.append('circle')
      .attr('id', d => d.ind_id)
      .attr("fill", (d, i) => d3.schemeTableau10[d.cat_id - 1])
      .attr('r', node_radius);

    nodesel.selectAll("circle")
      /*.call(d3.drag()
                .on('start', dragstarted)
                .on('drag', dragged)
                .on('end', dragended)
             )*/
      .on('click', eventHandler.clickedNode)
      .on('mouseover', eventHandler.mouseOverNode)
      .on('mouseout', eventHandler.mouseOutNode);


    graphUtils.addLegends({
      svg: svg,
      x: labelsx,
      y: labelsy,
      colors: function(d, i) {
        return d3.schemeTableau10[d.cat_id - 1];
      },
      legendsData: dh.indsByCategory,
      texts: function (d, i) {
        return d.cat_desc;
      },
      styleClass: 'glegends'
    });

    const graphConfig =  {
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

const main = (function() {
  const mo = {};

  const hooks = {
    clickedNode: function (selectedNode, previousNode) {
        console.log('hook!');
        if (!_.isEmpty(previousNode)) {
          lineGraphHelper.clean();
        }
        const figId = selectedNode.d.fig_id;
        if(_.isNil(figId)) {
          console.log(`fig_id not found for node: ${selectedNode.d.ind_desc}`);
          return;
        }
        dataHelper.loadData(figId, `data/${figId}.csv`)
          .then( data => {
            const svg = lineGraphHelper.draw('ind_fig', figId, data);
            const indDetails = dataHelper.find('fig_id', figId);
            $('#ind_overview q').text(indDetails.ind_text);
            //setTimeout( () => svg.selectAll('*').remove(), 3000);
          });
    }
  };

  mo.init = async function() {
     mo.graphData = await dataHelper.init();
     mo.svgForceGraph = d3.select('#main-graph');
     mo.geh = nodeHandler();
     mo.fg = forceGraph({
      svg: mo.svgForceGraph,
      node_radius: 13,
      hooks: hooks
    }, mo.geh, mo.graphData);
  };

  return mo;

})();




