package com.cognizant.fsd.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.cognizant.fsd.springboot.model.Student;

@Component
public interface StudentRepository extends MongoRepository<Student, String>{

}
