taskStories.service("EmailService",function($http, configService){
	
	this.sendEmail= function(email){
		return $http.post(configService.getUrl("Email/Send"),email);
	}
	
})