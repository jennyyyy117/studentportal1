package com.bji.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bji.studentportal.entity.student;

public interface studentrepository extends JpaRepository<student,Long>{

	public student findByEmail(String email);
	
	public List<student> findByName(String name);
	
	public student findByNameAndAge(String name,int age);
	

	
}