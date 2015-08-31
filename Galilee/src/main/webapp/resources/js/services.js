
var contextRoot = '/dms';

dmsApp.factory('SiteByRiver', function($resource) {
	return $resource(contextRoot + '/sites/river/:id', {}, {
		find : {
			method: 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});
dmsApp.factory('ValueBySite', function($resource) {
	return $resource(contextRoot + '/values/:year/:term/site/:id', {}, {
		find : {
			method: 'GET',
			params : {
				year : '@year',
				term : '@term',
				id : '@id'
			},
			cache : true,
			isArray : true
		}
	})
});

dmsApp.factory('ValueByFish', function($resource) {
	return $resource(contextRoot + '/values/:year/:term/fish/:id', {}, {
		find : {
			method: 'GET',
			params : {
				year : '@year',
				term : '@term',
				id : '@id'
			},
			isArray : true
		}
	})
});

dmsApp.factory('SurveyYear', function($resource) {
	return $resource(contextRoot + '/value/years', {}, {
		find : {
			method: 'GET',
			cache : true,
			isArray : true			
		}
	})
});

/**
 * Data Management
 * Sources
 */
dmsApp.factory('SourceFindAll', function($resource) {
	return $resource(contextRoot + '/sources', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('SourceFind', function($resource) {
	return $resource(contextRoot + '/source/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('SourceCreate', function($resource) {
	return $resource(contextRoot + '/source/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SourceUpdate', function($resource) {
	return $resource(contextRoot + '/source/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SourceDelete', function($resource) {
	return $resource(contextRoot + '/source/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Sites
 */

dmsApp.factory('SiteFindAll', function($resource) {
	return $resource(contextRoot + '/sites', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
dmsApp.factory('SiteFind', function($resource) {
	return $resource(contextRoot + '/site/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
})
dmsApp.factory('SiteListFind', function($resource) {
	return $resource(contextRoot + '/sites/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});

dmsApp.factory('SiteCreate', function($resource) {
	return $resource(contextRoot + '/site/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SiteUpdate', function($resource) {
	return $resource(contextRoot + '/site/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SiteDelete', function($resource) {
	return $resource(contextRoot + '/site/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SiteByRiver', function($resource) {
	return $resource(contextRoot + '/sites/river/:id', {}, {
		find : {
			method: 'GET',
			params : {
				id : '@id'
			},
			cache : true,
			isArray : true
		}
	})
});

/**
 * Rivers
 */

dmsApp.factory('RiverFindAll', function($resource) {
	return $resource(contextRoot + '/rivers', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('RiverFind', function($resource) {
	return $resource(contextRoot + '/river/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('RiverListFind', function($resource) {
	return $resource(contextRoot + '/rivers/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});
dmsApp.factory('RiverCreate', function($resource) {
	return $resource(contextRoot + '/river/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('RiverUpdate', function($resource) {
	return $resource(contextRoot + '/river/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('RiverDelete', function($resource) {
	return $resource(contextRoot + '/river/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * SiteCode
 */

dmsApp.factory('SiteCodeFindAll', function($resource) {
	return $resource(contextRoot + '/siteCodes', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
dmsApp.factory('SiteCodeFind', function($resource) {
	return $resource(contextRoot + '/siteCode/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('SiteCodeCreate', function($resource) {
	return $resource(contextRoot + '/siteCode/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SiteCodeUpdate', function($resource) {
	return $resource(contextRoot + '/siteCode/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('SiteCodeDelete', function($resource) {
	return $resource(contextRoot + '/siteCode/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Features
 */

dmsApp.factory('FeatureFindAll', function($resource) {
	return $resource(contextRoot + '/features', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('FeatureFind', function($resource) {
	return $resource(contextRoot + '/feature/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('FeatureCreate', function($resource) {
	return $resource(contextRoot + '/feature/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('FeatureUpdate', function($resource) {
	return $resource(contextRoot + '/feature/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('FeatureDelete', function($resource) {
	return $resource(contextRoot + '/feature/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

dmsApp.factory('FishByFeature', function($resource) {
	return $resource(contextRoot + '/fish/feature/:id', {}, {
		find : {
			method : 'GET',
			params: {
				id : '@id'
			}, 
			isArray: false
		}
	})
});

/**
 * Fishes
 */

dmsApp.factory('FishFindAll', function($resource) {
	return $resource(contextRoot + '/fishes', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
dmsApp.factory('FishFind', function($resource) {
	return $resource(contextRoot + '/fish/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('FishCreate', function($resource) {
	return $resource(contextRoot + '/fish/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('FishUpdate', function($resource) {
	return $resource(contextRoot + '/fish/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('FishDelete', function($resource) {
	return $resource(contextRoot + '/fish/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Methods
 */

dmsApp.factory('MethodFindAll', function($resource) {
	return $resource(contextRoot + '/methods', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('MethodFind', function($resource) {
	return $resource(contextRoot + '/method/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('MethodCreate', function($resource) {
	return $resource(contextRoot + '/method/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('MethodUpdate', function($resource) {
	return $resource(contextRoot + '/method/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('MethodDelete', function($resource) {
	return $resource(contextRoot + '/method/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Variables
 */

dmsApp.factory('VariableFindAll', function($resource) {
	return $resource(contextRoot + '/variables', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('VariableFind', function($resource) {
	return $resource(contextRoot + '/variable/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('VariableCreate', function($resource) {
	return $resource(contextRoot + '/variable/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('VariableUpdate', function($resource) {
	return $resource(contextRoot + '/variable/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('VariableDelete', function($resource) {
	return $resource(contextRoot + '/variable/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Units
 */

dmsApp.factory('UnitFindAll', function($resource) {
	return $resource(contextRoot + '/units', {}, {
		findall : {
			method : 'GET',
			isArray : true
		}
	})
});
dmsApp.factory('UnitFind', function($resource) {
	return $resource(contextRoot + '/unit/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('UnitCreate', function($resource) {
	return $resource(contextRoot + '/unit/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
dmsApp.factory('UnitUpdate', function($resource) {
	return $resource(contextRoot + '/unit/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
dmsApp.factory('UnitDelete', function($resource) {
	return $resource(contextRoot + '/unit/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});