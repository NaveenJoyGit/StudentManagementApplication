package com.cts.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.studentmanagement.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

	public Optional<Division> findByDivision(String division);
	
	
}
