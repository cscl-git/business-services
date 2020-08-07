package org.egov.web.notification.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {
    private String apiId;
    private String ver;
    private Long ts;
    private String action;
    private String did;
    private String key;
    private String msgId;
    private String requesterId;
    private String authToken;
}
