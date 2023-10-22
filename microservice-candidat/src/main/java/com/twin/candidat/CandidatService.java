package com.twin.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    
        public Iterable<Candidat> getAllCandidats(){
            return candidatRepository.findAll();
        }

    public Candidat getCandidatById(int id){
        if(candidatRepository.findById(id).isPresent()){
            return candidatRepository.findById(id).get();
        }
        return null;
    }
    
    public Candidat addCandidat(Candidat c){
        return candidatRepository.save(c);
    }

    public Candidat updateCandidat(Candidat updatedCandidat, int id){
        if (candidatRepository.findById(id).isPresent()){
            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setNom(updatedCandidat.getNom());
            existingCandidat.setEmail(updatedCandidat.getEmail());
            existingCandidat.setPrenom(updatedCandidat.getEmail());
            return candidatRepository.save(existingCandidat);
        }
        return null;
    }

    public String deleteCandidat (int id){
        if(candidatRepository.findById(id).isPresent()){
            Candidat existingCandidat = candidatRepository.findById(id).get();
            candidatRepository.deleteById(id);
            return "candidat deleted";
        }
        return "candidat not found";
    }
}
