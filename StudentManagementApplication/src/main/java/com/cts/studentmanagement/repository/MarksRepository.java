package com.cts.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.studentmanagement.entity.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
