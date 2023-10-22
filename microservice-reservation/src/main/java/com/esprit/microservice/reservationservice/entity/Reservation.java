package com.esprit.microservice.reservationservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable{
	private static final long serialVersionUID = 6711457437559348053L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private Date startDate;
	private Date endDate;
	private Double price;
	private Boolean state;
	private int idClient;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public int getIdClient() {
		return idClient;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"startDate=" + startDate +
				", endDate=" + endDate +
				", price=" + price +
				", state=" + state +
				", idClient=" + idClient +
				'}';
	}
}

