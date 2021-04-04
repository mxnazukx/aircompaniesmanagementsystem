package com.rudniev.synergywaytest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudniev.synergywaytest.entities.Airplane;
import com.rudniev.synergywaytest.exceptions.ResourceNotFoundException;
import com.rudniev.synergywaytest.repositories.AirplaneRepository;
@Service
public class AirplaneService {
	@Autowired
	private AirplaneRepository repo;
	
	public List<Airplane> listAll(){
		return repo.findAll();
	}
	
	public void save(Airplane user) {
		repo.save(user);
	}
	
	public Airplane get(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Airplane not found with id: " + id));
	}
	
	public void delete(Integer id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Airplane not found with id: " + id));
		repo.deleteById(id);
	}
}
