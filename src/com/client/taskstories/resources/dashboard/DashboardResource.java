package com.client.taskstories.resources.dashboard;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.taskstories.businessobjects.Story;

@Path("Dashboard")
public class DashboardResource {
	/*
	 * Get a random Survey
	 */
	@GET
	@Path("dashboard")
	@Produces(MediaType.APPLICATION_JSON)
	public Story getDashboard() throws SQLException {
		return null;
		
	}
}
