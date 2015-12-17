package com.client.taskstories.resources.storyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.dao.StatusDao;
import com.client.taskstories.businessobjects.Status;
import com.mongodb.client.MongoCollection;


@Path("Status")
public class StatusResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Status> getStatus(){
		ArrayList<Status> status = StatusDao.instance.getStatuses();
		
		return status;
		
	}
}
