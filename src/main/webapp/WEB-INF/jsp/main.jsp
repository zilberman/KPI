<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>KPI project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>KPI Project</h2>

		<ul class="nav nav-tabs">
			<c:forEach var="menuItem" items="${menuItems}">
				<li><a data-toggle="tab" href="#${menuItem.key}">${menuItem.key}</a></li>
	  		</c:forEach>
		</ul>
	  
		<div class="tab-content">
			<c:forEach var="menuItem" items="${menuItems}">
				<div class="tab-pane fade" id="${menuItem.key}">
	  				<h3>${menuItem.key}</h3>
	  				<p>${menuItem.value}</p>
	  			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>