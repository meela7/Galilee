
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

dmsApp.factory('SiteInfoByRiver', function($resource) {
	return $resource(contextRoot + '/siteInfos/river/:id', {}, {
		find : {
			method: 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});

dmsApp.factory('ValueService', function($resource) {
	return $resource(contextRoot + '/values?start=:start&end=:end', {}, {
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

dmsApp.factory('TermValueBySite', function($resource) {
	return $resource(contextRoot + '/values/term/:year/:term/site/:id', {}, {
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
dmsApp.factory('TermSpatialDataBySite', function($resource) {
	return $resource(contextRoot + '/values/fish/term/:year/:term/site/:id', {}, {
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
dmsApp.factory('ValueBySite', function($resource) {
	return $resource(contextRoot + '/values/:start/:end/site/:id', {}, {
		find : {
			method: 'GET',
			params : {
				start : '@start',
				end : '@end',
				id : '@id'
			},
			cache : true,
			isArray : true
		}
	})
});


dmsApp.factory('TermValueByFish', function($resource) {
	return $resource(contextRoot + '/values/term/:year/:term/fish/:id', {}, {
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

dmsApp.factory('ValueByFish', function($resource) {
	return $resource(contextRoot + '/fishes/:id/values?start=:start&end=:end', {}, {
		find : {
			method: 'GET',
			params : {
				start : '@start',
				end : '@end',
				id : '@id'
			},
			cache : true,
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

dmsApp.factory('SourcesService', function($resource) {
	return $resource(contextRoot + '/sources', {}, {
		findall : {
			method : 'GET',
			isArray : true
		},
		create : {
			method : 'POST'
		},
		update : {
			method : 'PUT'
		},
		del : {
			method : 'DELETE'
		}
	})
});

dmsApp.factory('SourceService', function($resource) {
	return $resource(contextRoot + '/sources/:id', {}, {
		
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'PUT',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'DELETE',
			params : {
				id : '@id'
			}
		}
	})
});

/**
 * Sites
 */

dmsApp.factory('SiteInfosService', function($resource) {
	return $resource(contextRoot + '/siteInfos', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
dmsApp.factory('SiteInfoListFind', function($resource) {
	return $resource(contextRoot + '/siteInfos?ids=:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});
dmsApp.factory('SitesService', function($resource) {
	return $resource(contextRoot + '/sites', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		},
		update : {
			method : 'PUT'
		},
		del : {
			method : 'DELETE'
		}
	})
});
dmsApp.factory('SiteService', function($resource) {
	return $resource(contextRoot + '/sites/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'PUT',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'DELETE',
			params : {
				id : '@id'
			}
		}
	})
})


dmsApp.factory('SiteListFind', function($resource) {
	
	return $resource(contextRoot + '/sites?ids=:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			isArray : true
		}
	})
});

dmsApp.factory('SiteByRiver', function($resource) {
	return $resource(contextRoot + '/river/:id/sites', {}, {
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

dmsApp.factory('RiversService', function($resource) {
	return $resource(contextRoot + '/rivers', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			isArray : true
		},
		update : {
			method : 'PUT'
		},
		del : {
			method : 'DELETE'
		}
	})
});
dmsApp.factory('RiverService', function($resource) {
	return $resource(contextRoot + '/rivers/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'PUT',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'DELETE',
			params : {
				id : '@id'
			}
		}
	})
});
dmsApp.factory('RiverListFind', function($resource) {
	return $resource(contextRoot + '/rivers?id=:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			isArray : true
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
dmsApp.factory('FeaturesService', function($resource) {
	return $resource(contextRoot + '/features', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			isArray : true
		},
		update : {
			method : 'PUT'
		},
		del : {
			method : 'DELETE'
		}
	})
});

dmsApp.factory('FeatureService', function($resource) {
	return $resource(contextRoot + '/features/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'PUT',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'DELETE',
			params : {
				id : '@id'
			}
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

dmsApp.factory('FishesService', function($resource) {
	return $resource(contextRoot + '/fishes', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		},
		update : {
			method : 'POST'
		},
		del : {
			method : 'POST'
		}
	})
});

dmsApp.factory('FishService', function($resource) {
	return $resource(contextRoot + '/fishes/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'POST',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'POST',
			params : {
				id : '@id'
			}
		}
	})
});

dmsApp.factory('FishListFind', function($resource) {
	return $resource(contextRoot + '/fishes?ids=:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			},
			cache : true,
			isArray : true
		}
	})
});


/**
 * Methods
 */

dmsApp.factory('MethodsService', function($resource) {
	return $resource(contextRoot + '/methods', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			isArray : true
		},
		update : {
			method : 'POST'
		},
		del : {
			method : 'POST'
		}
	})
});
dmsApp.factory('MethodService', function($resource) {
	return $resource(contextRoot + '/methods/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'POST',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'POST',
			params : {
				id : '@id'
			}
		}
	})
});


/**
 * Variables
 */

dmsApp.factory('VariablesService', function($resource) {
	return $resource(contextRoot + '/variables', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			isArray : true
		},
		update : {
			method : 'POST'
		},
		del : {
			method : 'POST'
		}
	})
});
dmsApp.factory('VariableService', function($resource) {
	return $resource(contextRoot + '/variables/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'POST',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'POST',
			params : {
				id : '@id'
			}
		}
	})
});


/**
 * Units
 */

dmsApp.factory('UnitsService', function($resource) {
	return $resource(contextRoot + '/units', {}, {
		create : {
			method : 'POST'
		},
		findall : {
			method : 'GET',
			isArray : true
		},
		update : {
			method : 'POST'
		},
		del : {
			method : 'POST'
		}
	})
});
dmsApp.factory('UnitService', function($resource) {
	return $resource(contextRoot + '/units/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		},
		update : {
			method : 'POST',
			params : {
				id : '@id'
			}
		},
		del : {
			method : 'POST',
			params : {
				id : '@id'
			}
		}
	})
});
