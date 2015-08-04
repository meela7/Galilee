/**
 * Source Controller
 */
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
			$scope.createSource = function() {
				$location.path('/source-creation');
			};
			$scope.sources = SourceFindAll.findall();
		} ]);
dmsApp.controller('SourceDetailCtrl', [ '$scope', '$routeParams',
		'SourceUpdate', 'SourceFind', '$location',
		function($scope, $routeParams, SourceUpdate, SourceFind, $location) {
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
			$scope.createSource = function() {
				SourceCreate.create($scope.source);
				$location.path('/source-list');
			};
			$scope.cancel = function() {
				$location.path('/source-list');
			};
		} ]);

/**
 * Site Controller
 */
dmsApp.controller('SiteListCtrl', [ '$scope', 'SiteFindAll',
		'SiteDelete', '$location', function($scope, SiteFindAll, SiteDelete, $location) {
			
			// callback for ng-click 'editSite':
			$scope.editSite = function(siteID) {
				$location.path('/site-detail/' + siteID);
			};
			// callback for ng-click 'deleteSite':
			$scope.deleteSite = function(site) {
				SiteDelete.del(site);
				$location.path('/site-list');
			};
			// callback for ng-click 'createSite':
			$scope.createSite = function() {
				$location.path('/site-creation');
			};
			
			$scope.sites = SiteFindAll.findall();
			
			// cache
			// var cache = dmsCache.get('siteList");
			// if(cache){ // if there's something in the cache, use it!
			// $scope.sites = cache;
			// }esle{ // otherwise, let's generate a new instance!
			// dmsCache.put('siteList', SiteFindAll.findall());
			// $scope.sites = dmsCache.get('siteList');
			// }

			// panination
			$scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 10;
			
			$scope.$watch('currentPage + numPerPage', function() {
				var begin = (($scope.currentPage - 1) * $scope.numPerPage),
			    end = begin + $scope.numPerPage;
				$scope.filteredSites = $scope.sites.slice(begin, end);
			});
		}]);

dmsApp.controller('SiteDetailCtrl', [ '$scope', '$routeParams', 'SiteUpdate',
		'SiteFind', '$location',
		function($scope, $routeParams, SiteUpdate, SiteFind, $location) {
			// callback for ng-click 'updateSite':
			$scope.updateSite = function() {
				SiteUpdate.update($scope.site);
				$location.path('/site-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/site-list');
			};
			$scope.site = SiteFind.find({
				id : $routeParams.id
			});
		} ]);
dmsApp.controller('SiteCreationCtrl', [ '$scope', 'SiteCreate', '$location',
		function($scope, SiteCreate, $location) {
			// callback for ng-click 'createSite':
			$scope.createSite = function() {
				SiteCreate.create($scope.site);
				$location.path('/site-list');
			};
			$scope.cancel = function() {
				$location.path('/site-list');
			};
		} ]);


/**
 * River Controller
 */
dmsApp.controller('RiverListCtrl', [ '$scope', 'RiverFindAll',
		'RiverDelete', '$location',
		function($scope, RiverFindAll, RiverDelete, $location) {

			// callback for ng-click 'editRiver':
			$scope.editRiver = function(riverID) {
				$location.path('/river-detail/' + riverID);
			};
			// callback for ng-click 'deleteRiver':
			$scope.deleteRiver = function(river) {
				RiverDelete.del(river);
				$location.path('/river-list');
			};
			// callback for ng-click 'createRiver':
			$scope.createRiver = function() {
				$location.path('/river-creation');
			};
			$scope.rivers = RiverFindAll.findall();
			
			// panination
			$scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 10;
			
			$scope.$watch('currentPage + numPerPage', function() {
				var begin = (($scope.currentPage - 1) * $scope.numPerPage),
			    end = begin + $scope.numPerPage;

				$scope.filteredRivers = $scope.rivers.slice(begin, end);
			});

			$scope.findSiteByRiver = function(){
//				alert("searchResult" + angular.toJson($scope.searchResult));
				
				var riverIDs="";
				for (var i = 0; i < $scope.searchResult.length; i++) {
	                var river = $scope.searchResult[i];
//	                alert(river.riverID);
	                if(i ==0 )
	                	riverIDs += river.riverID;
	                else
	                	riverIDs += ","+river.riverID;
	            }
//				alert("riverIDs: " +riverIDs);
				$location.path("/river-site/" + riverIDs); // set riverID to search site-list, need to add controller for this.
				
			};
			
}]);

