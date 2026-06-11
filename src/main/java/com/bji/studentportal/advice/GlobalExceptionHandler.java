package com.bji.studentportal.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bji.studentportal.exception.StudentNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleStudentNotFoundException
	                             (StudentNotFoundException e){
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("message", e.getMessage());
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	}
}