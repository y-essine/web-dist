package twin.microservice.assurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assurance")
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("/all")
    public Iterable<Assurance> getAllAssurances() {
        return assuranceService.getAllAssurances();
    }

    @PostMapping("/add")
    public Assurance addAssurance(@RequestBody Assurance assurance) {
        return assuranceService.addAssurance(assurance);
    }

    @PostMapping("/calculateCost/{typeAssurance}/{durationInDays}")
    public double calculateInsuranceCost(@PathVariable String typeAssurance, @PathVariable int durationInDays) {
        return assuranceService.calculateInsuranceCost(typeAssurance, durationInDays);
    }
    @PutMapping("/subscribe")
    public void subscribeInsurance(@RequestBody Assurance assurance) {
        assuranceService.subscribeInsurance(assurance);
    }
}
