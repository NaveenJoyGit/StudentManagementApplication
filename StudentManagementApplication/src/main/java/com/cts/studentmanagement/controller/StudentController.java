package com.cts.studentmanagement.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.studentmanagement.entity.Division;
import com.cts.studentmanagement.entity.Marks;
import com.cts.studentmanagement.entity.Student;
import com.cts.studentmanagement.exception.DataEntryError;
import com.cts.studentmanagement.service.DivisionService;
import com.cts.studentmanagement.service.StudentService;

@Controller
public class StudentController {
	
	Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DivisionService divService;

	@PostMapping("/showStudents")
	public String getStudents(@ModelAttribute("student") Student student, Model model) {
		log.info("---------Inside showStudent controller----------");
		log.info(student.getName());
		log.info(student.getMarks().getPhysicsScore().toString());
		log.info(student.getDivision().getDivision());
		log.info("---printing division from database----");
		log.info(divService.findByDivision(student.getDivision().getDivision()).getDivision());
		
		Division div = divService.findByDivision(student.getDivision().getDivision());
		student.setDivision(div);
		
		if(!studentService.isMarksValid(student)) 
			throw new DataEntryError("Score is greater than 100");
		
		if(!studentService.isStudentAlreadyAdded(student.getName()))
			studentService.saveStudent(student);
		else
			throw new DataEntryError("Record already entered");
		
		List<Student> studentList = studentService.getAllStudents();
		model.addAttribute("students", studentList);
		return "studentlist";
	}
	
	@GetMapping("/studentForm")
	public String showStudentForm(Model model) {
		log.info("--------Inside studentform controller---------");
		
		
		
		
		Student student = new Student();
		Marks marks = new Marks();
		model.addAttribute("student", student);
		model.addAttribute("marks", marks);
		return "studentdetails";
	}
	
	@GetMapping("/divisions")
	public String showDivisions(Model model) {
		log.info("Inside division controller");
		List<Division> divList = divService.getAllDivisions();
		Division division = new Division();
		Student student = new Student();
		model.addAttribute("divs", division);
		model.addAttribute("student", student);
		return "division";
	}
	
	@GetMapping("/showRankList")
	public String rankList(@ModelAttribute("division") Student s, Model model) {
		log.info("Inside rankList controller");
		Division div = divService.findByDivision(s.getDivision().getDivision());
		List<Student> studentList = div.getStudents();
		Collections.sort(studentList, new SortByAverage());
		model.addAttribute("division", div);
		model.addAttribute("sList", studentList);
		return "ranklist";
	}
	
	public static class SortByAverage implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return (int) (o2.getMarks().averageMarks() - o1.getMarks().averageMarks());
		}
		
	}
	
	@ExceptionHandler
	public String handleScoreException(DataEntryError s, Model model) {
		String errorMessage = s.getMessage();
		model.addAttribute("errormessage", errorMessage);
		return "error";
	}
	
}
