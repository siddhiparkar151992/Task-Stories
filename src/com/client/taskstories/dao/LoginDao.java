package com.client.taskstories.dao;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.businessobjects.Login;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public enum LoginDao {
	instance;
	MongoCollection<Document> loginCollection = DatabaseConnection
			.getConnection().getCollection("login");
	public Login authenticateUser(Login login){
		Login returnData = null;
		MongoCursor<Document> cursor = loginCollection.find().iterator();
		while(cursor.hasNext()){
			Document nextElem= cursor.next();
			if(nextElem.getString("username").equals(login.getUserName())&& nextElem.getString("password").equals(login.getPassword())){
				returnData= new Login(nextElem.getInteger("userId"), nextElem.getString("password"), login.getUserName());
			}
		}
		return returnData;
		
	}
}
