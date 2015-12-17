package com.client.taskstories.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.businessobjects.Story;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public enum StoryDao {
	instance;
	MongoCollection<Document> storyCollection = DatabaseConnection
			.getConnection().getCollection("story");

	public ArrayList<Story> getAllStories() {
		ArrayList<Story> stories = new ArrayList<Story>();
		MongoCursor<Document> cursor = storyCollection.find().iterator();
		 BasicDBObject whereQuery = new BasicDBObject();
		while (cursor.hasNext()) {
			Document nextElem = cursor.next();
			
			stories.add(new Story(nextElem.getInteger("assignee"), nextElem.get("criteria")
					.toString(), nextElem.get("description").toString(),
					nextElem.getInteger("id").intValue(),
					nextElem.getInteger("reporter").intValue(),
					nextElem.get("status").toString(),nextElem
							.get("title").toString(), nextElem.get("type")
							.toString()));
		}
		return stories;
	}
	public void addStory(Story story){
		ArrayList<Story> stories = new ArrayList<Story>();
		Document newDOcument = new Document();
		int storyCount= (int)storyCollection.count();
		newDOcument.put("assignee", story.getAssignee());
		newDOcument.put("criteria", story.getCriteria());
		newDOcument.put("description", story.getDescription());
		newDOcument.put("reporter", story.getReporter());
		newDOcument.put("status", story.getStatus());
		newDOcument.put("title",story.getTitle());
		newDOcument.put("type",story.getType());
		newDOcument.put("id",storyCount++);
		storyCollection.insertOne(newDOcument);
	}
	public void deleteStory(int storyId){
		BasicDBObject document = new BasicDBObject();
		document.put("id", storyId);
		storyCollection.deleteOne(document);
	}
	
	public void updateStory(int id, Story story){
		ArrayList<Story> stories = new ArrayList<Story>();
		Document newDOcument = new Document();
		int storyCount= (int)storyCollection.count();
		newDOcument.put("assignee", story.getAssignee());
		newDOcument.put("criteria", story.getCriteria());
		newDOcument.put("description", story.getDescription());
		newDOcument.put("reporter", story.getReporter());
		newDOcument.put("status", story.getStatus());
		newDOcument.put("title",story.getTitle());
		newDOcument.put("type",story.getType());
		newDOcument.put("id",id);
		BasicDBObject searchQuery = new BasicDBObject().append("id", id);
		storyCollection.replaceOne(searchQuery,newDOcument);
	}
}
