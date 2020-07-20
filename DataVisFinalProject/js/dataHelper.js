const dataHelper = (function() {
  let neighs;
  let nodes;
  let links;
  let indsByCategory;
  let dataCache = {};
  let dataProcessors = {

  };

  const defaultProcessor = function(row) {
    _.forEach(row, (val,key) => {
      row[key] = val==""? null:+val;
    });
    return row;
  };

  const loadData = async function(id, url) {
    if(_.isNil(dataCache[id]))
      dataCache[id] = await d3.csv(`${url}?random=${Math.random()}`, dataProcessors[id] || defaultProcessor);
    //_.map(p, dataProcessors.id)

    return dataCache[id];
  }

  const find = function(field, val) {
    return _.find(nodes, (n) => n[field] === val);
  };

  const init = async function() {
    links = await d3.json('data/epa-indicators-links.json');
    indsByCategory = await d3.json(`data/epa-indicators.json?random=${Math.random()}`);

    neighs = _.reduce(links, (memo, e) => {
      const ids = e.source;
      const idt = e.target;
      memo[ids] = _.concat(memo[ids] || [], idt);
      memo[idt] = _.concat(memo[idt] || [], ids);
      //debugger;
      return memo;
    }, {});

    nodes = _.reduce(indsByCategory, (memo, d) => {
      let ind = _.map(d.indicators, ei => {
        ei['cat_id'] = d.cat_id;
        ei['cat_desc'] = d.cat_desc;
        ei['links'] = neighs[ei.ind_id];
        return ei;
      });
      return _.concat(memo, ind);
    }, []);

    return {
      nodes: nodes,
      links: links,
      indsByCategory: indsByCategory
    };
  };

  return {
    init: init,
    loadData: loadData,
    find: find
  };

})();
