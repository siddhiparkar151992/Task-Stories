angular.module('taskStories').service('UsersModel',function($http, configService){
	var Model="Users";
	this.all = function(){
		return $http.get(configService.getUrl(Model)).then(function(res){
			return res;
		});
	}

	this.getUserById= function(id){
		return $http.get(configService.getUrlById(Model, id)).then(function(res){
			return res;
		});
	};
	
	this.create= function(user){
		return $http.post(configService.getUrl(Model+"/AddUser"),user);
	}
	
	this.update= function(id , user){
		return $http.post(configService.getUrlById(Model+"/updateUser", id), user);
	};
	this.deleteEntity= function(id){
		return $http.post(configService.getUrlById(Model+"/DeleteUser", id));
	};
});