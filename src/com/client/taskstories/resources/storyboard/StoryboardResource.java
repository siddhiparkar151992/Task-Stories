package com.client.taskstories.resources.storyboard;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.dao.StatusDao;
import com.client.taskstories.dao.StoryDao;
import com.client.taskstories.businessobjects.Status;
import com.client.taskstories.businessobjects.Story;
import com.mongodb.client.MongoCollection;

@Path("Story")
public class StoryboardResource {
	
	/*
	 * Get All stories
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Story> getAllStories() {
		ArrayList<Story> stories = StoryDao.instance.getAllStories();
		
		return stories;
	}
	
	@POST
	@Path("DeleteStory/{storyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Story> deleteStory(@PathParam("storyId") int storyId) {
		StoryDao.instance.deleteStory(storyId);
		ArrayList<Story> stories = StoryDao.instance.getAllStories();
		return stories;
	}
	
	@POST
	@Path("UpdateStory/{storyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Story> updateStory(@PathParam("storyId") int storyId,Story story) {
		StoryDao.instance.updateStory(storyId, story);
		ArrayList<Story> stories = StoryDao.instance.getAllStories();
		return stories;
	}
	
	@POST
	@Path("AddStory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Story> addStory(Story story) {
		StoryDao.instance.addStory(story);
		ArrayList<Story> stories = StoryDao.instance.getAllStories();
		return stories;
	}
}
