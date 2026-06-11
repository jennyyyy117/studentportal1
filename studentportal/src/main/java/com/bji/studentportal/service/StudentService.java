package com.bji.studentportal.service;

import java.util.List;

import com.bji.studentportal.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public List<Student> listStudent();
	public Student getStudentById(Long id);
	public void deleteStudent(Long id);
	public Student updateStudent(Long id,Student student);
	
	public Student getStudentByEmail(String email);
	public List<Student> getStudentByName(String name);
	
	public Student getStudentByNameAndAge(String name, int age);
}


