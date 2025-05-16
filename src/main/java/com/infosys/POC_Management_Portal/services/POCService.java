package com.infosys.POC_Management_Portal.services;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.repositories.POCRepository;

import java.util.List;

public interface POCService {
    POCDto addPOC(POCDto pocDto);
    List<POCDto> getAllPOCs();
    POCDto updatePOC(Long id, POCDto pocDto);
    void deletePOC(Long id);

}
