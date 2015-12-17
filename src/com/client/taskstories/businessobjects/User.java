package com.client.taskstories.businessobjects;

public class User {
	private String name;
	private String email;
	private int id;
	public User(String name, String email, int id) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
	}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
