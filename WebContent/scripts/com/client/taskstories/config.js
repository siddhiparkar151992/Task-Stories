taskStories.config(function($routeProvider){
	$routeProvider.when("/",{
		templateUrl:'scripts/com/client/taskstories/storyboard/tmpl/storyboard.html',
		controller:'StoryBoardCtrl',
		resolve:{
        	"check":function(LoginService, $location){
        		if(!LoginService.checkForAuth()) {
        			$location.path("/login");
        		}
        	}
        }
	}).when('/dashboard', {
        templateUrl: 'src/angello/dashboard/tmpl/dashboard.html',
        controller: 'DashboardCtrl',
        controllerAs: 'dashboard',
        resolve:{
        	"check":function(LoginService, $location){
        		if(!LoginService.checkForAuth()) {
        			$location.path("/login");
        		}
        	}
        }
    })
    .when('/users', {
        templateUrl:'scripts/com/client/taskstories/user/tmpl/Users.html' ,
        controller: 'UsersCtrl',
        controllerAs: 'users',
        resolve:{
        	"check":function(LoginService, $location){
        		if(!LoginService.checkForAuth()) {
        			$location.path("/login");
        		}
        	}
        }
    })
    .when('/users/:userId', {
        templateUrl: 'scripts/com/client/taskstories/user/tmpl/user.html',
        controller: 'UserCtrl',
        controllerAs: 'myUser',
        resolve:{
        	"check":function(LoginService, $location){
        		if(!LoginService.checkForAuth()) {
        			$location.path("/login");
        		}
        	}
        }
    })
    .when('/login', {
        templateUrl: 'scripts/com/client/taskstories/login/tmpl/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
    })
	.otherwise({
		redirectTo:'/'
	});
});
