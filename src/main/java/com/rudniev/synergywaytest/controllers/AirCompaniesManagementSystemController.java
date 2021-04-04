package com.rudniev.synergywaytest.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rudniev.synergywaytest.entities.AirCompany;
import com.rudniev.synergywaytest.entities.Airplane;
import com.rudniev.synergywaytest.entities.Flight;
import com.rudniev.synergywaytest.entities.FlightStatus;
import com.rudniev.synergywaytest.exceptions.ResourceNotFoundException;
import com.rudniev.synergywaytest.services.AirCompanyService;
import com.rudniev.synergywaytest.services.AirplaneService;
import com.rudniev.synergywaytest.services.FlightService;

@RestController
public class AirCompaniesManagementSystemController {
	@Autowired
	AirCompanyService acs;

	@Autowired
	FlightService fs;

	@Autowired
	AirplaneService as;

	@GetMapping("/aircompanies")
	public List<AirCompany> listCompanies() {
		return acs.listAll();
	}

	@GetMapping("/aircompanies/{id}")
	public AirCompany getCompanyById(@PathVariable Integer id) {
		return acs.get(id);
	}

	@PostMapping("/aircompanies/new")
	public void addCompany(@RequestBody AirCompany airCompany) {
		acs.save(airCompany);
	}

	@PutMapping("/aircompanies/{id}/update")
	public void updateCompany(@RequestBody AirCompany airCompany, @PathVariable Integer id) {
		AirCompany ac = acs.get(id);
		ac.setCompany_type(airCompany.getCompany_type());
		ac.setFounded_at(airCompany.getFounded_at());
		ac.setName(airCompany.getName());
		acs.save(ac);
	}

	@DeleteMapping("/aircompanies/{id}/delete")
	public void deleteAirCompany(@PathVariable Integer id) {
		acs.delete(id);

	}

	@PostMapping("/airplane/new")
	public void addAirplane(@RequestBody Airplane airplane) {
		if (airplane.getAir_company_id() != 0) {
			acs.get(airplane.getAir_company_id());
		}
		airplane.setCreated_at(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		as.save(airplane);
	}

	@PutMapping("/airplane/{id}/update")
	public void updateAirplaneCompany(@RequestBody Airplane ap, @PathVariable Integer id) {
		Airplane airplane = as.get(id);
		acs.get(ap.getAir_company_id());
		airplane.setAir_company_id(ap.getAir_company_id());
		as.save(airplane);

	}

	@PostMapping("/flight/new")
	public void addFlight(@RequestBody Flight flight) throws Exception {
		acs.get(flight.getAir_company_id());
		as.get(flight.getAirplane_id());
		int size = fs.listAll().stream().filter(f -> f.getAirplane_id() == flight.getAirplane_id() && (f.getFlight_status().ordinal() == 0 || f.getFlight_status().ordinal() == 2)).collect(Collectors.toList()).size();
		System.out.print(size);
		if (as.get(flight.getAirplane_id()).getAir_company_id() != flight.getAir_company_id()) {
			throw new ResourceNotFoundException("There is no airplane id:" + flight.getAirplane_id() + " in air company id:" + flight.getAir_company_id());
		} else if(size > 0) {
			throw new ResourceNotFoundException("Airplane id:"+flight.getAirplane_id() + " is already in flight");
		} else {
			flight.setFlight_status(FlightStatus.PENDING);
			flight.setCreated_at(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			fs.save(flight);
		}

	}

	@PutMapping("/flight/{id}/status")
	public void changeStatus(@PathVariable Integer id, @RequestBody Flight flight) {
		Flight f = fs.get(id);
		f.setFlight_status(flight.getFlight_status());
		if (flight.getFlight_status().ordinal() == 2)
			f.setDelay_started_at(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		else if (flight.getFlight_status().ordinal() == 1)
			f.setEnded_at(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		else if (flight.getFlight_status().ordinal() == 0)
			f.setStarted_at(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		fs.save(f);
	}

	@GetMapping("/aircompanies/flights/{status}")
	public List<Flight> companyFlightsByStatus(@RequestBody AirCompany ac, @PathVariable String status) {
		AirCompany company = acs.listAll().stream().filter(c -> c.getName().equals(ac.getName()))
				.collect(Collectors.toList()).get(0);
		if (status.equals("active")) {
			return fs.listAll().stream()
					.filter(f -> f.getAir_company_id() == company.getId() && f.getFlight_status().ordinal() == 0)
					.collect(Collectors.toList());
		} else if (status.equals("completed")) {
			return fs.listAll().stream()
					.filter(f -> f.getAir_company_id() == company.getId() && f.getFlight_status().ordinal() == 1)
					.collect(Collectors.toList());
		} else if (status.equals("delayed")) {
			return fs.listAll().stream()
					.filter(f -> f.getAir_company_id() == company.getId() && f.getFlight_status().ordinal() == 2)
					.collect(Collectors.toList());
		} else if (status.equals("pending")) {
			return fs.listAll().stream()
					.filter(f -> f.getAir_company_id() == company.getId() && f.getFlight_status().ordinal() == 3)
					.collect(Collectors.toList());
		}
		return new ArrayList<Flight>();
	}

	@GetMapping("/flights/activemorethan24h")
	public List<Flight> activeFlights() {
		Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
		return fs.listAll().stream().filter(
				f -> f.getFlight_status().ordinal() == 0 && ts.getTime() - f.getStarted_at().getTime() > 86400000)
				.collect(Collectors.toList());
	}

	@GetMapping("/flights/biggerthanestimated")
	public List<Flight> completedFlights() {
		return fs.listAll().stream().filter(f -> f.getFlight_status().ordinal() == 1
				&& f.getEnded_at().getTime() - f.getStarted_at().getTime() > f.getEstimate_flight_time() * 60000)
				.collect(Collectors.toList());
	}
}
