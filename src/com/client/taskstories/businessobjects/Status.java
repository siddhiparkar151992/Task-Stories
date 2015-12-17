package com.client.taskstories.businessobjects;

public class Status {
	private String name;

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

	public Status(String name) {
		super();
		this.name = name;
	}
	
}
