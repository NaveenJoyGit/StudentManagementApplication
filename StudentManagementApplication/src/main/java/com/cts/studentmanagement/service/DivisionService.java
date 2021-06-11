package com.cts.studentmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.studentmanagement.entity.Division;
import com.cts.studentmanagement.repository.DivisionRepository;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepository divRep;
	
	public List<Division> getAllDivisions() {
		return divRep.findAll();
	}
	
	@Transactional
	public Division findByDivision(String division) {
		return divRep.findByDivision(division).get();
	}
}
