package com.cognizant.fsd.springboot.service;

import java.util.List;

import com.cognizant.fsd.springboot.model.Student;


public interface StudentService {

	List<Student> listAll();

	Student getById(String id);

	Student saveOrUpdate(Student student);

    void delete(String id);

}
