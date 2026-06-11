package com.bji.studentportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bji.studentportal.entity.Student;
import com.bji.studentportal.exception.StudentNotFoundException;
import com.bji.studentportal.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optContainer = studentRepository.findById(id);
		if (optContainer.isPresent()) {
			return optContainer.get();
		} else {
			throw new StudentNotFoundException("Student Not Found with id " + id);
		}

	}
	@Override
	public void deleteStudent(Long id) {
		Optional<Student> optContainer= studentRepository.findById(id);
		if(optContainer.isPresent()) {
			studentRepository.deleteById(id);
		}else {
			throw new IllegalArgumentException("Student Not Found with id "+id);
		}
		
	}
	@Override
	public Student updateStudent(Long id, Student student) {
		Optional<Student> optContainer = studentRepository.findById(id);
		if (optContainer.isPresent()) {
			Student dbStudent = optContainer.get();
			dbStudent.setName(student.getName());
			dbStudent.setAge(student.getAge());
			dbStudent.setEmail(student.getEmail());
			
			return studentRepository.save(dbStudent);
		} else {
			throw new IllegalArgumentException("Student Not Found with id " + id);}
		}
		@Override
		public Student getStudentByEmail(String email) {
			return studentRepository.findByEmail(email);
		}

		@Override
		public List<Student> getStudentByName(String name) {
			return studentRepository.findByName(name);
		}
		@Override
		public Student getStudentByNameAndAge(String name, int age) {
			// TODO Auto-generated method stub
			return studentRepository.findByNameAndAge(name, age);
		}
	}
