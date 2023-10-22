package com.example.annoncevehicule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicules")
public class VehiculeRestApi {
    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus
    public ResponseEntity<Vehicule> createCandidat(@RequestBody Vehicule v){
        return new ResponseEntity<>(vehiculeService.addVehicule(v), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Vehicule> getAllEquipe(){
        return vehiculeService.getAllVehicule();
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Vehicule> updateCandidat(@RequestBody Vehicule v,@PathVariable("id") int id){
        return new ResponseEntity<>(vehiculeService.updateVehicule(v,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus
    public ResponseEntity<String> deleteCandidat(@PathVariable("id") int id){
        return new ResponseEntity<>(vehiculeService.deleteVehicule(id), HttpStatus.OK);
    }


}
