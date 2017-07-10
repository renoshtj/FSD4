package com.cognizant.fsd.springboot.service;

import java.util.List;

import com.cognizant.fsd.springboot.model.Student;
import com.cognizant.fsd.springboot.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> listAll() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

	@Override
	public Student getById(String id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student saveOrUpdate(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public void delete(String id) {
		studentRepository.delete(id);

	}

}
