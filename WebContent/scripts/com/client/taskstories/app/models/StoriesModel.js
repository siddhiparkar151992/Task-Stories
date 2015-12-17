angular.module('taskStories').service('StoriesModel', function($http, configService){
	var Model="Story";
	this.all= function(){
		return $http.get(configService.getUrl(Model)).then(function(res){
			return res;
		});
	};
	
	this.getStoryById= function(id){
		return $http.get(configService.getUrlById(Model, id)).then(function(res){
			return res;
		});
	};
	
	this.create= function(story){
		return $http.post(configService.getUrl(Model+"/AddStory",story));
	}
	
	this.update= function(id, story){
		return $http.post(configService.getUrlById(Model+"/UpdateStory", id), story);
	};
	this.deleteEntity= function(id){
		return $http.post(configService.getUrlById(Model+"/DeleteStory", id));
	};
	
});







