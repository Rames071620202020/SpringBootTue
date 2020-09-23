package com.rab3.demo.firstpractice.repositories;

import java.util.Optional;

import javax.management.remote.SubjectDelegationPermission;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rab3.demo.firstpractice.entities.StudentEntity;

@Repository

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

	Optional<StudentEntity> findByEmail(String emailAddress);

	Iterable<StudentEntity> findStudentByFirstName(String firstName);

}
