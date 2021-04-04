package com.rudniev.synergywaytest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudniev.synergywaytest.entities.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer>  {

}
