package com.cts.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.studentmanagement.entity.Marks;
import com.cts.studentmanagement.repository.MarksRepository;

@Service
public class MarksService {

	@Autowired
	private MarksRepository markRep;
	
	public List<Marks> getAllMarks() {
		return markRep.findAll();
	}
	
}
