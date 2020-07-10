package org.egov.web.notification.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.egov.tracer.model.CustomException;
import org.egov.web.notification.producer.contract.SMSRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SmsValidator {
	public static final String INVALID_SMS_REQUEST_CODE = "NOTIFICATION_INVALID_SMS_REQUEST";
	public static final String INVALID_SMS_REQUEST_MSG = "Mobile number & messsage can not be blank";
	
	public static final String INVALID_SMS_ADDRESS_CODE = "NOTIFICATION_INVALID_SMS_ADDRESS";
	public static final String INVALID_SMS_ADDRESS_MSG = "Invalid mobile number";
	
	private static final Pattern VALID_SMS_ADDRESS_REGEX = 
		    Pattern.compile("^[0-9]{10}$");
	
	public void validate(SMSRequest smsRequest) {
        if(StringUtils.isEmpty(smsRequest.getMobileNumber())
        		|| StringUtils.isEmpty(smsRequest.getMessage())) {
            throw new CustomException(INVALID_SMS_REQUEST_CODE,INVALID_SMS_REQUEST_MSG);
        }else {
        	if(!validMobileNumber(smsRequest.getMobileNumber())) {
        		throw new CustomException(INVALID_SMS_ADDRESS_CODE,INVALID_SMS_ADDRESS_MSG);
        	}
        }
    }
	
	public static boolean validMobileNumber(String mobileNumber) {
	        Matcher matcher = VALID_SMS_ADDRESS_REGEX.matcher(mobileNumber);
	        return matcher.find();
	}
}
