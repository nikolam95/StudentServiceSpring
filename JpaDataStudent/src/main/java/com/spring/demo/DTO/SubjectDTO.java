package com.spring.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.spring.demo.model.Exam;
import com.spring.demo.model.Subject;

public class SubjectDTO {

	private Long id;
	private String name;
	private int espb;
	
	List<Exam> exams = new ArrayList<Exam>();
	
	
	public SubjectDTO() {
		super();
	}

	public SubjectDTO(Long id, String name, int espb) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
	}
	
	public SubjectDTO(Subject subject) {
		this.id=subject.getId();
		this.name=subject.getName();
		this.espb=subject.getEspb();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

}
