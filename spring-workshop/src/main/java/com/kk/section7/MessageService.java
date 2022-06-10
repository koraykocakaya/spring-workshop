package com.kk.section7;

public class MessageService {

	public EmailService emailService;
	
	public String getMessage() {
		return "From Message Service: " + emailService.print();
	}
	
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
}
