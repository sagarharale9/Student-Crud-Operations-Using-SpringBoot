package com.spring.myapp.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.myapp.dto.StudentDto;
import com.spring.myapp.service.StudentService;

//@Service
public class StudentServiceImpl implements StudentService {

	private static List<StudentDto> studentList = new ArrayList<StudentDto>();
	private static int sId = 0;

	//	@Override
	//	public List<StudentDto> getAllStudent() {
	//		return studentList;
	//	}

	@Override
	public JsonNode getAllStudent() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        Map<String, List<StudentDto>> resultMap = new HashMap<>();
	        resultMap.put("Students", studentList);
	        json = objectMapper.writeValueAsString(resultMap);
	         JsonNode jsonNode = objectMapper.readTree(json);
	         return jsonNode;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public StudentDto getStudentById(int id) {
		for (StudentDto getStudent : studentList) {
			if (getStudent.getId() == id) {
				return getStudent;
			}
		}
		return null;
	}

	@Override
	public StudentDto addStudent(StudentDto student) {
		student.setId(sId += 1);
		studentList.add(student);
		return student;
	}

	@Override
	public StudentDto deleteById(int id) {
		for (Iterator<StudentDto> iterator = studentList.iterator(); iterator.hasNext();) {
			StudentDto studentDto = iterator.next();
			if (studentDto.getId() == (id)) {
				iterator.remove();
				return studentDto;
			}
		}
		return null;
	}

	public StudentDto updateById(StudentDto updtStudent) {

		int id = updtStudent.getId();
		StudentDto updatedStudent = getStudentById(id);
		if (updatedStudent != null) {

			if (updtStudent.getName() != null) {
				updatedStudent.setName(updtStudent.getName());
			}
			if (updtStudent.getGender() != null) {
				updatedStudent.setGender(updtStudent.getGender());
			}
			if (updtStudent.getCourse() != null) {
				updatedStudent.setCourse(updtStudent.getCourse());
			}
			if (updtStudent.getHobbies() != null) {
				updatedStudent.setHobbies(updtStudent.getHobbies());
			}

			return updatedStudent;

		}

		return null;
	}
}
