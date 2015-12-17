package com.client.taskstories.businessobjects;

import java.util.ArrayList;

public class Email {
	private String emailId;
	private String subject;
	private String recipients;
	private String fromUser;
	private String mailContent;
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the recipients
	 */
	public String getRecipients() {
		return recipients;
	}
	/**
	 * @param recipients the recipients to set
	 */
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	/**
	 * @return the fromUser
	 */
	public String getFromUser() {
		return fromUser;
	}
	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}
	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public Email(String emailId, String subject,String recipients,
			String fromUser, String mailContent) {
		super();
		this.emailId = emailId;
		this.subject = subject;
		this.recipients = recipients;
		this.fromUser = fromUser;
		this.mailContent = mailContent;
	}
	
	public Email(String emailId, String subject,String recipients,
			String fromUser) {
		super();
		this.emailId = emailId;
		this.subject = subject;
		this.recipients = recipients;
		this.fromUser = fromUser;
	}
}
