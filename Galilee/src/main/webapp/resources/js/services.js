
var contextRoot = '/naemp';

naempApp.factory('SiteByRiver', function($resource) {
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

naempApp.factory('SiteInfoByRiver', function($resource) {
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

naempApp.factory('ValueService', function($resource) {
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

naempApp.factory('TermValueBySite', function($resource) {
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
naempApp.factory('TermSpatialDataBySite', function($resource) {
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
naempApp.factory('ValueBySite', function($resource) {
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


naempApp.factory('TermValueByFish', function($resource) {
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

naempApp.factory('ValueByFish', function($resource) {
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

naempApp.factory('SurveyYear', function($resource) {
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

naempApp.factory('SourcesService', function($resource) {
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

naempApp.factory('SourceService', function($resource) {
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

naempApp.factory('SiteInfosService', function($resource) {
	return $resource(contextRoot + '/siteInfos', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
naempApp.factory('SiteInfoListFind', function($resource) {
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
naempApp.factory('SitesService', function($resource) {
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
naempApp.factory('SiteService', function($resource) {
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


naempApp.factory('SiteListFind', function($resource) {
	
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

naempApp.factory('SiteByRiver', function($resource) {
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

naempApp.factory('RiversService', function($resource) {
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
naempApp.factory('RiverService', function($resource) {
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
naempApp.factory('RiverListFind', function($resource) {
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

naempApp.factory('SiteCodeFindAll', function($resource) {
	return $resource(contextRoot + '/siteCodes', {}, {
		findall : {
			method : 'GET',
			cache : true,
			isArray : true
		}
	})
});
naempApp.factory('SiteCodeFind', function($resource) {
	return $resource(contextRoot + '/siteCode/:id', {}, {
		find : {
			method : 'GET',
			params : {
				id : '@id'
			}
		}
	})
});
naempApp.factory('SiteCodeCreate', function($resource) {
	return $resource(contextRoot + '/siteCode/create', {}, {
		create : {
			method : 'POST'
		}
	})
});
naempApp.factory('SiteCodeUpdate', function($resource) {
	return $resource(contextRoot + '/siteCode/update', {}, {
		update : {
			method : 'POST'
		}
	})
});
naempApp.factory('SiteCodeDelete', function($resource) {
	return $resource(contextRoot + '/siteCode/delete', {}, {
		del : {
			method : 'POST'
		}
	})
});

/**
 * Features
 */
naempApp.factory('FeaturesService', function($resource) {
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

naempApp.factory('FeatureService', function($resource) {
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



naempApp.factory('FishByFeature', function($resource) {
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

naempApp.factory('FishesService', function($resource) {
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

naempApp.factory('FishService', function($resource) {
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

naempApp.factory('FishListFind', function($resource) {
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

naempApp.factory('MethodsService', function($resource) {
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
naempApp.factory('MethodService', function($resource) {
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

naempApp.factory('VariablesService', function($resource) {
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
naempApp.factory('VariableService', function($resource) {
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

naempApp.factory('UnitsService', function($resource) {
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
naempApp.factory('UnitService', function($resource) {
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
