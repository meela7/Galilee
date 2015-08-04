/**
 * 
 */

var dmsApp = angular.module("dmsApp", [ 'ngResource', 'ngRoute', 'ui.bootstrap']);

dmsApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/source-list', {
		templateUrl : 'resources/template/source/list.html',
		controller : 'SourceListCtrl'
	}).
	when('/source-detail/:id', {
		templateUrl : 'resources/template/source/detail.html',
		controller : 'SourceDetailCtrl'
	}).
	when('/source-creation', {
		templateUrl : 'resources/template/source/creation.html',
		controller : 'SourceCreationCtrl'
	}).
	when('/site-list', {
		templateUrl : 'resources/template/site/list.html',
		controller : 'SiteListCtrl'
	}).
	when('/site-detail/:id', {
		templateUrl : 'resources/template/site/detail.html',
		controller : 'SiteDetailCtrl'
	}).
	when('/site-creation', {
		templateUrl : 'resources/template/site/creation.html',
		controller : 'SiteCreationCtrl'
	}).
	when('/river-list', {
		templateUrl : 'resources/template/river/list.html',
		controller : 'RiverListCtrl'
	}).
	when('/river-detail/:id', {
		templateUrl : 'resources/template/river/detail.html',
		controller : 'RiverDetailCtrl'
	})
	.when('/river-creation', {
		templateUrl : 'resources/template/river/creation.html',
		controller : 'RiverCreationCtrl'
	})
	.when('/river-site/:id', {
		templateUrl : 'resources/template/site/list.html',
		controller : 'RiverSiteCtrl'
	})
	.when('/feature-list', {
		templateUrl : 'resources/template/feature/list.html',
		controller : 'FeatureListCtrl'
	})
	.when('/feature-detail/:id', {
		templateUrl : 'resources/template/feature/detail.html',
		controller : 'FeatureDetailCtrl'
	})
	.when('/feature-creation', {
		templateUrl : 'resources/template/feature/creation.html',
		controller : 'FeatureCreationCtrl'
	})
	.when('/feature-fish/:id', {
		templateUrl : 'resources/template/fish/detail.html',
		controller : 'FeatureFishDetailCtrl'
	});
	
} ]);


