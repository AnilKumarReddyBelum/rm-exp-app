roomExpApp.controller('settingCtrl', function($scope, $http) {

	var monthNames = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];

	var d = new Date();
	var month = monthNames[d.getMonth()];
	$scope.monthName = function() {
		return month;
	}

	
	
	$scope.showAlert = function() {
		$http({
			method : 'GET',
			url : '/resetDB'
		}).then(function successCallback(response) {
			$scope.msg = response.data;
			console.log($scope.msg);
		}, function errorCallback(response) {
			$scope.msg = response.data;
			console.log($scope.msg);
		});
	}

});