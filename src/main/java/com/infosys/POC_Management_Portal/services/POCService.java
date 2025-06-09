package com.infosys.POC_Management_Portal.services;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.dtos.POCUpdateDto;
import com.infosys.POC_Management_Portal.models.Status;

import java.util.List;

public interface POCService {
    POCDto addPOC(POCDto pocDto);
    List<POCDto> getAllPOCs();
    List<POCDto> FetchFilteredPocs(Status status,String technology,String projectName);
    POCDto updatePOC(Long id, POCUpdateDto pocUpdateDto);
    POCDto getPOCById(Long id);
    void deletePOC(Long id);

}
