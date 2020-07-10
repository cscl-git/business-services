package org.egov.web.notification.services;

import org.egov.web.notification.producer.contract.EmailRequest;
import org.egov.web.notification.producer.contract.SMSRequest;

public interface NotificationPushService {  
	
    void pushSms(SMSRequest smsRequest);
    
    void pushEmail(EmailRequest email);
}
