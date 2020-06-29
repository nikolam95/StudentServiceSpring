package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.demo.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{

	List<Exam> findByStudentId(Long studentId);
	
	@Query("SELECT avg(e.mark) FROM Exam e WHERE e.student.id = :id")
	double avgMarks(@Param("id") Long id);
	
}
