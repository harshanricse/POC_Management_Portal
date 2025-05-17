package com.infosys.POC_Management_Portal.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infosys.POC_Management_Portal.models.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class POCUpdateDto {
    private String pocObjective;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    private String technology;
    private String projectName;
    private Status status;
    private String keyLearnings;
    private String spocName;
    private String spocEmail;
    private String spocContact;
    private String codeLocation;
    private String reviewedBy;
    private String toBeReviewedBy;

}
