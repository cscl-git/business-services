package org.egov.hrms.web.contract;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;
import org.egov.hrms.model.HrmsEmployee;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HrmsEmployeeRequest {

	@NotNull
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;

	@Valid
	@NotEmpty
	@JsonProperty("Employees")
	private List<HrmsEmployee> employees;

	@Valid
	@NotEmpty
	@JsonProperty("Fields")
	private List<String> fields;
}