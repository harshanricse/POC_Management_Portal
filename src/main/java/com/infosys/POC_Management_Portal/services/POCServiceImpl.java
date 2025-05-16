package com.infosys.POC_Management_Portal.services;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.exceptions.POCNOTFoundException;
import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.repositories.POCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class POCServiceImpl implements POCService{
    @Autowired
    private POCRepository pocRepository;
    @Override
    public POCDto addPOC(POCDto pocDto) {
        POC poc = POCDto.preparePOCEntity(pocDto);
        return POC.preparePOCDto(pocRepository.save(poc));
    }
    @Override
    public List<POCDto> getAllPOCs() {
        List<POC> pocList = pocRepository.findAll();
        List<POCDto> pocDtoList = new ArrayList<>();
        for(POC poc: pocList){
            pocDtoList.add(POC.preparePOCDto(poc));
        }
        return pocDtoList;
    }

    @Override
    public POCDto updatePOC(Long id, POCDto pocDto) {
        Optional<POC> poc = pocRepository.findById(id);
        if(poc.isEmpty()){
            throw new POCNOTFoundException("poc not found");
        }
        POC poc1 = poc.get();

        return null;
    }

    @Override
    public void deletePOC(Long id) {
        pocRepository.deleteById(id);
    }
}
