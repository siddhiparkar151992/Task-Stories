package com.client.taskstories.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.client.taskstories.DatabaseConnection.DatabaseConnection;
import com.client.taskstories.businessobjects.Status;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public enum StatusDao {
	instance;
	MongoCollection<Document> statusCollection = DatabaseConnection
			.getConnection().getCollection("status");

	public ArrayList<Status> getStatuses() {
		ArrayList<Status> statusList = new ArrayList<Status>();
		MongoCursor<Document> cursor = statusCollection.find().iterator();
		while (cursor.hasNext()) {
			statusList.add(new Status(cursor.next().getString("name")));
		}
		return statusList;

	}
}
