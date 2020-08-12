package com.springtransaction.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtransaction.entity.Student;
import com.springtransaction.repository.StudentRepository;
import com.springtransaction.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public List<Student> saveAllStudent(List<Student> studentList) {
		List<Student> response = (List<Student>) studentRepository.saveAll(studentList);
		return response;
	}

	/*
	 http://localhost:9191/student/getall

Since we have defined 1 millisecond as transaction timeout(@Transactinal timeout = 1) in StudentServiceImpl.java mostly we will get transaction timeout expired error.

Increase the timeout value something 10ms, 20ms or 100 ms(or any bigger number depends on system configuration). 
I increase one ms to ten ms and we should not have any error.
	 * */
	
	@Transactional(timeout = 1)
	public List<Student> getAllStudents() {
		List<Student> studentResponse = (List<Student>) studentRepository.findAll();
		return studentResponse;
	}

}