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
    @NotNull(message="name for poc should be present, please check")
    private String name;

    @NotNull(message="description for poc should be present, please check")
    private String description;

    @NotNull(message="createdBy for poc should be present, please check")
    private String createdBy;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message="startDate should be present, please check")
    private LocalDate startDate;

    @NotNull(message="endDate should be present, please check")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @NotNull(message="clientName should be present, please check")
    private String clientName;

    @NotNull(message="spocName should be present, please check")
    private String spocName;

    @NotNull(message="spocEmail should be present, please check")
    @Email(message = "Please enter valid email")
    private String spocEmail;

    @NotNull(message="spocContact should be present, please check")
    private String spocContact;

    private String uploadDeck;

    @NotNull(message="codeLocation should be present, please check")
    private String codeLocation;

    private String remarks;

    private String category;

    @NotNull(message="status should be present, please check")
    private Status status;

    @NotNull(message="keyLearnings should be present, please check")
    private String keyLearnings;

    private String environmentDetails;
    private String pocReviewedBy;

    public static POC preparePOCEntity(POCDto pocDto)
    {
        POC pocEntity = new POC();
        pocEntity.setName(pocDto.getName());
        pocEntity.setDescription(pocDto.getDescription());
        pocEntity.setCreatedBy(pocDto.getCreatedBy());
        pocEntity.setStartDate(pocDto.getStartDate());
        pocEntity.setEndDate(pocDto.getEndDate());
        pocEntity.setClientName(pocDto.getClientName());
        pocEntity.setSpocName(pocDto.getSpocName());
        pocEntity.setSpocEmail(pocDto.getSpocEmail());
        pocEntity.setSpocContact(pocDto.getSpocContact());
        pocEntity.setUploadDeck(pocDto.getUploadDeck());
        pocEntity.setCodeLocation(pocDto.getCodeLocation());
        pocEntity.setRemarks(pocDto.getRemarks());
        pocEntity.setCategory(pocDto.getCategory());
        pocEntity.setStatus(pocDto.getStatus());
        pocEntity.setKeyLearnings(pocDto.getKeyLearnings());
        pocEntity.setEnvironmentDetails(pocDto.getEnvironmentDetails());
        pocEntity.setPocReviewedBy(pocDto.getPocReviewedBy());
        return pocEntity;
    }
}
