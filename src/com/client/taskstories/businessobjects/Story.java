package com.client.taskstories.businessobjects;

public class Story {
	
	private int assignee;
	private String criteria;
	private String description;
	private int id;
	private int reporter;
	private String status;
	private String title;
	private String type;
	/**
	 * @return the assignee
	 */
	public int getAssignee() {
		return assignee;
	}
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(int assignee) {
		this.assignee = assignee;
	}
	/**
	 * @return the criteria
	 */
	public String getCriteria() {
		return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * @return the reporter
	 */
	public int getReporter() {
		return reporter;
	}
	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(int reporter) {
		this.reporter = reporter;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Story [assignee=" + assignee + ", criteria=" + criteria
				+ ", description=" + description + ", id=" + id + ", reporter="
				+ reporter + ", status=" + status + ", title=" + title
				+ ", type=" + type + "]";
	}
	public Story(int assignee, String criteria, String description, int id,
			int reporter, String status, String title, String type) {
		super();
		this.assignee = assignee;
		this.criteria = criteria;
		this.description = description;
		this.id = id;
		this.reporter = reporter;
		this.status = status;
		this.title = title;
		this.type = type;
	}
	
}
