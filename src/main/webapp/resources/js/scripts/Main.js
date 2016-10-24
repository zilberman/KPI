require(['dojo/dom', 'dijit/registry', 'dojo/parser', 'dojo/on', 'dojo/request', 'dojo/store/Memory', 'dojo/_base/config', 'dijit/layout/TabContainer',
         'dijit/layout/ContentPane', 'dijit/form/ComboBox', 'dijit/form/Button', 'dijit/Dialog', 'dijit/form/TextBox', 'dojo/domReady!'],
		function(dom, registry, parser, on, request, Memory, config) {
	
	parser.parse();
	
	var newProjectButton = dom.byId('newProjectButton');
	var newProjectDialog = registry.byId('addNewProjectDialog');
	
	var okButton = dom.byId('okButton');
	var cancelButton = dom.byId('cancelButton');
	
	var addNewProject = function() {
		newProjectDialog.show();
	};
	
	var sendDataToServer = function() {
		console.log('Adding new project...');
		
		var projectName = dom.byId('projectName').value;
		var projectCode = dom.byId('code').value;
		
		request.post(config.host + "/project", {
			data: {
				name: projectName,
				code: projectCode
			}
		}).then(function(result) {
			dom.byId('projectsStore').value = result;
			
			bindProjectsStoreToDropDown(registry.byId('projectsDropDown'), JSON.parse(dom.byId('projectsStore').value));
			
			newProjectDialog.hide();
			
			console.log(result);
		});
	};
	
	var bindProjectsStoreToDropDown = function(projectsDropDown, projectsStoreData) {
		var projectsStore = new Memory({
			data: projectsStoreData,
			idProperty: 'Id'
		});
		
		projectsDropDown.store = projectsStore;
	};
	
	on(newProjectButton, 'click', addNewProject);
	
	on(cancelButton, 'click', function() {
		newProjectDialog.hide();
	});
	
	on(okButton, 'click', function() {
		sendDataToServer();
	});

	bindProjectsStoreToDropDown(registry.byId('projectsDropDown'), JSON.parse(dom.byId('projectsStore').value));
});