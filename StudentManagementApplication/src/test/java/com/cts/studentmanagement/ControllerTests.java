package com.cts.studentmanagement;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.studentmanagement.controller.StudentController.SortByAverage;
import com.cts.studentmanagement.entity.Division;
import com.cts.studentmanagement.entity.Marks;
import com.cts.studentmanagement.entity.Student;
import com.cts.studentmanagement.exception.DataEntryError;
import com.cts.studentmanagement.service.DivisionService;
import com.cts.studentmanagement.service.StudentService;

@SpringBootTest
class ControllerTests {

	@MockBean
	StudentService studentService;
	
	@MockBean
	DivisionService divService;
	
	@Test
	void testDataEntryException() {
		Division division = new Division();
		division.setId(3);
		division.setDivision("D");
		Student s1 = StudentBuilder("Naveen", 233, 34, 56);
		when(divService.findByDivision("D")).thenReturn(division);
		s1.setDivision(division);
		when(studentService.isMarksValid(s1)).thenReturn(false);
		assertThrows(DataEntryError.class, () -> {
			if(!studentService.isMarksValid(s1)) 
				throw new DataEntryError("Score is greater than 100");
		});
		
	}
	
	@Test
	void testShowStudentsController() {
		Division division = new Division();
		division.setId(3);
		division.setDivision("D");
		Student s1 = StudentBuilder("Naveen", 83, 34, 56);
		Student s2 = StudentBuilder("Ajin", 67, 45, 34);
		when(divService.findByDivision("D")).thenReturn(division);
		s1.setDivision(division);
		when(studentService.isMarksValid(s1)).thenReturn(true);
		when(studentService.isStudentAlreadyAdded(s1.getName())).thenReturn(false);
		assertDoesNotThrow(() -> {
			if(!studentService.isStudentAlreadyAdded(s1.getName()))
				studentService.saveStudent(s1);
		});
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		when(studentService.getAllStudents()).thenReturn(list);
		List<Student> studentList = studentService.getAllStudents();
		
		assertEquals("Naveen", studentList.get(0).getName());
		
		
	}
	
	@Test
	void testRankListController() {
		Student s1 = StudentBuilder("Naveen", 83, 34, 56);
		Student s2 = StudentBuilder("Ajin", 97, 95, 94);
		Division division = new Division();
		division.setId(3);
		division.setDivision("D");
		s1.setDivision(division);
		s2.setDivision(division);
		when(divService.findByDivision(s1.getDivision().getDivision())).thenReturn(division);
		Division div = divService.findByDivision(s1.getDivision().getDivision());
		div.getStudents().add(s1);
		div.getStudents().add(s2);		
		List<Student> sList = div.getStudents();
		assertEquals("Naveen", sList.get(0).getName());
		Collections.sort(sList, new SortByAverage());
		assertEquals("Ajin", sList.get(0).getName());
		
		
	}

	Student StudentBuilder(String name, int p, int c, int m) {
		Marks marks = new Marks();
		marks.setPhysicsScore(p);
		marks.setChemistryScore(c);
		marks.setMathScore(m);
		Division division = new Division();
		division.setId(3);
		division.setDivision("D");
		Student s = new Student();
		s.setId(1);
		s.setName(name);
		s.setAge(24);
		s.setMarks(marks);
//		s.setDivision(division);
		
		return s;
	}
	
}
