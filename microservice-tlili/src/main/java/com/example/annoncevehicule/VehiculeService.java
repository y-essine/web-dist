package com.example.annoncevehicule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Vehicule addVehicule(Vehicule v){
        return vehiculeRepository.save(v);
    }

    public List<Vehicule> getAllVehicule(){
        return vehiculeRepository.findAll();
    }

    public Vehicule updateVehicule(Vehicule v, int id){
        if (vehiculeRepository.findById(id).isPresent()){
            Vehicule existingVehicule = vehiculeRepository.findById(id).get();
            existingVehicule.setMarque(v.getMarque());
            existingVehicule.setModele(v.getModele());
            existingVehicule.setImmatriculation(v.getImmatriculation());
            existingVehicule.setCouleur(v.getCouleur());
            existingVehicule.setPlace(v.getPlace());
            existingVehicule.setPrixParJour(v.getPrixParJour());
            existingVehicule.setDisponibilite(v.getDisponibilite());
            return vehiculeRepository.save(existingVehicule);
        }
        return null;
    }

    public String deleteVehicule(int id){
        if(vehiculeRepository.findById(id).isPresent()){
            Vehicule existingVehicule = vehiculeRepository.findById(id).get();
            vehiculeRepository.deleteById(id);
            return "Vehicule deleted";
        }
        return "Vehicule not found";
    }
}
