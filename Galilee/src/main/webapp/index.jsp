<!DOCTYPE html>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>
<html ng-app="dmsApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Data Model Management</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/css/megamenu.css" rel="stylesheet">
<link
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.14.30/css/bootstrap-datetimepicker.min.css"
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
<script type="text/javascript">
	//Dropdown Menu Fade    
	jQuery(document).ready(function() {
		$(".dropdown").hover(function() {
			$('.dropdown-menu', this).stop().fadeIn("fast");
		}, function() {
			$('.dropdown-menu', this).stop().fadeOut("fast");
		});
	});
</script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-route.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-resource.min.js"></script>
<script src="//code.angularjs.org/1.3.1/angular-cookies.min.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.1.js"></script>
<script
	src="//www.flocations.com/static/vendor/angular-ui/event/event.js"></script>
<script
	src="//www.flocations.com/static/vendor/angular-ui/map/ui-map.min.js"></script>
<script src="//maps.googleapis.com/maps/api/js?sensor=false&.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.14.30/js/bootstrap-datetimepicker.min.js"></script>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><span
						class="glyphicon glyphicon-home"></span> NAEMP</a>
				</div>

				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">

						<li class="dropdown menu-large"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> Domain Data Management <b class="caret"></b>
						</a>
							<ul class="dropdown-menu megamenu row">
								<li class="col-sm-3">
									<ul>
										<li class="dropdown-header">Location</li>
										<li><a href="#site-list"> Site</a></li>
										<li><a href="#river-list"> River</a></li>
										<li><a href="#siteCode-list"> Site Code</a></li>
									</ul>
								</li>
								<li class="col-sm-3">
									<ul>
										<li class="dropdown-header">Biodiversity</li>
										<li><a href="#feature-list"> Feature</a></li>
										<li><a href="#fish-list"> Fish</a></li>
									</ul>
								</li>
								<li class="col-sm-3">
									<ul>
										<li class="dropdown-header">Etc.</li>
										<li><a href="#variable-list"> Variable</a></li>
										<li><a href="#unit-list"> Unit</a></li>
										<li><a href="#source-list"> Source</a></li>
										<li><a href="#method-list"> Method</a></li>
									</ul>
								</li>
							</ul></li>
						<li class="dropdown menu-large"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> Data
								Search <b class="caret"></b>
						</a>
							<ul class="dropdown-menu megamenu row">
								<li class="col-sm-3">
									<ul>
										<li class="dropdown-header">Location</li>
										<li><a href="#river-search"> by River </a></li>
										<li><a href="#site-search"> by Site </a></li>
									</ul>
								</li>
								<li class="col-sm-3">
									<ul>
										<li class="dropdown-header">Biodiversity</li>
										<li><a href="#fish-search"> by Fish </a></li>
										<!-- <li><a href="#feature-search"> by Feature </a></li> -->
									</ul>
								</li>
								
							</ul></li>
						<li><a href="#"> </a></li>
					</ul>
				</div>
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