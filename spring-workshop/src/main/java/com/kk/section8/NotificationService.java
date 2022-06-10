package com.kk.section8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class NotificationService {

	@Autowired
	@Qualifier("smsService2")
	private SmsService smsService;
	
	// Bean olmasa bile ayaga kalkacaktir
	@Autowired (required = false)
	private EmailService emailService;
	
	public String send() {
		String msgDetail = "";
		if(smsService != null)
			msgDetail = smsService.send();
		return "Notification : " + msgDetail;
	}
	
	public EmailService getEmailService() {
		return emailService;
	}
}
