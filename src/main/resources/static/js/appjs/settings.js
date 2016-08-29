roomExpApp.controller('settingCtrl', function($scope) {

	var monthNames = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];

	var d = new Date();
	var month = monthNames[d.getMonth()];
	console.log(month);
	$scope.monthName = function() {
		console.log(month);
		return month;
	}

});