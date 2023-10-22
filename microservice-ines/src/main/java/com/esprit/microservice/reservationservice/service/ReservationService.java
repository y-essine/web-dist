package com.esprit.microservice.reservationservice.service;

import com.esprit.microservice.reservationservice.entity.Reservation;
import com.esprit.microservice.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	public Reservation updateReservation(int id, Reservation newReservation) {
		if (reservationRepository.findById(id).isPresent()) {
			Reservation existingReservation = reservationRepository.findById(id).get();
			existingReservation.setStartDate(newReservation.getStartDate());
			existingReservation.setEndDate(newReservation.getEndDate());
			existingReservation.setPrice(newReservation.getPrice());
			existingReservation.setState(newReservation.getState());

			return reservationRepository.save(existingReservation);
		} else
			return null;
	}
	public String deleteReservation(int id) {
		if (reservationRepository.findById(id).isPresent()) {
			reservationRepository.deleteById(id);
			return "Reservation deleted";
		} else
			return "Reservation cannot be deleted";
	}
}

