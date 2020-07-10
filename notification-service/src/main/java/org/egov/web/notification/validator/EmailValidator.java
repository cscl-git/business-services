package org.egov.web.notification.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.egov.tracer.model.CustomException;
import org.egov.web.notification.producer.contract.EmailRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EmailValidator {
	public static final String INVALID_EMAIL_REQUEST_CODE = "NOTIFICATION_INVALID_EMAIL_REQUEST";
	public static final String INVALID_EMAIL_REQUEST_MSG = "Email address, subject & body can not be blank";
	
	public static final String INVALID_EMAIL_ADDRESS_CODE = "NOTIFICATION_INVALID_EMAIL_ADDRESS";
	public static final String INVALID_EMAIL_ADDRESS_MSG = "Invalid email address";
	
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public void validate(EmailRequest emailRequest) {
        if(StringUtils.isEmpty(emailRequest.getEmail())
        		|| StringUtils.isEmpty(emailRequest.getSubject())
        		|| StringUtils.isEmpty(emailRequest.getBody())) {
            throw new CustomException(INVALID_EMAIL_REQUEST_CODE,INVALID_EMAIL_REQUEST_MSG);
        }else {
        	if(!validEmail(emailRequest.getEmail())) {
        		throw new CustomException(INVALID_EMAIL_ADDRESS_CODE,INVALID_EMAIL_ADDRESS_MSG);
        	}
        }
    }
	
	public static boolean validEmail(String emailStr) {
	        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	        return matcher.find();
	}
}
