taskStories.controller('UsersCtrl',['$scope','UsersModel','EmailService',function($scope,UsersModel,EmailService){
	var getAllUsers= function(){
		UsersModel.all().then(function(res) {
			$scope.users = res.data;
		});
	}
	
	var initUsers= function(){
		$scope.users={};
		getAllUsers();
	}
	$scope.updateUser= function(user){
		if($scope.userForm.$valid){
			UsersModel.update(user.id, user).then(function(){
				
			})
		}
	}
	$scope.addUser= function(){
		UsersModel.create(angular.toJson($scope.newUser)).then(function(res){
			getAllUsers();
			$scope.newUserForm.$setPristine;
			$scope.newUserForm.$setUntouched;
			
			EmailService.sendEmail(angular.toJson({"emailId":$scope.newUser.email, "fromUser":"siddhiparkar15@gmail.com","recipients":$scope.newUser.email,"subject":"Welcome to Task stories"}));
		});
	}
	$scope.showMessages = function (field) {
        return $scope.newUserForm[field].$touched || $scope.newUserForm.$submitted;
      };
	initUsers();
}]);