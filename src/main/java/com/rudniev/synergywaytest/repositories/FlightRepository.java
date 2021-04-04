package com.rudniev.synergywaytest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudniev.synergywaytest.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>  {

}
