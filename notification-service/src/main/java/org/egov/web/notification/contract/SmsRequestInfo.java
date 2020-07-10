package org.egov.web.notification.contract;


import org.egov.web.notification.producer.contract.SMSRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SmsRequestInfo {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;
	private SMSRequest smsRequest;
}
