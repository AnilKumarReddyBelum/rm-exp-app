roomExpApp.controller('viewExpensesCtrl', function($scope, $http) {
	
    $http.get('/getExpenseRecords').success(function(data) {
           $scope.myData = data;
      });

  $scope.gridOptions = {
          data: 'myData',
          enableRowSelection: false,
          enableCellEditOnFocus: true,
          enableRowSelection: false,
          enablePaging: true,
          multiSelect: false, 
          columnDefs: [
            { field: 'id', displayName: 'Expense Id' } ,
            { field: 'owner', displayName: 'Owner Of The Expense' } ,
            { field: 'cost', displayName: 'Amount Spent'} ,
            { field: 'spentDate', displayName: 'Spent Date'} 
          ]
        };

});


