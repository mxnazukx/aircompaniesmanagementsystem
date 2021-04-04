package com.rudniev.synergywaytest.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "airplanes")
public class Airplane {
	@Id
	private int id;
	private String name;
	private int factory_serial_number;
	private int air_company_id;
	private int number_of_flights;
	private int flight_distance;
	private int fuel_capacity;
	private String type;
	private Timestamp created_at;
	
	
	public Airplane() {
	}
	public Airplane(int id, String name, int factory_serial_number, int air_company_id, int number_of_flights,
			int flight_distance, int fuel_capacity, String type, Timestamp created_at) {
		super();
		this.id = id;
		this.name = name;
		this.factory_serial_number = factory_serial_number;
		this.air_company_id = air_company_id;
		this.number_of_flights = number_of_flights;
		this.flight_distance = flight_distance;
		this.fuel_capacity = fuel_capacity;
		this.type = type;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFactory_serial_number() {
		return factory_serial_number;
	}
	public void setFactory_serial_number(int factory_serial_number) {
		this.factory_serial_number = factory_serial_number;
	}
	public int getAir_company_id() {
		return air_company_id;
	}
	public void setAir_company_id(int air_company_id) {
		this.air_company_id = air_company_id;
	}
	public int getNumber_of_flights() {
		return number_of_flights;
	}
	public void setNumber_of_flights(int number_of_flights) {
		this.number_of_flights = number_of_flights;
	}
	public int getFlight_distance() {
		return flight_distance;
	}
	public void setFlight_distance(int flight_distance) {
		this.flight_distance = flight_distance;
	}
	public int getFuel_capacity() {
		return fuel_capacity;
	}
	public void setFuel_capacity(int fuel_capacity) {
		this.fuel_capacity = fuel_capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
	

}
