package com.bji.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bji.studentportal.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student findByEmail(String email);
	
	public List<Student> findByName(String name);
	
	public Student findByNameAndAge(String name,int age);
	

	
}