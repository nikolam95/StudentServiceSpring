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

import com.spring.demo.DTO.ExamDTO;
import com.spring.demo.model.Exam;
import com.spring.demo.model.Student;
import com.spring.demo.model.Subject;
import com.spring.demo.service.ExamService;

@RestController
public class ExamController {

	@Autowired
	ExamService examService;
	
	@RequestMapping(value = "api/exams", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> findAll(Pageable page){
		
		Page<Exam> exams = examService.findAll(page);
		List<ExamDTO> retVal = new ArrayList<>();
		
		for(Exam e: exams) {
			ExamDTO eDTO = new ExamDTO(e);
			retVal.add(eDTO);
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/exams/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamDTO> findOne(@PathVariable Long id){
		Exam exam = examService.findOne(id);
		ExamDTO eDTO = new ExamDTO(exam);
		
		return new ResponseEntity<>(eDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/exams", method = RequestMethod.POST)
	public ResponseEntity<ExamDTO> create(@RequestBody ExamDTO examDTO){
		
		Exam exam = new Exam();
		exam.setId(exam.getId());
		exam.setStudent(new Student(examDTO.getStudent().getId(), null, null, null));
		exam.setSubject(new Subject(examDTO.getSubject().getId(), null, 0));
		exam.setMark(examDTO.getMark());
		
		exam = examService.save(exam);
		ExamDTO eDTO = new ExamDTO(exam);
		
		return new ResponseEntity<>(eDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "api/exams/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if(examService.findOne(id) != null) {
			examService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(value = "api/exams/students/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExamByStudent(@PathVariable Long studentId){
		
		List<Exam> exams = examService.findByStudentId(studentId);
		
		List<ExamDTO> retVal = new ArrayList<>();
		for(Exam e: exams) {
			ExamDTO eDTO = new ExamDTO(e);
			retVal.add(eDTO);
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "api/exams/students/{id}/avg", method = RequestMethod.GET)
	public ResponseEntity<Double> avgMarks(@PathVariable Long id){
		double prosek = examService.avgMarks(id);
		
		return new ResponseEntity<>(prosek, HttpStatus.OK);
	}
}
