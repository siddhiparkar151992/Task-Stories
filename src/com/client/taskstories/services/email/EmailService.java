package com.client.taskstories.services.email;

import com.client.taskstories.businessobjects.Email;
import com.client.taskstories.services.MessageService;
import com.client.taskstories.util.EmailGenerator;

public class EmailService implements MessageService{

	@Override
	public void sendMessage(Email email) {
		EmailGenerator.generateEmail(email);
		
	}
	
}
