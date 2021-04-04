package com.rudniev.synergywaytest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudniev.synergywaytest.entities.AirCompany;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {

}
