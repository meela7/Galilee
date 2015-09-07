/**
 * Data Model Management
 * 
 * 
 * Source Controller
 */
dmsApp.controller('SourceListCtrl', [ '$scope', 'SourceFindAll',
		'SourceDelete', '$location',
		function($scope, SourceFindAll, SourceDelete, $location) {
	
			$scope.cancel = function(){
				$scope.search = "";
			};
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
			// panination
			$scope.currentPage = 1, $scope.numPerPage = 10,
				$scope.maxSize = 10;
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
dmsApp.controller('SourceCreationCtrl', [ '$scope', 'SourceCreate','$location', 
    function($scope, SourceCreate, $location) {
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
dmsApp.controller('SiteListCtrl', ['$scope','SiteFindAll','SiteDelete','$location',
	function($scope, SiteFindAll, SiteDelete, $location) {
	
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

	$scope.cancel = function () {
		$scope.search = "";
	};
	
	$scope.sites = SiteFindAll.findall();

	// cache
	// var cache = dmsCache.get('siteList");
	// if(cache){ // if there's something in the cache,
	// use it!
	// $scope.sites = cache;
	// }esle{ // otherwise, let's generate a new
	// instance!
	// dmsCache.put('siteList', SiteFindAll.findall());
	// $scope.sites = dmsCache.get('siteList');
	// }

	// panination
	$scope.currentPage = 1, $scope.numPerPage = 10,
			$scope.maxSize = 10;

	$scope.$watch('currentPage + numPerPage',
		function() {
		var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
				+ $scope.numPerPage;
		$scope.filteredSites = $scope.sites
				.slice(begin, end);
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
dmsApp.controller('RiverListCtrl',['$scope','RiverFindAll','RiverDelete','$location',
	function($scope, RiverFindAll, RiverDelete, $location) {

		// callback for ng-click 'editRiver':
		$scope.editRiver = function (riverID) {
			$location.path('/river-detail/' + riverID);
		};
		// callback for ng-click 'deleteRiver':
		$scope.deleteRiver = function (river) {
			RiverDelete.del(river);
			$location.path('/river-list');
		};
		// callback for ng-click 'createRiver':
		$scope.createRiver = function () {
			$location.path('/river-creation');
		};

		$scope.cancel = function () {
			
			$scope.search = "";
		};

		$scope.rivers = RiverFindAll.findall();

		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10,
			$scope.maxSize = 10;

		$scope.$watch('currentPage + numPerPage', function () {
			var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
				+ $scope.numPerPage;

			$scope.filteredRivers = $scope.rivers
				.slice(begin, end);
		});
	}
]);

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


/**
 * SiteCode Controller
 */
dmsApp.controller('SiteCodeListCtrl',['$scope','SiteCodeFindAll','SiteCodeDelete','$location',
		function($scope, SiteCodeFindAll, SiteCodeDelete,
			$location) {
	
		// callback for ng-click 'editSiteCode':
		$scope.editSiteCode = function(siteCodeID) {
			$location
					.path('/siteCode-detail/' + siteCodeID);
		};
		
		$scope.cancel = function () {
			
			$scope.search = "";
		};
		// callback for ng-click 'deleteSiteCode':
		$scope.deleteSiteCode = function(siteCode) {
			SiteCodeDelete.del(siteCode);
			$location.path('/siteCode-list');
		};
		// callback for ng-click 'createSite':
		$scope.createSiteCode = function() {
			$location.path('/siteCode-creation');
		};
	
		$scope.siteCodes = SiteCodeFindAll.findall();
	
		// cache
		// var cache = dmsCache.get('siteList");
		// if(cache){ // if there's something in the cache,
		// use it!
		// $scope.sites = cache;
		// }esle{ // otherwise, let's generate a new
		// instance!
		// dmsCache.put('siteList', SiteFindAll.findall());
		// $scope.sites = dmsCache.get('siteList');
		// }
	
		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10,
				$scope.maxSize = 10;
	
		$scope.$watch('currentPage + numPerPage',
		function() {
			var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
					+ $scope.numPerPage;
			$scope.filteredSiteCodes = $scope.siteCodes
					.slice(begin, end);
		});
} ]);

dmsApp.controller('SiteCodeDetailCtrl',
		[
				'$scope',
				'$routeParams',
				'SiteCodeUpdate',
				'SiteCodeFind',
				'$location',
				function($scope, $routeParams, SiteCodeUpdate, SiteCodeFind,
						$location) {
					// callback for ng-click 'updateSiteCode':
					$scope.updateSiteCode = function() {
						SiteCodeUpdate.update($scope.siteCode);
						$location.path('/siteCode-list');
					};
					// callback for ng-click 'cancel':
					$scope.cancel = function() {
						$location.path('/siteCode-list');
					};
					$scope.siteCode = SiteCodeFind.find({
						id : $routeParams.id
					});
				} ]);
dmsApp.controller('SiteCodeCreationCtrl', [ '$scope', 'SiteFindAll',
		'SiteCodeCreate', '$location',
		function($scope, SiteFindAll, SiteCodeCreate, $location) {
			$scope.sites = SiteFindAll.findall();
			var getSite;
			$scope.getSelectedSite = function(site) {
				getSite = $scope.ddlSites;
				alert(getSite.siteID);
				$scope.selectedSiteName = getSite.siteName;
				$scope.siteCode.site = getSite;
				// $window.alert("Selected Value: " + siteID + "\nSelected Text:
				// " + siteID);
			};
			// callback for ng-click 'createSiteCode':
			$scope.createSiteCode = function() {
				SiteCodeCreate.create($scope.siteCode);
				$location.path('/siteCode-list');
			};

			$scope.cancel = function() {
				$location.path('/siteCode-list');
			};

		} ]);

/**
 * Featrues
 */

dmsApp
		.controller(
				'FeatureListCtrl',
				[
						'$scope',
						'FeatureFindAll',
						'FeatureDelete',
						'$location',
						function($scope, FeatureFindAll, FeatureDelete,
								$location) {
							$scope.cancel = function () {
								
								$scope.search = "";
							};
							// alert("FeatureListCtrl");
							// callback for ng-click 'editFeature':
							$scope.editFeature = function(featureID) {
								$location.path('/feature-detail/' + featureID);
							};
							$scope.findFishByFeature = function(featureID) {
								$location.path('/feature-fish/' + featureID);
							};
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
							$scope.currentPage = 1, $scope.numPerPage = 10,
									$scope.maxSize = 10;

							$scope
									.$watch(
											'currentPage + numPerPage',
											function() {
												var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
														+ $scope.numPerPage;
												$scope.filteredFeatures = $scope.features
														.slice(begin, end);
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

dmsApp.controller('FeatureFishDetailCtrl', [ '$scope', '$routeParams',
		'FishByFeature', '$location',
		function($scope, $routeParams, FishByFeature, $location) {

			$scope.updateFish = function() {
				// FishUpdate.update($scope.fish);
				$location.path('/feature-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/feature-list');
			};

			$scope.fish = FishByFeature.find({
				id : $routeParams.id
			});
		} ]);

/**
 * Fishes
 */

dmsApp
		.controller(
				'FishListCtrl',
				[
						'$scope',
						'FishFindAll',
						'FishDelete',
						'$location',
						function($scope, FishFindAll, FishDelete, $location) {
							$scope.cancel = function(){
								$scope.search = "";
							};
							// alert("FeatureListCtrl");
							// callback for ng-click 'editFish':
							$scope.editFish = function(fishID) {
								$location.path('/fish-detail/' + fishID);
							};

							// callback for ng-click 'deleteFish':
							$scope.deleteFish = function(fish) {
								FishDelete.del(fish);
								$location.path('/fish-list');
							};
							// callback for ng-click 'createFish':
							$scope.createFish = function() {
								$location.path('/fish-creation');
							};
							$scope.fishes = FishFindAll.findall();

							// panination
							$scope.currentPage = 1, $scope.numPerPage = 10,
									$scope.maxSize = 10;

							$scope.$watch('currentPage + numPerPage',function() {
								var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
										+ $scope.numPerPage;
								$scope.filteredFishes = $scope.fishes
										.slice(begin, end);
							});

						} ]);
dmsApp.controller('FishDetailCtrl', [ '$scope', '$routeParams', 'FishUpdate',
		'FishFind', '$location',
		function($scope, $routeParams, FishUpdate, FishFind, $location) {
			// callback for ng-click 'updateFish':
			$scope.updateFish = function() {
				FishUpdate.update($scope.fish);
				$location.path('/fish-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/fish-list');
			};
			$scope.fish = FishFind.find({
				id : $routeParams.id
			});
		} ]);
dmsApp.controller('FishCreationCtrl', [ '$scope', 'FishCreate', '$location',
		function($scope, FishCreate, $location) {
			// callback for ng-click 'createNewFish':
			$scope.createFish = function() {
				FishCreate.create($scope.fish);
				$location.path('/fish-list');
			};
			$scope.cancel = function() {
				$location.path('/fish-list');
			};
		} ]);

/**
 * Methods
 */

dmsApp
		.controller(
				'MethodListCtrl',
				[
						'$scope',
						'MethodFindAll',
						'MethodDelete',
						'$location',
						function($scope, MethodFindAll, MethodDelete, $location) {
							$scope.cancel = function(){
								$scope.search = "";
							}
							// callback for ng-click 'editMethod':
							$scope.editMethod = function(methodID) {
								$location.path('/method-detail/' + methodID);
							};

							// callback for ng-click 'deleteMethod':
							$scope.deleteMethod = function(method) {
								MethodDelete.del(method);
								$location.path('/method-list');
							};
							// callback for ng-click 'createMethod':
							$scope.createMethod = function() {
								$location.path('/method-creation');
							};
							$scope.methods = MethodFindAll.findall();

							// panination
							$scope.currentPage = 1, $scope.numPerPage = 10,
									$scope.maxSize = 10;

							$scope
									.$watch(
											'currentPage + numPerPage',
											function() {
												var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
														+ $scope.numPerPage;
												$scope.filteredMethods = $scope.methods
														.slice(begin, end);
											});

						} ]);
dmsApp.controller('MethodDetailCtrl', [ '$scope', '$routeParams',
		'MethodUpdate', 'MethodFind', '$location',
		function($scope, $routeParams, MethodUpdate, MethodFind, $location) {
			// callback for ng-click 'updateFish':
			$scope.updateMethod = function() {
				MethodUpdate.update($scope.method);
				$location.path('/method-list');
			};
			// callback for ng-click 'cancel':
			$scope.cancel = function() {
				$location.path('/method-list');
			};
			$scope.method = MethodFind.find({
				id : $routeParams.id
			});
		} ]);
dmsApp.controller('MethodCreationCtrl', [ '$scope', 'MethodCreate',
		'$location', function($scope, MethodCreate, $location) {
			// callback for ng-click 'createNewFish':
			$scope.createMethod = function() {
				MethodCreate.create($scope.method);
				$location.path('/method-list');
			};
			$scope.cancel = function() {
				$location.path('/method-list');
			};
		} ]);
/**
 * Variables
 */

dmsApp
		.controller(
				'VariableListCtrl',
				[
						'$scope',
						'VariableFindAll',
						'VariableDelete',
						'$location',
						function($scope, VariableFindAll, VariableDelete,
								$location) {
							$scope.cancel = function(){
								$scope.search = "";
							}
							// callback for ng-click 'editVariable':
							$scope.editVariable = function(variableID) {
								$location
										.path('/variable-detail/' + variableID);
							};

							// callback for ng-click 'deleteVariable':
							$scope.deleteVariable = function(variable) {
								VariableDelete.del(variable);
								$location.path('/variable-list');
							};
							// callback for ng-click 'createVariable':
							$scope.createVariable = function() {
								$location.path('/variable-creation');
							};
							$scope.variables = VariableFindAll.findall();

							// panination
							$scope.currentPage = 1, $scope.numPerPage = 10,
									$scope.maxSize = 10;

							$scope
									.$watch(
											'currentPage + numPerPage',
											function() {
												var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
														+ $scope.numPerPage;
												$scope.filteredVariables = $scope.variables
														.slice(begin, end);
											});

						} ]);
dmsApp.controller('VariableDetailCtrl',
		[
				'$scope',
				'$routeParams',
				'VariableUpdate',
				'VariableFind',
				'UnitFindAll',
				'$location',
				function($scope, $routeParams, VariableUpdate, VariableFind,UnitFindAll,
						$location) {
					// callback for ng-click 'updateFeaturee':
					$scope.updateVariable = function() {
						VariableUpdate.update($scope.variable);
						$location.path('/variable-list');
					};
					// callback for ng-click 'cancel':
					$scope.cancel = function() {
						$location.path('/variable-list');
					};
					$scope.variable = VariableFind.find({
						id : $routeParams.id
					});
					$scope.statuses = UnitFindAll.findall();
					
				} ]);
dmsApp.controller('VariableCreationCtrl', [ '$scope', 'VariableCreate',
		'$location', function($scope, VariableCreate, $location) {
			// callback for ng-click 'createNewFeature':
			$scope.createVariable = function() {
				VariableCreate.create($scope.variable);
				$location.path('/variable-list');
			};
			$scope.cancel = function() {
				$location.path('/variable-list');
			};
		} ]);

/**
 * Units
 */

dmsApp
		.controller(
				'UnitListCtrl',
				[
						'$scope',
						'UnitFindAll',
						'UnitDelete',
						'$location',
						function($scope, UnitFindAll, UnitDelete,
								$location) {
							$scope.cancel = function(){
								$scope.search = "";
							}
							// callback for ng-click 'editUnit':
							$scope.editUnit = function(unitID) {
								$location
										.path('/unit-detail/' + unitID);
							};

							// callback for ng-click 'deleteUnit':
							$scope.deleteUnit = function(unit) {
								UnitDelete.del(unit);
								$location.path('/unit-list');
							};
							// callback for ng-click 'createUnit':
							$scope.createUnit = function() {
								$location.path('/unit-creation');
							};
							$scope.units = UnitFindAll.findall();

							// panination
							$scope.currentPage = 1, $scope.numPerPage = 10,
									$scope.maxSize = 10;

							$scope
									.$watch(
											'currentPage + numPerPage',
											function() {
												var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin
														+ $scope.numPerPage;
												$scope.filteredUnits = $scope.units
														.slice(begin, end);
											});

						} ]);
dmsApp.controller('UnitDetailCtrl',
		[
				'$scope',
				'$routeParams',
				'UnitUpdate',
				'UnitFind',
				'$location',
				function($scope, $routeParams, UnitUpdate, UnitFind,
						$location) {
					// callback for ng-click 'updateFeaturee':
					$scope.updateUnit = function() {
						UnitUpdate.update($scope.unit);
						$location.path('/unit-list');
					};
					// callback for ng-click 'cancel':
					$scope.cancel = function() {
						$location.path('/unit-list');
					};
					$scope.unit = UnitFind.find({
						id : $routeParams.id
					});
				} ]);
dmsApp.controller('UnitCreationCtrl', [ '$scope', 'UnitCreate',
		'$location', function($scope, UnitCreate, $location) {
			// callback for ng-click 'createNewFeature':
			$scope.createUnit = function() {
				UnitCreate.create($scope.unit);
				$location.path('/unit-list');
			};
			$scope.cancel = function() {
				$location.path('/unit-list');
			};
		} ]);
