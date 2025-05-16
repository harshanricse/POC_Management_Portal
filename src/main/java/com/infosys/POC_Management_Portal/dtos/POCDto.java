package com.infosys.POC_Management_Portal.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.models.Status;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
public class POCDto {
    @NotNull
    private String pocObjective;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate startDate;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @NotNull
    private String technology;
    @NotNull
    private String projectName;
    @NotNull
    private Status status;
    @NotNull
    private String keyLearnings;
    @NotNull
    private String spocName;
    @NotNull
    private String spocEmail;
    @NotNull
    private String spocContact;
    @NotNull
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
