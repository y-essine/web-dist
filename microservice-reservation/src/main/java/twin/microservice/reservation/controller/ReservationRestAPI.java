package twin.microservice.reservation.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import twin.microservice.reservation.entity.Reservation;
import twin.microservice.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.net.http.*;

@RestController
@RequestMapping(value = "/api/reservation")
public class ReservationRestAPI {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ReservationService reservationService;


    @GetMapping("/getAllVehicules")
    public List<Map<String, Object>> getAllVehicles(@RequestHeader("Authorization") String authorizationHeader) {
        String apiUrl = "http://localhost:8080/api/vehicule/all";
        HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:8080/api/vehicule/all"))
    .header("Authorization", "Bearer " + authorizationHeader)
    .method("GET", HttpRequest.BodyPublishers.noBody())
    .build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return Collections.emptyList();
        }
    }
    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }


    @GetMapping("/reservedVehicules")
    public List<Reservation> getReservedVehicules() {
        List<Reservation> reservations = reservationService.getAllReservations();

        List<Map<String, Object>> allVehicles = getAllVehicles();

        List<Reservation> reservedVehicules = new ArrayList<>();

        for (Reservation reservation : reservations) {
            int reservationVehiculeId = reservation.getIdVehicule();
            for (Map<String, Object> vehicule : allVehicles) {
                int vehiculeId = (int) vehicule.get("id");
                if (reservationVehiculeId == vehiculeId) {
                    reservedVehicules.add(reservation);
                    break;
                }
            }
        }
        return reservedVehicules;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createCandidat(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateCandidat(
            @PathVariable(value = "id") int id,
            @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }
}
