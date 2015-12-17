taskStories.service("LoginService",function($http, configService){
	this.loginSuccess=  false;
	this.authenticate= function(creds){
		return $http.post(configService.getUrl("Login/auth"),creds);
	}
	
	this.checkForAuth= function(){
		return this.loginSuccess;
	}
})