package com.client.taskstories.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.businessobjects.Story;
import com.client.taskstories.businessobjects.User;
import com.mongodb.BasicDBObject;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public enum UserDao {
	instance;
	MongoCollection<Document> userCollection = DatabaseConnection
			.getConnection().getCollection("Users");
	public ArrayList<User> getAllUsers(){
		ArrayList<User> users = new ArrayList<User>();
		BasicDBObject whereQuery = new BasicDBObject();
		MongoCursor<Document> cursor = userCollection.find().iterator();
		/*int count = (int) userCollection.count();*/
		while(cursor.hasNext()){
			Document nextElem = cursor.next();
			users.add(new User(nextElem.getString("name"), nextElem.getString("email"),nextElem.getInteger("id")));
		}
		return users;
		
	}
	
	public User getUserById(int id){
		User user= null;
		BasicDBObject whereQuery = new BasicDBObject();
		MongoCursor<Document> cursor =userCollection.find().iterator();
		while(cursor.hasNext()){
			Document nextElem= cursor.next();
			user = new User(nextElem.getString("email"),nextElem.getString("name"),nextElem.getDouble("id").intValue());
		}
		return user;
		
	}
	public void addUser(User user){
		int userIdCount= (int) userCollection.count();
		Document document = new Document();
		document.put("id", userIdCount++);
		document.put("name", user.getName());
		document.put("email", user.getEmail());
		userCollection.insertOne(document);
	}
	
	
	public void updateUser(User user){
		ArrayList<Story> stories = new ArrayList<Story>();
		Document newDOcument = new Document();
		int storyCount= (int)userCollection.count();
		newDOcument.put("name", user.getName());
		newDOcument.put("email", user.getEmail());
		newDOcument.put("id",user.getId());
		BasicDBObject searchQuery = new BasicDBObject().append("id", user.getId());
		userCollection.replaceOne(searchQuery,newDOcument);
	}
}
