package com.rudniev.synergywaytest.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	@Id
	private int id;
	private FlightStatus flight_status;
	private int air_company_id;
	private int airplane_id;
	private String departure_country;
	private String destination_country;
	private int distance;
	private int estimate_flight_time;
	private Timestamp started_at;
	private Timestamp ended_at;
	private Timestamp delay_started_at;
	private Timestamp created_at;

	public Flight() {
	}
	
	

	public Flight(int id, FlightStatus flight_status, int air_company_id, int airplane_id, String departure_country,
			String destination_country, int distance, int estimate_flight_time, Timestamp started_at,
			Timestamp ended_at, Timestamp delay_started_at, Timestamp created_at) {
		super();
		this.id = id;
		this.flight_status = flight_status;
		this.air_company_id = air_company_id;
		this.airplane_id = airplane_id;
		this.departure_country = departure_country;
		this.destination_country = destination_country;
		this.distance = distance;
		this.estimate_flight_time = estimate_flight_time;
		this.started_at = started_at;
		this.ended_at = ended_at;
		this.delay_started_at = delay_started_at;
		this.created_at = created_at;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FlightStatus getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(FlightStatus flight_status) {
		this.flight_status = flight_status;
	}

	public int getAir_company_id() {
		return air_company_id;
	}

	public void setAir_company_id(int air_company_id) {
		this.air_company_id = air_company_id;
	}

	public int getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}

	public String getDeparture_country() {
		return departure_country;
	}

	public void setDeparture_country(String departure_country) {
		this.departure_country = departure_country;
	}

	public String getDestination_country() {
		return destination_country;
	}

	public void setDestination_country(String destination_country) {
		this.destination_country = destination_country;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getEstimate_flight_time() {
		return estimate_flight_time;
	}

	public void setEstimate_flight_time(int estimate_flight_time) {
		this.estimate_flight_time = estimate_flight_time;
	}

	public Timestamp getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Timestamp started_at) {
		this.started_at = started_at;
	}

	public Timestamp getEnded_at() {
		return ended_at;
	}

	public void setEnded_at(Timestamp ended_at) {
		this.ended_at = ended_at;
	}

	public Timestamp getDelay_started_at() {
		return delay_started_at;
	}

	public void setDelay_started_at(Timestamp delay_started_at) {
		this.delay_started_at = delay_started_at;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

}
