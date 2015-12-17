package com.client.taskstories.resources.EmailResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.taskstories.businessobjects.Email;
import com.client.taskstories.util.EmailGenerator;

@Path("Email")
public class EmailResource {

	@POST
	@Path("Send")
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendMessage(Email email){
		EmailGenerator.generateEmail(email);
	}
}
