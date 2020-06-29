package com.spring.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.spring.demo.model.Exam;
import com.spring.demo.model.Student;

public class StudentDTO {
	
	private Long id;
	private String nameStudent;
	private String surnameStudent;
	private String cardNumber;
	
	List<ExamDTO> exams = new ArrayList<ExamDTO>();
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String nameStudent, String surnameStudent, String cardNumber) {
		super();
		this.id = id;
		this.nameStudent = nameStudent;
		this.surnameStudent = surnameStudent;
		this.cardNumber = cardNumber;
	}
	
	public StudentDTO(Student student) {
		this.id=student.getId();
		this.nameStudent=student.getNameStudent();
		this.surnameStudent=student.getSurnameStudent();
		this.cardNumber=student.getCardNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getSurnameStudent() {
		return surnameStudent;
	}

	public void setSurnameStudent(String surnameStudent) {
		this.surnameStudent = surnameStudent;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDTO> exams) {
		this.exams = exams;
	}
	
	
	

}
