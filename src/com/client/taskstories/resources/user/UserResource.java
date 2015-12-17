package com.client.taskstories.resources.user;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.taskstories.dao.UserDao;
import com.client.taskstories.businessobjects.User;


@Path("Users")
public class UserResource {
	//get all users
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> users= UserDao.instance.getAllUsers();
		return users;
		
	}
	
	
	/*
	 * Get a particular User by Id 
	 */
	@GET
	@Path("getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") int userId) throws SQLException {
		User user = UserDao.instance.getUserById(userId);
		return user;
		
	}
	
	@POST
	@Path("updateUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> updateUser(@PathParam("userId") int userId, User user){
		UserDao.instance.updateUser(user);
		ArrayList<User> users= UserDao.instance.getAllUsers();
		return null;
		
	}
	
	@POST
	@Path("AddUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(User user){
		UserDao.instance.addUser(user);
	}
}
