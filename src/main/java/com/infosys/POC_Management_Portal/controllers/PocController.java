package com.infosys.POC_Management_Portal.controllers;

import com.infosys.POC_Management_Portal.dtos.POCDto;
import com.infosys.POC_Management_Portal.services.POCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poc")
public class PocController {
    @Autowired
    private POCService pocService;
    @PostMapping("/create")
    public ResponseEntity<POCDto> createPOC(@RequestBody POCDto pocDto){
        pocDto = pocService.addPOC(pocDto);
        return new ResponseEntity(pocDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<POCDto>> getAllPOC(){
        List<POCDto> pocDtos = pocService.getAllPOCs();
        return new ResponseEntity<>(pocDtos, HttpStatus.OK);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<POCDto> updatePOC(@PathVariable("Id") Long id,@RequestBody POCDto pocDto){
        pocDto = pocService.updatePOC(id, pocDto);
        return new ResponseEntity(pocDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deletePOC(@PathVariable("Id") Long id){
        pocService.deletePOC(id);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }
}
