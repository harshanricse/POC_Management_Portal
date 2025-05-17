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
    private String pocObjective;
    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private String technology;
    @Column(nullable = false)
    private String projectName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String keyLearnings;
    @Column(nullable = false)
    private String spocName;
    @Column(nullable = false)
    private String spocEmail;
    @Column(nullable = false)
    private String spocContact;
    @Column(nullable = false)
    private String codeLocation;
    @Column(nullable = true)
    private String reviewedBy;
    @Column(nullable = true)
    private String toBeReviewedBy;

    public static POCDto preparePOCDto(POC poc){
        POCDto pocDto = new POCDto();
        pocDto.setPocObjective(poc.getPocObjective());
        pocDto.setStartDate(poc.getStartDate());
        pocDto.setEndDate(poc.getEndDate());
        pocDto.setTechnology(poc.getTechnology());
        pocDto.setProjectName(poc.getProjectName());
        pocDto.setStatus(poc.getStatus());
        pocDto.setKeyLearnings(poc.getKeyLearnings());
        pocDto.setSpocName(poc.getSpocName());
        pocDto.setSpocEmail(poc.getSpocEmail());
        pocDto.setSpocContact(poc.getSpocContact());
        pocDto.setCodeLocation(poc.getCodeLocation());
        pocDto.setReviewedBy(poc.getReviewedBy());
        pocDto.setToBeReviewedBy(poc.getToBeReviewedBy());
        return pocDto;
    }
}
