package com.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.DTO.SubjectDTO;
import com.spring.demo.model.Subject;
import com.spring.demo.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "api/subjects", method = RequestMethod.GET)
	public ResponseEntity<List<SubjectDTO>> findAll(Pageable page){
		Page<Subject> subjects = subjectService.findAll(page);
		
		List<SubjectDTO> retVal = new ArrayList<SubjectDTO>();
		for(Subject s: subjects) {
			SubjectDTO sDTO = new SubjectDTO(s);
			retVal.add(sDTO);
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/subjects/{id}", method = RequestMethod.GET)
	public ResponseEntity<SubjectDTO> findOne(@PathVariable Long id){
		Subject subject = subjectService.findOne(id);
		SubjectDTO sDTO = new SubjectDTO(subject);
		
		return new ResponseEntity<>(sDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/subjects", method = RequestMethod.POST)
	public ResponseEntity<SubjectDTO> create(@RequestBody SubjectDTO subjectDTO){
		Subject subject = new Subject();
		
		subject.setId(subjectDTO.getId());
		subject.setName(subjectDTO.getName());
		subject.setEspb(subjectDTO.getEspb());
		
		subject = subjectService.save(subject);
		SubjectDTO sDTO = new SubjectDTO(subject);
		
		return new ResponseEntity<>(sDTO, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "api/subjects/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SubjectDTO> update(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO){
		Subject subject = subjectService.findOne(id);
		
		if(subject.getId() != null) {
			
			subject.setId(id);
			subject.setName(subjectDTO.getName());
			subject.setEspb(subjectDTO.getEspb());
			
			subject = subjectService.save(subject);
			SubjectDTO sDTO = new SubjectDTO(subject);
			
			return new ResponseEntity<>(sDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/subjects/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if(subjectService.findOne(id) != null) {
			subjectService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
