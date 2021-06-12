package com.cts.studentmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.studentmanagement.controller.StudentController.SortByAverage;
import com.cts.studentmanagement.entity.Division;
import com.cts.studentmanagement.entity.Marks;
import com.cts.studentmanagement.entity.Student;
import com.cts.studentmanagement.service.StudentService;

@SpringBootTest
class ServiceTests {

	@Autowired
	StudentService studentService;
	
	@Test
	void testisMarksValid() {
		
		Boolean isMarksValid = studentService.isMarksValid(StudentBuilder());
		assertFalse(isMarksValid);
		
	}
	
	@Test
	void testComparator() {
		
		SortByAverage s = new SortByAverage();		
		Student s1 = StudentBuilder();
		Student s2 = StudentBuilder();
		s2.setName("njoy");
		s2.getMarks().setPhysicsScore(923);
		
		int compare = s.compare(s1, s2);
		assertTrue(compare > 0);
		
	}
	
	Student StudentBuilder() {
		Marks marks = new Marks();
		marks.setPhysicsScore(823);
		marks.setChemistryScore(745);
		marks.setMathScore(980);
		Division division = new Division();
		division.setId(3);
		division.setDivision("D");
		Student s = new Student();
		s.setId(1);
		s.setName("Naveen");
		s.setAge(24);
		s.setMarks(marks);
		s.setDivision(division);
		
		return s;
	}

}
