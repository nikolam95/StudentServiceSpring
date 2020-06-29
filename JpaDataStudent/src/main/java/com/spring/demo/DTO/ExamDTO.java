package com.spring.demo.DTO;

import com.spring.demo.model.Exam;
import com.spring.demo.model.Student;
import com.spring.demo.model.Subject;

public class ExamDTO {
	
	private Long id;
	private StudentDTO student;
	private SubjectDTO subject;
	private int mark;
	
	public ExamDTO() {
		super();
	}

	public ExamDTO(Long id, StudentDTO student, SubjectDTO subject, int mark) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.mark = mark;
	}
	
	public ExamDTO(Exam exam) {
		this.id=exam.getId();
		this.student= new StudentDTO(exam.getStudent());
		this.subject=new SubjectDTO(exam.getSubject());
		this.mark=exam.getMark();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	

}
