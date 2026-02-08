package com.spring.myapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.myapp.dto.ApiResponse;
import com.spring.myapp.dto.ErrorApiResponce;
import com.spring.myapp.dto.StudentDto;
import com.spring.myapp.service.StudentService;

@RestController
@RequestMapping("/student")
public class MyController {
	@Autowired
	StudentService studentserviceimpl;

	// Get name By using PathVariable
//	@GetMapping("/name/{name}")
//	public String home(@PathVariable String name) {
//		return "Hello " + name;
//	}

	// Add Student
	@CrossOrigin
	@PostMapping("/post")
	public ResponseEntity<Object> postStudent(@RequestBody StudentDto student) {
		 
		try {
			studentserviceimpl.addStudent(student);
			String message = "Student Record Added Successfully";
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(HttpStatus.CREATED.value(), message, student));
		} catch(Exception e) {
			String message = "Failed to add student";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(), message));
		}
	}

	// Get Student Details By Id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable int id) {
		if(id < 1){
			throw new IllegalArgumentException("Invalid Student Id: "+id);
		}else{
		StudentDto getStudent = studentserviceimpl.getStudentById(id);
		if (getStudent != null) {
			String message = "Getting Student Record Of Id: " + id;
			return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), message, getStudent));
		} else {
			String message = "No Student Record found with the Id: " + id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(), message));
		}
		}
	}

	// Get All Students Details
	@GetMapping("/get")
	public JsonNode getStudent() {
		return  studentserviceimpl.getAllStudent();
	     
	}

	// Delete Student Records By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		StudentDto Student = studentserviceimpl.deleteById(id);
		if (Student != null) {
			String message = "Student Record Of Id: " + id + " Has Been Deleted Successfully";
			return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), message, Student));
		} else {
			String message = "No Student Record found with the Id: " + id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(), message));
		}
	}

	// Update Student Records By Id
	@CrossOrigin
	@PutMapping("put")
	public ResponseEntity<Object> updateById(@RequestBody StudentDto studentDto) {
		StudentDto updatedStudent = studentserviceimpl.updateById(studentDto);
		if (updatedStudent != null) {
			if (studentDto.getName() == null && studentDto.getCourse() == null && studentDto.getGender() == null
					&& studentDto.getHobbies() == null) {
				String message = "No Student Record found For Update With this Id: " + updatedStudent.getId();
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(), message));
			} else {
				String message = "Student Record Of Id: " + updatedStudent.getId() + "   Has Been Updated Successfully";
				return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), message, updatedStudent));
			}
		} else {
			String message = "No Student Record found For Update ";
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(), message));
		}
	}

}
