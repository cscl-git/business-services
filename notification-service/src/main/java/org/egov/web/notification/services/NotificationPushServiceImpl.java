package org.egov.web.notification.services;

import org.egov.tracer.kafka.CustomKafkaTemplate;
import org.egov.web.notification.producer.contract.EmailRequest;
import org.egov.web.notification.producer.contract.SMSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationPushServiceImpl implements NotificationPushService {

	@Autowired
	private CustomKafkaTemplate<String, SMSRequest> smsKafkaTemplate;
	@Value("${kafka.topics.notification.sms.name}")
	private String smsTopic;
	@Autowired
	private CustomKafkaTemplate<String, EmailRequest> emailKafkaTemplate;
	@Value("${kafka.topics.notification.mail.name}")
	private String emailTopic;

	@Override
	public void pushSms(SMSRequest smsRequest) {
		log.info("Kafka topic: {}, sms: {}",smsTopic,smsRequest.getMobileNumber());
		smsKafkaTemplate.send(smsTopic, smsRequest);
	}

	@Override
	public void pushEmail(EmailRequest emailRequest) {
		log.info("Kafka topic: {}, email: {}",emailTopic,emailRequest.getEmail());
		emailKafkaTemplate.send(emailTopic, emailRequest);
	}
}
