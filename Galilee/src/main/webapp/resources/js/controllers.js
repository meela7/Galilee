/**
 * Search
 */
dmsApp.controller('MapCtrl', ['$scope', '$routeParams', 'SurveyYear', 'SiteListFind', function ($scope, $routeParams, SurveyYear, SiteListFind) {
//    	var mapOptions = {
//            zoom: 8,
//            center: new google.maps.LatLng(36.1813, 127.3946),
//            mapTypeId: google.maps.MapTypeId.HYBRID
//        };
//
////        $scope.myMap = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
//    	$scope.onMapIdle = function() {
//    		if ($scope.myMarkers === undefined){
//	        $scope.markers = [];
//	        
//	        var infoWindow = new google.maps.InfoWindow();
//	        
//	        var createMarker = function (info){
//	            
//	            var marker = new google.maps.Marker({
//	                map: $scope.myMap,
//	                position: new google.maps.LatLng(info.latitude, info.longitude),
//	                title: info.siteName
//	            });
//	            marker.content = '<div class="infoWindowContent">' + info.siteName + '</div>';
//	            
//	            google.maps.event.addListener(marker, 'click', function(){
//	                infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
//	                infoWindow.open($scope.myMap, marker);
//	            });
//	            
//	            $scope.markers.push(marker);
//	            
//	        }  
//	        var sites = SiteFindAll.findall();
//	        for (i = 0; i < sites.length; i++){
//	            createMarker(sites[i]);
//	        }
//	
//	        $scope.openInfoWindow = function(e, selectedMarker){
//	            e.preventDefault();
//	            google.maps.event.trigger(selectedMarker, 'click');
//	        }
//    		}
//    	};
		
	var year = "";
	$scope.years = SurveyYear.find();
	
		$scope.getYear = function () {
        
        year = $scope.ddlYears;
    };
	var mapCenter = new google.maps.LatLng(36.1813, 127.3946);
    $scope.mapOptions = {
        center: mapCenter,
        zoom: 8,
        mapTypeId: google.maps.MapTypeId.MAP
    };
       
    var sites = SiteListFind.find({
		id : $routeParams.id
	});

    //Markers should be added after map is loaded
    $scope.onMapIdle = function() {
        if ($scope.myMarkers === undefined){
        	var markers = [];
        	for(var i=0; i<sites.length;i++){
//        		alert(sites[i].siteName);
        		var pos = new google.maps.LatLng(sites[i].latitude, sites[i].longitude);

	            var marker = new google.maps.Marker({
	                map: $scope.myMap,
	                position: pos,
	                title: sites[i].siteName
	            });
	            markers.push(marker);
        	}
//            $scope.myMarkers = [marker, ];
			$scope.myMarkers = markers;
        }
    };
    
    $scope.openInfoWindow = function(e, selectedMarker){
        e.preventDefault();
        google.maps.event.trigger(selectedMarker, 'click');
    };
    $scope.markerClicked = function(m) {
        alert(m.title);
    };
}]);

dmsApp.controller('FeatureSearchCtrl',['$scope', 'FeatureFindAll','$location',
        function($scope, FeatureFindAll, $location) {


 		$scope.features = FeatureFindAll.findall();

 		// panination
 		$scope.currentPage = 1, $scope.numPerPage = 10,
 			$scope.maxSize = 10;

 		$scope.searchFishByFeature = function(){
//                            			alert("called searchFishBySite" +$scope.year);
			var fIDs= [];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var feature = $scope.searchResult[i];
				// alert(river.riverID);
				fIDs.push(feature.featureID);
			}
			$location.path("/feature-fish/" + fIDs.toString());
		};
 	}	// alert("RiverSiteCtrl : " + $routeParams.id);
 ]);

dmsApp.controller('FishSearchCtrl',['$scope', 'FishFindAll','SurveyYear', '$location',
       function($scope, FishFindAll, SurveyYear, $location) {
		var year = "";
		$scope.years = SurveyYear.find();
		$scope.getYear = function () {	        
	        year = $scope.ddlYear;
	    };
	    var term = "";
	    $scope.terms = [1, 2];
	    $scope.getTerm = function () {	        
	        term = $scope.ddlTerm;
	    };
		$scope.fishes = FishFindAll.findall();
		
		$scope.cancel = function(){
			$scope.search = "";
		}
		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10,
			$scope.maxSize = 10;
		
		$scope.searchByFish = function () {		
			var fIDs = [];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var fish = $scope.searchResult[i];
				// alert(river.riverID);
				fIDs.push(fish.fishID);
			}
			$location.path("/fish-value/" +year +"/"+ term +"/"+ fIDs.tostring());
			// set riverID to search site-list, need to add controller for this.

		};
		}// alert("RiverSiteCtrl : " + $routeParams.id);
]);


