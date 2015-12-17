package com.client.taskstories.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.client.taskstories.businessobjects.Email;



public class EmailGenerator {

	public  static void generateEmail(Email email) {

			final String username = "siddhiparkar15@gmail.com";
			final String password = "9664875508";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});

				Message message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress("siddhiparkar15@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email.getEmailId()));
					message.setSubject(email.getSubject());
					message.setText("Hi,\n you have been added to the taskstories as a User"+"Your email Id is: "+email.getEmailId()+"\n");

					Transport.send(message);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				

			
		

	}

	
	public  static void generateEmail(String mail) {



			final String username = "siddhiparkar15@gmail.com";
			final String password = "9664875508";
			final String host = "localhost";
			 Properties properties = System.getProperties();
			 properties.setProperty("mail.smtp.host", host);
			 Session session = Session.getDefaultInstance(properties);

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("siddhiparkar15@gmail.com"));

				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(mail));
				message.setSubject("Welcome To Online Library System");
				message.setText("Welcome");

				Transport.send(message);

				System.out.println("Email Sent to first Email address");
			}

			catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}

	}
	
