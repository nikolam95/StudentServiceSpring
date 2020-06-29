package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.spring.demo.model.Student;
import com.spring.demo.repository.ExamRepository;
import com.spring.demo.repository.StudentRepository;

@Component
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Page<Student> findAll(Pageable page){
		return studentRepository.findAll(page);
	}
	
	public Student findOne(Long id) {
		return studentRepository.getOne(id);
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public void delete(Long id) {
		if(examRepository.findByStudentId(id).isEmpty()) {
			studentRepository.deleteById(id);
		}

	}

}
