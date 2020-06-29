package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.demo.model.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findStudentByCardNumber(String cardNumber);

}
