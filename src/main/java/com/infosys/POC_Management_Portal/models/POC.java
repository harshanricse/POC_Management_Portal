package com.infosys.POC_Management_Portal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infosys.POC_Management_Portal.dtos.POCDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class POC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private String clientName;
    @Column(nullable = false)
    private String spocName;
    @Column(nullable = false)
    private String spocEmail;
    @Column(nullable = false)
    private String spocContact;
    @Column(nullable = false)
    private String uploadDeck;
    @Column(nullable = false)
    private String codeLocation;
    @Column(nullable = true)
    private String remarks;
    @Column(nullable = true)
    private String category;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String keyLearnings;
    @Column(nullable = false)
    private String environmentDetails;
    @Column(nullable = true)
    private String pocReviewedBy;

    public static POCDto preparePOCDto(POC poc){
        POCDto pocDto = new POCDto();
        pocDto.setName(poc.getName());
        pocDto.setDescription(poc.getDescription());
        pocDto.setCreatedBy(poc.getCreatedBy());
        pocDto.setStartDate(poc.getStartDate());
        pocDto.setEndDate(poc.getEndDate());
        pocDto.setClientName(poc.getClientName());
        pocDto.setSpocName(poc.getSpocName());
        pocDto.setSpocEmail(poc.getSpocEmail());
        pocDto.setSpocContact(poc.getSpocContact());
        pocDto.setUploadDeck(poc.getUploadDeck());
        pocDto.setCodeLocation(poc.getCodeLocation());
        pocDto.setRemarks(poc.getRemarks());
        pocDto.setCategory(poc.getCategory());
        pocDto.setStatus(poc.getStatus());
        pocDto.setKeyLearnings(poc.getKeyLearnings());
        pocDto.setEnvironmentDetails(poc.getEnvironmentDetails());
        pocDto.setPocReviewedBy(poc.getPocReviewedBy());
        return pocDto;
    }
}
