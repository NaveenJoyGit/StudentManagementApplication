package com.cts.studentmanagement.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Optional<Student> findByName(String name);
	
	@Query(value = "SELECT s.name FROM student s", nativeQuery = true)
	public List<String> findStudents();
	
}
