define(['dojo/dom', 'dojo/_base/lang', 'dojo/_base/declare', 'dojo/_base/config', 'dojo/request', 'dojo/on', 'dijit/_WidgetBase', 'dijit/_TemplatedMixin', 'dijit/_WidgetsInTemplateMixin', 'dojo/text!./templates/Project.html', 'dijit/form/Button', 'dijit/Dialog', 'dijit/form/TextBox', 'dijit/form/ComboBox', 'dojo/store/Memory', 'dojo/data/ObjectStore', 'dojox/grid/DataGrid'], function(dom, lang, declare, config, request, on, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template, Button, Dialog, TextBox, ComboBox, Memory, ObjectStore, DataGrid) {
	return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
		templateString: template,
		
		postCreate: function() {
			this.inherited(arguments);
			
			this.initialise();
			
			this.bindProjectsStoreToDropDown(this.projectsDropDown, JSON.parse(dom.byId('projectsStore').value));
		},
		
		startup: function() {
			this.createProjectsGrid(JSON.parse(dom.byId('projectsStore').value));
		},
		
		initialise: function() {
			on(this.newProjectButton, 'click', lang.hitch(this, function() {
				this.addNewProjectDialog.show();
			}));
			
			on(this.cancelButton, 'click', lang.hitch(this, function() {
				this.addNewProjectDialog.hide();
			}));
			
			on(this.okButton, 'click', lang.hitch(this, this.sendDataToServer));
			
			on(this.cancelKpiButton, 'click', lang.hitch(this, function() {
				this.assignKpiToProjectDialog.hide();
			}));
			
			on(this.assignKpiButton, 'click', lang.hitch(this, this.assignKpi));
		},
		
		sendDataToServer: function() {
			request.post(config.host + "/project", {
				data: {
					name: this.projectName.value,
					code: this.projectCode.value
				}
			}).then(lang.hitch(this, function(result) {
				dom.byId('projectsStore').value = result;
				
				this.bindProjectsStoreToDropDown(this.projectsDropDown, JSON.parse(dom.byId('projectsStore').value));
				
				this.addNewProjectDialog.hide();
			}));
		},
		
		assignKpi: function() {
			this.assignKpiToProjectDialog.hide();
		},
		
		bindProjectsStoreToDropDown: function(projectsDropDown, projectsStoreData) {
			var projectsStore = new Memory({
				data: projectsStoreData,
				idProperty: 'Id'
			});
			
			projectsDropDown.store = projectsStore;
		},
		
		createProjectsGrid: function(projectsStoreData) {
			var projectsStore = new Memory({data: projectsStoreData});
			
			var dataStore = new ObjectStore({objectStore: projectsStore});
			
			var projectsGrid = new DataGrid({
				store: dataStore,
				query: {Id: '*'},
				structure: [
				       {name: 'Id', field: 'Id', width: "25%", hidden: "true"},
				       {name: 'Name', field: 'name', width: "25%"},
				       {name: 'Code', field: 'code', width: "25%"},
				       {name: 'Status', field: 'status', width: "25%"},
				       {name: 'Started date', field: 'dateStarted', width: "25%"}
				]
			}, 'projectsGrid');
			
			on(projectsGrid, 'RowClick', function(evt) {
				var index = evt.rowIndex;
				var rowData = projectsGrid.getItem(index);
				console.log(rowData.Id);
			});
			
			on(projectsGrid, 'RowDblClick', lang.hitch(this, function(evt) {
				this.assignKpiToProjectDialog.show();
			}));
			
			projectsGrid.startup();
		}
	});
});