package com.spring.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.spring.demo.model.Subject;
import com.spring.demo.repository.SubjectRepository;

@Component
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Subject> findAll(){
		return subjectRepository.findAll();
	}
	
	public Page<Subject> findAll(Pageable page){
		return subjectRepository.findAll(page);
	}
	
	public Subject findOne(Long id) {
		return subjectRepository.getOne(id);
	}
	
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public void delete(Long id) {
		subjectRepository.deleteById(id);
	} 
}
