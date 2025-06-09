package com.infosys.POC_Management_Portal.controllers;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.dtos.POCUpdateDto;
import com.infosys.POC_Management_Portal.models.Status;
import com.infosys.POC_Management_Portal.services.POCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/poc")
public class PocController {
    @Autowired
    private POCService pocService;
    @PostMapping("/create")
    public ResponseEntity<POCDto> createPOC(@Valid @RequestBody POCDto pocDto){
        pocDto = pocService.addPOC(pocDto);
        return new ResponseEntity(pocDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<POCDto>> getAllPOC(){
        List<POCDto> pocDtos = pocService.getAllPOCs();
        return new ResponseEntity<>(pocDtos, HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<POCDto> getPOCById(@PathVariable("Id") Long id){
        POCDto pocDto = pocService.getPOCById(id);
        return new ResponseEntity(pocDto, HttpStatus.OK);
    }
    @GetMapping("/filterby")
    public List<POCDto> FetchProducts(
            @RequestParam(required = false) Status status, @RequestParam(required = false) String technology, @RequestParam(required = false) String projectName) {
        return pocService.FetchFilteredPocs(status, technology, projectName);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<POCDto> updatePOC(@PathVariable("Id") Long id,@RequestBody POCUpdateDto pocUpdateDto){
        POCDto pocDto = pocService.updatePOC(id, pocUpdateDto);
        return new ResponseEntity(pocDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deletePOC(@PathVariable("Id") Long id){
        pocService.deletePOC(id);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }
}
