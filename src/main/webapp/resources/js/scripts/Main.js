require(['dojo/parser', 'dojo/dom', 'kpiWidgets/Home', 'kpiWidgets/Project', 'kpiWidgets/Kpi', 'kpiWidgets/Metric',
         'dijit/layout/TabContainer', 'dijit/layout/ContentPane', 'dijit/form/Button', 'dojo/domReady!'],
		function(parser, dom, Home, Project, Kpi, Metric) {
	
	parser.parse();
	
	var homeContainer = dom.byId('homeContainer');
	new Home().placeAt(homeContainer);
	
	var projectContainer = dom.byId('projectContainer');
	new Project().placeAt(projectContainer);
	
	var kpiContainer = dom.byId('kpiContainer');
	new Kpi().placeAt(kpiContainer);
	
	var metricContainer = dom.byId('metricContainer');
	new Metric().placeAt(metricContainer);
});