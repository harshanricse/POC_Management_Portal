package com.infosys.POC_Management_Portal.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.models.Status;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class POCDto {
    @NotNull(message="pocObjective should be present, please check")
    private String pocObjective;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message="startDate should be present, please check")
    private LocalDate startDate;

    @NotNull(message="endDate should be present, please check")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @NotNull(message="technology should be present, please check")
    private String technology;

    @NotNull(message="projectName should be present, please check")
    private String projectName;

    @NotNull(message="status should be present, please check")
    private Status status;

    @NotNull(message="keyLearnings should be present, please check")
    private String keyLearnings;

    @NotNull(message="spocName should be present, please check")
    private String spocName;

    @NotNull(message="spocEmail should be present, please check")
    @Email(message = "Please enter valid email")
    private String spocEmail;

    @NotNull(message="spocContact should be present, please check")
    private String spocContact;

    @NotNull(message="codeLocation should be present, please check")
    private String codeLocation;

    private String reviewedBy;
    private String toBeReviewedBy;

    public static POC preparePOCEntity(POCDto pocDto)
    {
        POC pocEntity = new POC();
        pocEntity.setPocObjective(pocDto.getPocObjective());
        pocEntity.setStartDate(pocDto.getStartDate());
        pocEntity.setEndDate(pocDto.getEndDate());
        pocEntity.setTechnology(pocDto.getTechnology());
        pocEntity.setProjectName(pocDto.getProjectName());
        pocEntity.setStatus(pocDto.getStatus());
        pocEntity.setKeyLearnings(pocDto.getKeyLearnings());
        pocEntity.setSpocName(pocDto.getSpocName());
        pocEntity.setSpocEmail(pocDto.getSpocEmail());
        pocEntity.setSpocContact(pocDto.getSpocContact());
        pocEntity.setCodeLocation(pocDto.getCodeLocation());
        pocEntity.setReviewedBy(pocDto.getReviewedBy());
        pocEntity.setToBeReviewedBy(pocDto.getToBeReviewedBy());
        return pocEntity;
    }
}
