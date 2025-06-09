package com.infosys.POC_Management_Portal.services;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.dtos.POCUpdateDto;
import com.infosys.POC_Management_Portal.exceptions.POCNOTFoundException;
import com.infosys.POC_Management_Portal.models.POC;
import com.infosys.POC_Management_Portal.models.Status;
import com.infosys.POC_Management_Portal.repositories.POCRepository;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@PropertySource("classpath:Validation.properties")
public class POCServiceImpl implements POCService{
    @Autowired
    private POCRepository pocRepository;
    @Autowired
    private Environment env;

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
    public List<POCDto> FetchFilteredPocs(Status status, String technology, String projectName) {
//        List<POC> pocList = pocRepository.findAllByStatusOrTechnologyIgnoreCaseOrProjectNameIgnoreCase(status, technology, projectName);
//        List<POCDto> pocDtoList = new ArrayList<>();
//        for(POC poc: pocList){
//            pocDtoList.add(POC.preparePOCDto(poc));
//        }
        return null;//pocDtoList;
    }

    @Override
    public POCDto updatePOC(Long id, POCUpdateDto pocUpdateDto) {
        POC poc = pocRepository.findById(id).get();
        if(poc==null){
            throw new POCNOTFoundException(env.getProperty("poc.not.found").toString());
        }
        if(pocUpdateDto.getPocObjective()!=null){
            poc.setName(pocUpdateDto.getPocObjective());
        }
        if(pocUpdateDto.getStartDate()!=null){
            poc.setStartDate(pocUpdateDto.getStartDate());
        }
        if(pocUpdateDto.getEndDate()!=null){
            poc.setEndDate(pocUpdateDto.getEndDate());
        }

        if(pocUpdateDto.getStatus()!=null){
            poc.setStatus(pocUpdateDto.getStatus());
        }
        if(pocUpdateDto.getKeyLearnings()!=null){
            poc.setKeyLearnings(pocUpdateDto.getKeyLearnings());
        }
        if(pocUpdateDto.getSpocName()!=null){
            poc.setSpocName(pocUpdateDto.getSpocName());
        }
        if(pocUpdateDto.getSpocEmail()!=null){
            poc.setSpocEmail(pocUpdateDto.getSpocEmail());
        }
        if(pocUpdateDto.getSpocContact()!=null){
            poc.setSpocContact(pocUpdateDto.getSpocContact());
        }
        if(pocUpdateDto.getCodeLocation()!=null){
            poc.setCodeLocation(pocUpdateDto.getCodeLocation());
        }
        return  POC.preparePOCDto(pocRepository.save(poc));
    }

    @Override
    public POCDto getPOCById(Long id) {
        Optional<POC> poc = pocRepository.findById(id);
        if(poc.isEmpty()){
            throw new POCNOTFoundException(env.getProperty("poc.not.found").toString());
        }
        return POC.preparePOCDto(poc.get());
    }

    @Override
    public void deletePOC(Long id) {
        Optional<POC> poc = pocRepository.findById(id);
        if(poc.isEmpty()){
            throw new POCNOTFoundException(env.getProperty("poc.not.found").toString());
        }
        pocRepository.deleteById(id);
    }
}