dmsApp.controller('FishValueCtrl',['$scope','$routeParams','ValueByFish','SurveyYear', '$location', function($scope, $routeParams, ValueByFish, SurveyYear, $location) {
		var year = "";
		$scope.years = SurveyYear.find();
		$scope.getYear = function () {
	        
	        year = $scope.ddlYears;
	    };
		// alert("SiteFishCtrl : " + $routeParams.id);
		$scope.values = ValueByFish.find({
			year : $routeParams.year,
			term : $routeParams.term,
			id : $routeParams.id
		});
		
		$scope.viewInMap = function(){
//			alert("called FishValueCtrl" +$scope.values.length);
			var sIDs=[];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var value = $scope.searchResult[i];
				
				if(!inArray(value.site.siteID, sIDs))
					sIDs.push(value.site.siteID);
			}
			
			$location.path("/site-map/"+ sIDs.toString());
		};
					
		// panination
	  	$scope.currentPage = 1, $scope.numPerPage = 10,	$scope.maxSize = 10;
	  	
	  	$scope.$back = function () {
	  		window.history.back();
	  	};
  	}
]);
dmsApp.controller('RiverSearchCtrl',['$scope', 'RiverFindAll','$location',
	function($scope, RiverFindAll, $location) {
		
		$scope.rivers = RiverFindAll.findall();
		$scope.cancel = function(){
			$scope.search = "";
		};
		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10,
			$scope.maxSize = 10;

		$scope.searchSiteByRiver = function () {
			 
//			 alert("searchResult" + $scope.searchResult.length);

			var rIDs = [];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var river = $scope.searchResult[i];
				rIDs.push(river.riverID);
			}
//			alert("riverIDs: " +riverIDs);
			$location.path("/river-site/" + rIDs.toString());
			// set riverID to search site-list, need to add controller for this.

		};
	}	// alert("RiverSiteCtrl : " + $routeParams.id);
]);

dmsApp.controller('RiverSiteCtrl',['$scope','$routeParams','SiteByRiver', 'SurveyYear', '$location',
	function($scope, $routeParams, SiteByRiver, SurveyYear, $location) {
		var year = "";
		$scope.years = SurveyYear.find();
			$scope.getYear = function () {            
	        year = $scope.ddlYear;
	    };
	    
		var term = "";
		$scope.terms = [1, 2];		
	    $scope.getTerm = function () {	        
	        term = $scope.ddlTerm;
	    };
		$scope.sites = SiteByRiver.find({
			id : $routeParams.id
		});	
		
		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 10;
		
		$scope.searchBySite = function(){
//			alert("called searchFishBySite: " +$scope.year);
			var sIDs= [];
			
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var site = $scope.searchResult[i];
				// alert(river.riverID);
				sIDs.push(site.siteID);
			}
			$location.path("/site-value/" + year +"/"+ term +"/"+sIDs.toString());
		}
	}
]);
dmsApp.controller('SiteSearchCtrl',['$scope', 'SiteFindAll', 'SurveyYear','$location',
        function($scope, SiteFindAll, SurveyYear, $location) {
		var year = "";
		$scope.years = SurveyYear.find();
 		$scope.getYear = function () {            
            year = $scope.ddlYear;
        };
        
		var term = "";
		$scope.terms = [1, 2];		
	    $scope.getTerm = function () {	        
	        term = $scope.ddlTerm;
	    };
 		$scope.cancel = function(){
			$scope.search = "";
		};
		$scope.sites = SiteFindAll.findall();
		
 		// panination
 		$scope.currentPage = 1, $scope.numPerPage = 10,
 			$scope.maxSize = 10;

 		$scope.searchBySite = function(){
//                            			alert("called searchFishBySite: " +$scope.year);
			var sIDs= [];
			
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var site = $scope.searchResult[i];
				sIDs.push(site.siteID);
			};
			$location.path("/site-value/" + year +"/"+term+"/"+ sIDs.toString());
		};
		$scope.viewInMap = function(){
			var sIds= [];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var site = $scope.searchResult[i];
				
				if(!inArray(site.siteID, sIds))
					sIds.push(site.siteID);
			}
			
			$location.path("/site-map/"+ sIds.toString());
		};
 	}
 ]);
