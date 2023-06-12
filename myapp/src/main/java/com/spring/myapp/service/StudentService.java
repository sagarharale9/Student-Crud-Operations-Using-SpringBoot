package com.spring.myapp.service;


import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.spring.myapp.dto.StudentDto;

@Service
public interface StudentService {

	//methods for NGROK Api's
//	void addStudent(StudentDto student);
//	JsonNode getAllStudent();
//	StudentDto deleteById(int id);
//	void updateById(StudentDto studentDto);
//	StudentDto getStudentById(int id);
	
	//Methods of Local Api's
	JsonNode getAllStudent();
	StudentDto getStudentById(int id);
	StudentDto addStudent(StudentDto student);
	StudentDto deleteById(int id);
	StudentDto updateById(StudentDto updtStudent);

}
