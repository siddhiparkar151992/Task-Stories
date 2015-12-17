angular.module('taskStories').service('configService', function($rootScope){
	var endPOintMap = {
			baseUrl:'/TaskStories/Stories',
	}
	
	this.getUrl =  function(model){
		return endPOintMap.baseUrl + '/'+model; 
	}
	
	this.getUrlById = function(model, id){
		return this.getUrl(model) + '/'+id; 
	}
})