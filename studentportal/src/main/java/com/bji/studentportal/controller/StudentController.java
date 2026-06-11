package com.bji.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bji.studentportal.entity.Student;
import com.bji.studentportal.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	  @PostMapping public ResponseEntity<Student> saveStudent(@RequestBody Student
	  student) {
	  
	  Student savedStudent = studentService.saveStudent(student);
	  
	  return ResponseEntity .status(HttpStatus.CREATED) .header("Message",
	  "Student Saved Successfully") .body(savedStudent); }
	 
	
	/*
	 * @PostMapping public ResponseEntity<Student> saveStudent(@RequestBody Student
	 * student) {
	 * 
	 * return new
	 * ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.
	 * CREATED); }
	 */
	
	
	/*
	 * @PostMapping public Student saveStudent(@RequestBody Student student) {
	 * return studentService.saveStudent(student); }
	 */
	 
	@GetMapping
	public List<Student> listStudent(){
		return studentService.listStudent();
	}
	@GetMapping("/{stid}")
	public Student getStudentById(@PathVariable("stid") Long id) {
		return studentService.getStudentById(id);
	}
	@DeleteMapping("/{stid}")
	public String deleteStudent(@PathVariable("stid") Long id) {
		studentService.deleteStudent(id);
		return "Deleted Successfully with id "+id;
	}
	@PutMapping("/{stid}")
	public Student updateStudent(@PathVariable("stid") Long id, 
		@RequestBody	Student student) {
		return studentService.updateStudent(id, student);
	}
	@GetMapping("/getStudentByEmail")
	public Student getStudentByEmail(@RequestParam("email") String email) {
		return studentService.getStudentByEmail(email);
	}
	
	@GetMapping("/getStudentByName")
	public List<Student> getStudentByName(@RequestParam("name") String name){
		return studentService.getStudentByName(name);
	}
	@GetMapping("/getStudentByNameAndAge")
	public Student getStudentByNameAndAge(@RequestParam("name") String name,@RequestParam("age") int age) {
		return studentService.getStudentByNameAndAge(name, age);
	}
}