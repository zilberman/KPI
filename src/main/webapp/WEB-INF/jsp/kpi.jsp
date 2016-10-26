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
	<link rel="stylesheet" href="<c:url value='resources/js/kpiWidgets/css/Project.css'/>">
</head>
<body class="claro">
	<h3>KPI Project</h3>
	
	<div style="width: 800px; height: 600px">
		<div data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height: 100%;">
			<div data-dojo-type="dijit/layout/ContentPane" title="Home" data-dojo-props="selected:true">
				<div id="homeContainer"></div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="Projects">
	            <div id="projectContainer"></div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="KPIs">
	        	<div id="kpiContainer"></div>
	        </div>
	        <div data-dojo-type="dijit/layout/ContentPane" title="Metrics">
	        	<div id="metricContainer"></div>
	        </div>
		</div>
	</div>
	
	<input type="hidden" id="projectsStore" value='${projects}'/>
</body>
</html>