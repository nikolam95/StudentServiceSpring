package com.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.DTO.ExamDTO;
import com.spring.demo.DTO.StudentDTO;
import com.spring.demo.model.Exam;
import com.spring.demo.model.Student;
import com.spring.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "api/students", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> findAll(Pageable page){
		Page<Student> students = studentService.findAll(page);
		
		List<StudentDTO> retVal = new ArrayList<StudentDTO>();
		for(Student s: students) {
			retVal.add(new StudentDTO(s));
		} 
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "api/students", method = RequestMethod.GET, params = "withExams")
	public ResponseEntity<List<StudentDTO>> findAll(@RequestParam Boolean withExams, Pageable page ){
		Page<Student> students = studentService.findAll(page);
		
		List<StudentDTO> retVal = new ArrayList<StudentDTO>();
		for(Student s: students) {
			StudentDTO studentDTO = new StudentDTO(s);
			if(withExams) {
				for(Exam e: s.getExams()) {
					studentDTO.getExams().add(new ExamDTO(e));
				}
			}
			
			retVal.add(studentDTO);
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> findOne(@PathVariable Long id){
		Student student = studentService.findOne(id);
		StudentDTO studentDTO = new StudentDTO(student);
		
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/students", method = RequestMethod.POST)
	public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO){
		Student student = new Student();
		student.setCardNumber(studentDTO.getCardNumber());
		student.setNameStudent(studentDTO.getNameStudent());
		student.setSurnameStudent(studentDTO.getSurnameStudent());
		
		student = studentService.save(student);
		StudentDTO sDTO = new StudentDTO(student);
		
		return new ResponseEntity<>(sDTO, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "api/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO){
		Student student = studentService.findOne(id);
		
		if(student.getId() != null) {
			student.setId(id);
			student.setCardNumber(studentDTO.getCardNumber());
			student.setNameStudent(studentDTO.getNameStudent());
			student.setSurnameStudent(studentDTO.getSurnameStudent());
			
			student = studentService.save(student);
			StudentDTO sDTO = new StudentDTO(student);
			
			return new ResponseEntity<>(sDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if(studentService.findOne(id) != null) {
			studentService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