dmsApp.controller('RiverDetailCtrl', [ '$scope', '$routeParams', 'RiverUpdate',
		'RiverFind', '$location',
		function($scope, $routeParams, RiverUpdate, RiverFind, $location) {
			// callback for ng-click 'updateRiver':
			$scope.updateRiver = function() {
				RiverUpdate.update($scope.river);
				$location.path('/river-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/river-list');
			};
			$scope.river = RiverFind.find({
				id : $routeParams.id
			});
		} ]);
dmsApp.controller('RiverCreationCtrl', [ '$scope', 'RiverCreate', '$location',
		function($scope, RiverCreate, $location) {
			// callback for ng-click 'createRiver':
			$scope.createRiver = function() {
				RiverCreate.create($scope.river);
				$location.path('/river-list');
			};
			$scope.cancel = function() {
				$location.path('/river-list');
			};
		} ]);
dmsApp.controller('RiverSiteCtrl', ['$scope', '$routeParams', 'SiteByRiver', '$location',
        function($scope, $routeParams, SiteByRiver, $location){
	
			// callback for ng-click 'editRiver':
			$scope.editSite = function(siteID) {
				$location.path('/site-detail/' + siteID);
			};
			// callback for ng-click 'deleteRiver':
			$scope.deleteSite = function(site) {
				SiteDelete.del(site);
			};
			// callback for ng-click 'createRiver':
			$scope.createSite = function() {
				$location.path('/site-creation');
			};

//			alert("RiverSiteCtrl : " + $routeParams.id);
			
			$scope.sites = SiteByRiver.find({
				id : $routeParams.id
			});
			
			// panination
			$scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 10;
			
			$scope.$watch('currentPage + numPerPage', function() {
				var begin = (($scope.currentPage - 1) * $scope.numPerPage),
			    end = begin + $scope.numPerPage;
				$scope.filteredSites = $scope.sites.slice(begin, end);
			});
			
}]);

/**
 * Featrues
 */

dmsApp.controller('FeatureListCtrl', [ '$scope', 'FeatureFindAll',
		'FeatureDelete', '$location',function($scope, FeatureFindAll, FeatureDelete, $location) {
//			alert("FeatureListCtrl");
			// callback for ng-click 'editFeature':
			$scope.editFeature = function(featureID) {
				$location.path('/feature-detail/' + featureID);
			};
			$scope.findFishByFeature = function(featureID) {
				$location.path('/feature-fish/' + featureID);
			}
			// callback for ng-click 'deleteFeature':
			$scope.deleteFeature = function(feature) {
				FeatureDelete.del(feature);
				$location.path('/feature-list');
			};
			// callback for ng-click 'createFeature':
			$scope.createFeature = function() {
				$location.path('/feature-creation');
			};
			$scope.features = FeatureFindAll.findall();
			
			// panination
			$scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 10;
			
			$scope.$watch('currentPage + numPerPage', function() {
				var begin = (($scope.currentPage - 1) * $scope.numPerPage),
			    end = begin + $scope.numPerPage;
				$scope.filteredSites = $scope.features.slice(begin, end);
			});
			
		} ]);
dmsApp.controller('FeatureDetailCtrl', [ '$scope', '$routeParams',
		'FeatureUpdate', 'FeatureFind', '$location',
		function($scope, $routeParams, FeatureUpdate, FeatureFind, $location) {
			// callback for ng-click 'updateFeaturee':
			$scope.updateFeature = function() {
				FeatureUpdate.update($scope.feature);
				$location.path('/feature-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/feature-list');
			};
			$scope.feature = FeatureFind.find({
				id : $routeParams.id
			});
		} ]);
dmsApp.controller('FeatureCreationCtrl', [ '$scope', 'FeatureCreate',
		'$location', function($scope, FeatureCreate, $location) {
			// callback for ng-click 'createNewFeature':
			$scope.createFeature = function() {
				FeatureCreate.create($scope.feature);
				$location.path('/feature-list');
			};
			$scope.cancel = function() {
				$location.path('/feature-list');
			};
		} ]);

dmsApp.controller('FeatureFishDetailCtrl', ['$scope', '$routeParams', 'FishByFeature', '$location',
		function($scope, $routeParams, FishByFeature, $location){
		
		$scope.updateFish = function() {
//			FishUpdate.update($scope.fish);
			$location.path('/feature-list');
		};
		// callback for ng-click 'cancel':
		$scope.cancel = function() {
			$location.path('/feature-list');
		};
		
		$scope.fish = FishByFeature.find({
			id : $routeParams.id
		});						
}]);
