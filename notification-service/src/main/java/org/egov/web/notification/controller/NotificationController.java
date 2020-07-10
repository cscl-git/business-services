package org.egov.web.notification.controller;

import org.egov.web.notification.contract.EmailRequestInfo;
import org.egov.web.notification.contract.EmailResponse;
import org.egov.web.notification.contract.SmsRequestInfo;
import org.egov.web.notification.contract.SmsResponse;
import org.egov.web.notification.services.NotificationPushService;
import org.egov.web.notification.validator.EmailValidator;
import org.egov.web.notification.validator.SmsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	@Autowired
	private NotificationPushService notificationPushService;	
	@Autowired
	private SmsValidator smsValidator;
	@Autowired
	private EmailValidator emailValidator;
	
	@PostMapping("/sms/v1/_send")
	@ResponseBody
    private ResponseEntity<?> sendSms(@RequestBody SmsRequestInfo smsRequestInfo) {
		smsValidator.validate(smsRequestInfo.getSmsRequest());
		notificationPushService.pushSms(smsRequestInfo.getSmsRequest());
		return new ResponseEntity<>(new SmsResponse(null,true), HttpStatus.CREATED);
    }
	
	@PostMapping("/email/v1/_send")
	@ResponseBody
    private ResponseEntity<?> sendEmail(@RequestBody EmailRequestInfo emailRequestInfo) {
		emailValidator.validate(emailRequestInfo.getEmailRequest());
		notificationPushService.pushEmail(emailRequestInfo.getEmailRequest());
		return new ResponseEntity<>(new EmailResponse(null,true), HttpStatus.CREATED);
    }
}
