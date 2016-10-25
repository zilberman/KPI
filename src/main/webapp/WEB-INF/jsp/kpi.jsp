<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>KPI project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script type="text/javascript" src="<c:url value='resources/js/scripts/DojoLocalConfig.js'/>"></script>
 	<script type="text/javascript" src="<c:url value='resources/js/dojo/dojo.js'/>"></script>
	<script type="text/javascript" src="<c:url value='resources/js/scripts/Main.js'/>"></script>
	
	<link rel="stylesheet" href="<c:url value='resources/js/dijit/themes/claro/claro.css'/>">
	<link rel="stylesheet" href="<c:url value='resources/css/kpi.css'/>">
</head>
<body class="claro">
	<h3>KPI Project</h3>
	
	<div style="width: 800px; height: 600px">
		<div data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height: 100%;">
			<div data-dojo-type="dijit/layout/ContentPane" title="Home" data-dojo-props="selected:true">
				<div id="homeContainer"></div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="Projects">
	            	<p>This is page containing projects</p>
	            	
	            	<div>
	            		<button id="newProjectButton" data-dojo-type="dijit/form/Button" class="buttonWithPadding">Add new project</button>
	            	</div>
	            	
	            	<select data-dojo-type="dijit/form/ComboBox" id="projectsDropDown"></select>
	            	
	            	<input type="hidden" id="projectsStore" value='${projects}' />
	            	
	            	<div data-dojo-type="dijit/Dialog" id="addNewProjectDialog" title="Add new project">
	            		<div class="dijitDialogPaneContentArea">
	            			<table>
	            				<tr>
	            					<td>
	            						<label for="projectName">Project name:</label>
	            					</td>
	            					<td>
	            						<input data-dojo-type="dijit/form/TextBox" type="text" name="projectName" id="projectName"/>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>
	            						<label for="code">Code:</label>
	            					</td>
	            					<td>
	            						<input data-dojo-type="dijit/form/TextBox" type="text" name="code" id="code"/>
	            					</td>
	            				</tr>
	            			</table>
	            		</div>
	            		<div class="dijitDialogPaneActionBar">
        					<button data-dojo-type="dijit/form/Button" type="button" id="okButton">OK</button>
        					<button data-dojo-type="dijit/form/Button" type="button" id="cancelButton">Cancel</button>
    					</div>
	            	</div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="KPIs">
	        	<div id="kpiContainer"></div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="Metrics">
	        	<div id="metricContainer"></div>
	        </div>
		</div>
	</div>
</body>
</html>