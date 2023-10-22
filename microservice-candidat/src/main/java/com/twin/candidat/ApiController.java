package com.twin.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/candidat")
public class ApiController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping(value = "")
    @ResponseStatus
    public String welcome(){
        return "Welcome to Candidat Microservice";
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Iterable<Candidat>> getAllCandidats(){
        return new ResponseEntity<>(candidatService.getAllCandidats(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat c){
        return new ResponseEntity<>(candidatService.addCandidat(c), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Candidat> getCandidatById(@PathVariable("id") int id){
        return new ResponseEntity<>(candidatService.getCandidatById(id), HttpStatus.OK);
    }
    
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Candidat> updateCandidat(@RequestBody Candidat c,@PathVariable("id") int id){
        return new ResponseEntity<>(candidatService.updateCandidat(c,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus
    public ResponseEntity<String> deleteCandidat(@PathVariable("id") int id){
        return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
    }
}
