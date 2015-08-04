<!DOCTYPE html>
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
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<style type="text/css">
.top-buffer {
	margin-top: 10px;
}

.movietable tr td:nth-child(2) {
	width: 150px;
}

.movietable tr:nth-child(1) td {
	border-top: none;
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

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Galilee</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#source-list">Manage Source</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div ng-view></div>
	</div>

	<script type=text/javascript>
		var dmsApp = angular.module("dmsApp", [ 'ngResource', 'ngRoute' ]);

		dmsApp.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/source-list', {
				templateUrl : 'resources/template/source/list.html',
				controller : 'SourceListCtrl'
			}).when('/source-detail/:id', {
				templateUrl : 'resources/template/source/detail.html',
				controller : 'SourceDetailCtrl'
			}).when('/source-creation', {
				templateUrl : 'template/source/creation.html',
				controller : 'SourceCreationCtrl'
			});
		} ]);

		var contextRoot = '/dms';
		dmsApp.factory('SourceFindAll', function($resource) {
			return $resource(contextRoot + '/sources', {}, {
				findall : {
					method : 'GET',
					isArray : true
				}
			})
		});
		dmsApp.factory('SourceFind', function($resource) {
			return $resource(contextRoot + '/sources/:id', {}, {
				find : {
					method : 'GET',
					params : {
						id : '@id'
					}
				},
			})
		});
		dmsApp.factory('SourceCreate', function($resource) {
			return $resource(contextRoot + '/sources/create', {}, {
				create : {
					method : 'POST'
				}
			})
		});
		dmsApp.factory('SourceUpdate', function($resource) {
			return $resource(contextRoot + '/sources/update', {}, {
				update : {
					method : 'POST'
				}
			})
		});
		dmsApp.factory('SourceDelete', function($resource) {
			return $resource(contextRoot + '/sources/delete', {}, {
				del : {
					method : 'POST'
				}
			})
		});

		dmsApp.controller('SourceListCtrl', [ '$scope', 'SourceFindAll',
				'SourceDelete', '$location',
				function($scope, SourceFindAll, SourceDelete, $location) {
					// callback for ng-click 'editSource':
					$scope.editSource = function(sourceID) {
						$location.path('/source-detail/' + sourceID);
					};
					// callback for ng-click 'deleteSource':
					$scope.deleteSource = function(source) {
						SourceDelete.del(source);
						$location.path('/source-list');
					};
					// callback for ng-click 'createSource':
					$scope.createNewSource = function() {
						$location.path('/source-creation');
					};
					$scope.sources = SourceFindAll.findall();
				} ]);
		dmsApp.controller('SourceDetailCtrl', [
				'$scope',
				'$routeParams',
				'SourceUpdate',
				'SourceFind',
				'$location',
				function($scope, $routeParams, SourceUpdate, SourceFind,
						$location) {
					// callback for ng-click 'updateSource':
					$scope.updateSource = function() {
						SourceUpdate.update($scope.source);
						$location.path('/source-list');
					};
					// callback for ng-click 'cancel':
					$scope.cancel = function() {
						$location.path('/source-list');
					};
					$scope.source = SourceFind.find({
						id : $routeParams.id
					});
				} ]);
		dmsApp.controller('SourceCreationCtrl', [ '$scope', 'SourceCreate',
				'$location', function($scope, SourceCreate, $location) {
					// callback for ng-click 'createNewSource':
					$scope.createNewSource = function() {
						SourceCreate.create($scope.source);
						$location.path('/source-list');
					}
				} ]);
	</script>
</body>
</html>