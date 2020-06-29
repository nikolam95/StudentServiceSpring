package com.spring.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "jpadatastudent", name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameStudent;
	private String surnameStudent;
	private String cardNumber;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	Set<Exam> exams = new HashSet<Exam>();
	
	public Student() {
		super();
	}

	public Student(Long id, String nameStudent, String surnameStudent, String cardNumber) {
		super();
		this.id = id;
		this.nameStudent = nameStudent;
		this.surnameStudent = surnameStudent;
		this.cardNumber = cardNumber;
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

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	
	

	
}
