/**
 * cacheFactory
 */

////Set up the cache ‘dmsCache’
//dmsApp.factory('dmsCache', function($cacheFactory) {
// return $cacheFactory('siteList');
//});

/**
 * Sources
 */

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
			cache : true,
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
 * Features
 */

var contextRoot = '/dms';
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