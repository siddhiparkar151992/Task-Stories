taskStories.controller("LoginCtrl",["$scope","$http","LoginService","$location",'$rootScope',function($scope,$http,LoginService,$location,$rootScope){
	LoginService.loginSuccess= false;
	
	$scope.authenticateUSer= function(){
		LoginService.authenticate(angular.toJson($scope.login)).success(function(res){
			if(res!=null && res!=""){
				$location.path("/");
				$scope.loginFailed= false;
				LoginService.loginSuccess= true;
			}
			else {
				$location.path("/login");
				$scope.login={};
				$scope.loginFailed= true;
				$scope.loginError = "Invalid login";
				LoginService.loginSuccess= false;
			}
			
		})
	}
}]);