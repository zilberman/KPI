define(['dojo/_base/declare', 'dojo/_base/config', 'dojo/dom', 'dojo/on', 'dojo/request', 'dojo/_base/lang', 'dijit/_WidgetBase', 'dijit/_TemplatedMixin', 'dojo/text!./templates/Kpi.html', 'dijit/_WidgetsInTemplateMixin', 'dijit/form/Button', 'dijit/form/ComboBox', 'dijit/Dialog', 'dijit/form/TextBox', 'dojo/store/Memory'], function(declare, config, dom, on, request, lang, _WidgetBase, _TemplatedMixin, template, _WidgetsInTemplateMixin, Button, ComboBox, Dialog, TextBox, Memory) {
	return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
		templateString: template,
		
		postCreate: function() {
			this.inherited(arguments);
			
			this.initialise();
			
			this.bindKpisStoreToDropDown(this.kpisDropDown, JSON.parse(dom.byId('kpisStore').value));
		},
		
		initialise: function() {
			on(this.newKpiButton, 'click', lang.hitch(this, function() {
				this.addNewKpiDialog.show();
			}));
			
			on(this.cancelButton, 'click', lang.hitch(this, function() {
				this.addNewKpiDialog.hide();
			}));
			
			on(this.okButton, 'click', lang.hitch(this, this.sendDataToServer));
		},
		
		sendDataToServer: function() {
			request.post(config.host + "/kpi", {
				data: {
					name: this.kpiName.value,
				}
			}).then(lang.hitch(this, function(result) {
				dom.byId('kpisStore').value = result;
				
				this.bindKpisStoreToDropDown(this.kpisDropDown, JSON.parse(dom.byId('kpisStore').value));
				
				this.addNewKpiDialog.hide();
			}));
		},
		
		bindKpisStoreToDropDown: function(kpisDropDown, kpisStoreData) {
			var kpisStore = new Memory({
				data: kpisStoreData,
				idProperty: 'Id'
			});
			
			kpisDropDown.store = kpisStore;
		}
	});
});