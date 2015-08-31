/**
 * 
 */

dmsApp.directive('back', ['$window', function($window) {
	return {
        restrict: 'A',
        link: function (scope, elem, attrs) {
            elem.bind('click', function () {
                $window.history.back();
            });
        }
    };
}]);
dmsApp.directive('ngConfirmBoxClick', [ function() {
        return {
            link: function (scope, element, attr) {
                var msg = attr.ngConfirmBoxClick;
                var clickAction = attr.confirmedClick;
                element.bind('click', function (event) {
                    if (window.confirm(msg)) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
} ]);
dmsApp.directive('bsDropdown', function ($compile) {
    return {
        restrict: 'E',
        scope: {
            items: '=dropdownData',
            doSelect: '&selectVal',
            selectedItem: '=preselectedItem'
        },
        link: function (scope, element, attrs) {
            var html = '';
            switch (attrs.menuType) {
                case "button":
                    html += '<div class="btn-group"><button class="btn button-label btn-info">{{selectedItem}}</button><button class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>';
                    break;
                default:
                    html += '<div class="dropdown"><a class="dropdown-toggle" role="button" data-toggle="dropdown"  href="javascript:;">Dropdown<b class="caret"></b></a>';
                    break;
            }
            html += '<ul class="dropdown-menu"><li ng-repeat="item in items"><a tabindex="-1" data-ng-click="selectVal(item)">{{item.unitName}}</a></li></ul></div>';
            element.append($compile(html)(scope));
            for (var i = 0; i < scope.items.length; i++) {
                if (scope.items[i].unitName === scope.selectedItem) {
                    scope.bSelectedItem = scope.items[i];
                    break;
                }
            }
            scope.selectVal = function (item) {
                switch (attrs.menuType) {
                    case "button":
                        $('button.button-label', element).html(item.unitName);
                        break;
                    default:
                        $('a.dropdown-toggle', element).html('<b class="caret"></b> ' + item.unitName);
                        break;
                }
                scope.doSelect({
                    selectedVal: item.unitName
                });
            };
            
            scope.selectVal(scope.bSelectedItem);
        }
    };
});
/*
dmsApp.directive('map',[ function () {
	return {
	  template: '<div></div>',
	  restrict: 'EA',
	  replace: true,
	  link: function (scope, element) {

	    scope.markers = [];

	    scope.map = new google.maps.Map(element[0], {
	      center: new google.maps.LatLng(36.1813, 127.3946),
	      zoom: 11
	    });

	    scope.addMarker = function (lat, lnt) {
	      var marker = new google.maps.Marker({
	        map: scope.map,
	        position:  new google.maps.LatLng(lat, lng)
	      });

	      scope.markers.push(marker);
	    };

	  }
	};
}]);
*/

