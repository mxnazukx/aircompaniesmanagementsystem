package com.rudniev.synergywaytest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudniev.synergywaytest.entities.AirCompany;
import com.rudniev.synergywaytest.exceptions.ResourceNotFoundException;
import com.rudniev.synergywaytest.repositories.AirCompanyRepository;
@Service
public class AirCompanyService {
	@Autowired
	private AirCompanyRepository repo;
	
	public List<AirCompany> listAll(){
		return repo.findAll();
	}
	
	public void save(AirCompany user) {
		repo.save(user);
	}
	
	public AirCompany get(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Air company not found with id: " + id));
	}
	
	public void delete(Integer id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Air company not found with id: " + id));
		repo.deleteById(id);
	}
}
