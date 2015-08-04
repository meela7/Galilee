<!DOCTYPE html>
<%   
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setDateHeader("Expires",0);   
if (request.getProtocol().equals("HTTP/1.1")) 
        response.setHeader("Cache-Control", "no-cache"); 
%>  
<html ng-app="dmsApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Data Model Management</title>

<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<style type="text/css">
.top-buffer {
	margin-top: 10px;
}

.pagination-centered {
    text-align: center;
}


a.nodecoration {
	text-decoration: none;
}
</style>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-route.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-resource.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-cookies.min.js"></script>
<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.1.js"></script>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Galilee</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="#site-list">Manage Site</a></li>
					<li><a href="#river-list">Manage River</a></li>
					<li><a href="#source-list">Manage Source</a></li>
					<li><a href="#feature-list">Manage Feature</a></li>
				</ul>
			</div>
			
		</nav>
	</div>
	<div class="container">
		<div ng-view></div>
	</div>

	<script src="resources/js/app.js"></script>
	<script src="resources/js/controllers.js"></script>
	<script src="resources/js/services.js"></script>
	<script src="resources/js/directives.js"></script>
	<script src="resources/js/filters.js"></script>
	<script src="resources/js/smart-table.debug.js"></script>

</body>
</html>