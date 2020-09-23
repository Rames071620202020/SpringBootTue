package com.rab3.demo.firstpractice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.demo.firstpractice.dto.StudentDTO;
import com.rab3.demo.firstpractice.entities.StudentEntity;
import com.rab3.demo.firstpractice.repositories.StudentRepository;

@Service

public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(StudentDTO sdto) {

		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstName(sdto.getFirstName());
		studentEntity.setLastName(sdto.getLastName());
		studentEntity.setEmail(sdto.getEmail());
		studentEntity.setPhone(sdto.getPhone());
		studentEntity.setCreatedAt(new Date());
		studentEntity.setUpdatedAt(new Date());
		studentEntity.setUuid(UUID.randomUUID().toString());

		studentRepository.save(studentEntity);

	}

	public List<StudentDTO> getAllStudents() {

		Iterable<StudentEntity> studentEntity = studentRepository.findAll();

		List<StudentDTO> studentDto = new ArrayList<StudentDTO>();

		for (StudentEntity student : studentEntity) {
			StudentDTO studentDto1 = new StudentDTO();
			studentDto1.setId(student.getId());
			studentDto1.setFirstName(student.getFirstName());
			studentDto1.setLastName(student.getLastName());
			studentDto1.setEmail(student.getEmail());
			studentDto1.setPhone(student.getPhone());

			studentDto.add(studentDto1);
		}
		return studentDto;
	}

	public void updateStudents(int id, StudentDTO studentDto) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);

		if (studentEntity.isPresent()) {
			StudentEntity studentEntity2 = studentEntity.get();
			studentEntity2.setFirstName(studentDto.getFirstName());
			studentEntity2.setLastName(studentDto.getLastName());
			studentEntity2.setEmail(studentDto.getEmail());
			studentEntity2.setPhone(studentDto.getPhone());

			studentRepository.save(studentEntity2);
		}
	}

	public StudentDTO findStudentByEmail(String emailAddress) {

		Optional<StudentEntity> studentEntity = studentRepository.findByEmail(emailAddress);

		StudentDTO studentDto = null;
		if (studentEntity.isPresent()) {
			studentDto = new StudentDTO();
			studentDto.setId(studentEntity.get().getId());
			studentDto.setFirstName(studentEntity.get().getFirstName());
			studentDto.setLastName(studentEntity.get().getLastName());
			studentDto.setPhone(studentEntity.get().getPhone());
			studentDto.setEmail(studentEntity.get().getEmail());

		}
		return studentDto;

	}

	public StudentDTO findStudentById(int id) {

		Optional<StudentEntity> studentEntity = studentRepository.findById(id);

		StudentDTO studentDto = null;
		if (studentEntity.isPresent()) {
			studentDto = new StudentDTO();
			studentDto.setId(studentEntity.get().getId());
			studentDto.setFirstName(studentEntity.get().getFirstName());
			studentDto.setLastName(studentEntity.get().getLastName());
			studentDto.setPhone(studentEntity.get().getPhone());
			studentDto.setEmail(studentEntity.get().getEmail());

		}
		return studentDto;
	}

	public List<StudentDTO> findStudentByFirstName(String firstName) {
		Iterable<StudentEntity> studentEntity = studentRepository.findStudentByFirstName(firstName);
		List<StudentDTO> studentDto = new ArrayList<StudentDTO>();
		for (StudentEntity student : studentEntity) {
			StudentDTO studentDto1 = new StudentDTO();
			studentDto1.setId(student.getId());
			studentDto1.setFirstName(student.getFirstName());
			studentDto1.setLastName(student.getLastName());
			studentDto1.setEmail(student.getEmail());
			studentDto1.setPhone(student.getPhone());

			studentDto.add(studentDto1);
		}
		return studentDto;
	}
}