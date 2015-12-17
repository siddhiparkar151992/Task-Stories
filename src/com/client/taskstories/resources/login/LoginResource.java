package com.client.taskstories.resources.login;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.taskstories.dao.LoginDao;
import com.client.taskstories.businessobjects.Login;
import com.client.taskstories.businessobjects.Story;

@Path("Login")
public class LoginResource {
	/*
	 * Get a random Survey
	 */
	@POST
	@Path("auth")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Login authenticateUser(Login login) throws SQLException {
		Login returnData = LoginDao.instance.authenticateUser(login);
		return returnData;
		
	}
}
