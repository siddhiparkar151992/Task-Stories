package com.client.taskstories.services.SMS;

import com.client.taskstories.businessobjects.Email;
import com.client.taskstories.services.MessageService;

public class SMSService implements MessageService{

	@Override
	public void sendMessage(Email email) {
		System.out.println("Message sent");
		
	}

}