function inArray(needle,haystack)
{
    var count=haystack.length;
    for(var i=0;i<count;i++)
    {
        if(haystack[i]===needle){return true;}
    }
    return false;
};
dmsApp.controller('SiteValueCtrl',['$scope','$routeParams','ValueBySite','SurveyYear','$location',
	function($scope, $routeParams, ValueBySite, SurveyYear, $location) {
		
		var year = "";
		$scope.years = SurveyYear.find();
		$scope.getYear = function () {
	        year = $scope.ddlYears;
	    }		

		var meta = "";
		$scope.metadata = ["Feature", "Site", "River", "Variable"];
		
		$scope.searchMeta = function(ddlMeta){
			
			if(ddlMeta=="Feature"){
				var fIDs= [];
				for (var i = 0; i < $scope.searchResult.length; i++) {
					var value = $scope.searchResult[i];
					// alert(river.riverID);
					if(inArray(value.feature.featureID, fIDs))
						fIDs.push(value.feature.featureID);
				}
				
				$location.path("/value-fish/" + fIDs.toString());
			}else if(ddlMeta=="Site"){
				
				var sIDs= [];
				for (var i = 0; i < $scope.searchResult.length; i++) {
					var value = $scope.searchResult[i];
					if(!inArray(value.site.siteID, sIDs)){
						sIDs.push(value.site.siteID);
					}
				}
				
				$location.path("/value-site/" + sIDs.toString());
			}else if(ddlMeta=="River"){
				
				var rIDs= [];
				for (var i = 0; i < $scope.searchResult.length; i++) {
					var value = $scope.searchResult[i];
					if(!inArray(value.site.river.riverID, rIDs)){
						rIDs.push(value.site.river.riverID);
					}
				}
				
				$location.path("/value-river/" + rIDs.toString());
			}
		};
		
		// change visualization to map
		$scope.viewInMap = function(){
//			alert("called searchFishBySite" +$scope.year);
			var sIds= [];
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var value = $scope.searchResult[i];
				
				if(!inArray(value.site.siteID, sIds))
					sIds.push(value.site.siteID);
			}
			
			$location.path("/site-map/"+ sIds.toString());
		};
		// alert("RiverSiteCtrl : " + $routeParams.id);
		$scope.values = ValueBySite.find({
			year : $routeParams.year,
			term : $routeParams.term,
			id : $routeParams.id
		});
		
		// panination
		$scope.currentPage = 1, $scope.numPerPage = 10,
			$scope.maxSize = 10;
		
	}
]);

dmsApp.controller('SiteFindCtrl',['$scope','$routeParams','SiteListFind','SurveyYear',
                               	function($scope, $routeParams, SiteListFind, SurveyYear) {
	var year = "";
	$scope.years = SurveyYear.find();
	var term = "";
	$scope.terms = [1, 2];
			
		$scope.getYear = function () {
        
        year = $scope.ddlYear;
    };
		
	
    $scope.getTerm = function () {	        
        term = $scope.ddlTerm;
    };
		$scope.cancel = function(){
		$scope.search = "";
	};
		$scope.sites = SiteListFind.find({
			id : $routeParams.id
		});
		
		// panination
 		$scope.currentPage = 1, $scope.numPerPage = 10,
 			$scope.maxSize = 10;

 		$scope.searchBySite = function(){
//                            			alert("called searchFishBySite: " +$scope.year);
			var sIDs= [];
			
			for (var i = 0; i < $scope.searchResult.length; i++) {
				var site = $scope.searchResult[i];
				// alert(river.riverID);
				sIDs.push(site.siteID);
			};
			$location.path("/site-value/" + year +"/"+term+"/"+ sIDs.toString());
		}
	}
]);

dmsApp.controller('RiverFindCtrl',['$scope', '$routeParams', 'RiverListFind','$location',
 	function($scope, $routeParams, RiverListFind, $location) {
 		
 		$scope.rivers = RiverListFind.find({
 			id : $routeParams.id
 		});
 		$scope.cancel = function(){
 			$scope.search = "";
 		};
 		// panination
 		$scope.currentPage = 1, $scope.numPerPage = 10,
 			$scope.maxSize = 10;

 		$scope.searchSiteByRiver = function () {
 			 
 			var riverIDs = [];
 			for (var i = 0; i < $scope.searchResult.length; i++) {
 				var river = $scope.searchResult[i];
 				// alert(river.riverID);
 				riverIDs.push(river.riverID);
 			}
 			// set riverID to search site-list, need to add controller for this.

 		};
 	}	// alert("RiverSiteCtrl : " + $routeParams.id);
 ]);


/**
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

							$scope
									.$watch(
											'currentPage + numPerPage',
											function() {
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
