package com.infosys.POC_Management_Portal.repositories;

import com.infosys.POC_Management_Portal.models.POC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POCRepository extends JpaRepository<POC,Long> {
}
