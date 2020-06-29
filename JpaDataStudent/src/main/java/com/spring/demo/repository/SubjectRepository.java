package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
