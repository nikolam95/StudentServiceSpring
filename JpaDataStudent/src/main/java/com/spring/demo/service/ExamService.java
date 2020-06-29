package com.spring.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.spring.demo.model.Exam;
import com.spring.demo.repository.ExamRepository;

@Component
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	public List<Exam> findAll(){
		return examRepository.findAll();
	}
	
	public Page<Exam> findAll(Pageable page){
		return examRepository.findAll(page);
	}
	
	public Exam findOne(Long id) {
		return examRepository.getOne(id);
	}
	
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}
	
	public void delete(Long id) {
		examRepository.deleteById(id);
	}
	
	public List<Exam> findByStudentId(Long id){
		return examRepository.findByStudentId(id);
	}
	
	public double avgMarks(Long id) {
		return examRepository.avgMarks(id);
	}
}
