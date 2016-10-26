define(['dojo/dom', 'dojo/_base/lang', 'dojo/_base/declare', 'dojo/_base/config', 'dojo/request', 'dojo/on', 'dijit/_WidgetBase', 'dijit/_TemplatedMixin', 'dijit/_WidgetsInTemplateMixin', 'dojo/text!./templates/Project.html', 'dijit/form/Button', 'dijit/Dialog', 'dijit/form/TextBox', 'dijit/form/ComboBox', 'dojo/store/Memory'], function(dom, lang, declare, config, request, on, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template, Button, Dialog, TextBox, ComboBox, Memory) {
	return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
		templateString: template,
		
		postCreate: function() {
			this.inherited(arguments);
			
			this.initialise();
			
			this.bindProjectsStoreToDropDown(this.projectsDropDown, JSON.parse(dom.byId('projectsStore').value));
		},
		
		initialise: function() {
			on(this.newProjectButton, 'click', lang.hitch(this, function() {
				this.addNewProjectDialog.show();
			}));
			
			on(this.cancelButton, 'click', lang.hitch(this, function() {
				this.addNewProjectDialog.hide();
			}));
			
			on(this.okButton, 'click', lang.hitch(this, this.sendDataToServer));
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
		
		bindProjectsStoreToDropDown: function(projectsDropDown, projectsStoreData) {
			var projectsStore = new Memory({
				data: projectsStoreData,
				idProperty: 'Id'
			});
			
			projectsDropDown.store = projectsStore;
		}
	});
});