package com.example.microassurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssuranceService {
    @Autowired
    private AssuranceRepository assuranceRepository;
    public double calculateInsuranceCost(String typeAssurance, int durationInDays) {

        double baseCost = 5.0;
        if (typeAssurance.equalsIgnoreCase("basic")) {
            return baseCost * durationInDays;
        } else if (typeAssurance.equalsIgnoreCase("premium")) {
            return baseCost * durationInDays * 1.5;
        } else {
            return 0.0;
        }
    }
    public void subscribeInsurance(Assurance assurance) {
        assurance.setUser_id(123);
        assuranceRepository.save(assurance);



    }
    public Assurance addAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }
}
