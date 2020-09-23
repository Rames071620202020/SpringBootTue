package com.rab3.demo.firstpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.demo.firstpractice.dto.StudentDTO;
import com.rab3.demo.firstpractice.services.StudentService;

@RestController

@RequestMapping("/student")

public class StudentController {

	@Autowired

	private StudentService studentService;

	@PostMapping(value = "")

	public void addStudent(@RequestBody StudentDTO sdto) {
		studentService.saveStudent(sdto);

	}

	@GetMapping(value = "")
	public List<StudentDTO> getStudents() {

		return studentService.getAllStudents();

	}

	@PutMapping(value = "update/{id}")
	public void updateStudentInfo(@PathVariable("id") int id, @RequestBody StudentDTO studentDto) {
		studentService.updateStudents(id, studentDto);
	}

	@GetMapping("/email/{email}")
	public StudentDTO getStudentByEmail(@PathVariable("email") String emailAddress) {
		return studentService.findStudentByEmail(emailAddress);

	}

	@GetMapping("/id/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int id) {
		return studentService.findStudentById(id);

	}

	@GetMapping("/firstName/{firstName}")
	public List<StudentDTO> getStudentByFirstName(@PathVariable("firstName") String firstName) {
		return studentService.findStudentByFirstName(firstName);

	}
}