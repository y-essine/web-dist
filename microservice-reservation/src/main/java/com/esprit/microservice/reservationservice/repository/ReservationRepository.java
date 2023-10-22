package com.esprit.microservice.reservationservice.repository;


import com.esprit.microservice.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	   
}
