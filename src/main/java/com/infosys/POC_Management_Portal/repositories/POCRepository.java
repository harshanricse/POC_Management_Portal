package com.infosys.POC_Management_Portal.repositories;

import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface POCRepository extends JpaRepository<POC,Long> {
    //List<POC> findAllByStatusOrTechnologyIgnoreCaseOrProjectNameIgnoreCase(Status status, String technology, String projectName);
}
