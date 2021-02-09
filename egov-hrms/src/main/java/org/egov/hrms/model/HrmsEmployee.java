package org.egov.hrms.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.egov.hrms.web.contract.User;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Validated
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@ToString
@Builder
public class HrmsEmployee {

    private Long id;

    private String uuid;

    @Size(min = 1, max = 256)
    private String code;

    private String employeeStatus;

    private String employeeType;

    private Long dateOfAppointment;
    
    private Long dateOfSuperannuation;

    @Valid
    @Size(max = 50)
    private List<Jurisdiction> jurisdictions = new ArrayList<>();

    @Valid
    private List<Assignment> assignments = new ArrayList<>();

    @Valid
    @Size(max=25)
    private List<ServiceHistory> serviceHistory = new ArrayList<>();


    private Boolean IsActive;

    @Valid
    @Size(max=25)
    private List<EducationalQualification> education = new ArrayList<>();

    @Valid
    @Size(max=25)
    private List<DepartmentalTest> tests = new ArrayList<>();

    @Size(max = 256)
    private String tenantId;

    @Valid
    @Size(max=50)
    private List<EmployeeDocument> documents = new ArrayList<>();

    @Valid
    private List<DeactivationDetails> deactivationDetails = new ArrayList<>();

    private AuditDetails auditDetails;
    
    @Valid
    private User user;
    
    private Long postDetailId ;

    private String hrmsCode;    
}