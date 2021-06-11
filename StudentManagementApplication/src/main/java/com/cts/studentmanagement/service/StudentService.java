package com.cts.studentmanagement.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.studentmanagement.entity.Student;
import com.cts.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRep;
	
	public List<Student> getAllStudents() {
		return studentRep.findAll();
	}
	
	@Transactional
	public void saveStudent(Student student) {
		studentRep.save(student);
	}
	
	public Boolean isStudentAlreadyAdded(String name) {
		Optional<Student> findByName = studentRep.findByName(name);
		return findByName.isPresent();
	}
	
	public List<String> findAllStudents() {
		return studentRep.findStudents();
	}
	
	
	public Boolean isMarksValid(Student student) {
		if(student.getMarks().getPhysicsScore() > 100 
				|| student.getMarks().getChemistryScore() > 100 
				|| student.getMarks().getMathScore() > 100) return false;
						
		return true;
	}
	
	
}
