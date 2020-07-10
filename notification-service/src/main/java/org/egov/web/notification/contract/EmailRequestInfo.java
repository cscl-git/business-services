package org.egov.web.notification.contract;


import org.egov.web.notification.producer.contract.EmailRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EmailRequestInfo {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;
	private EmailRequest emailRequest;
}
