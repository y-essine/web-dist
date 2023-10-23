package twin.microservice.vehicule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {
}
