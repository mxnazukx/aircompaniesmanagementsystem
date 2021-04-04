package com.rudniev.synergywaytest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudniev.synergywaytest.entities.Flight;
import com.rudniev.synergywaytest.exceptions.ResourceNotFoundException;
import com.rudniev.synergywaytest.repositories.FlightRepository;
@Service
public class FlightService {
	@Autowired
	private FlightRepository repo;
	
	public List<Flight> listAll(){
		return repo.findAll();
	}
	
	public void save(Flight user) {
		repo.save(user);
	}
	
	public Flight get(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id :" + id));
	}
	
	public void delete(Integer id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id :" + id));
		repo.deleteById(id);
	}
}
