package com.cognizant.fsd.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.fsd.springboot.model.Student;
import com.cognizant.fsd.springboot.service.StudentService;

@RestController
public class StudentController {

	
	private StudentService studentService;
	
	@Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


	@RequestMapping("/all")
	public List<Student> getAll() {
		return studentService.listAll();
	}

	@RequestMapping("{id}")
	public Student getStudent(@PathVariable("id") String id) {
		return studentService.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/Update")
	public void updateStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public void removeStudent(@PathVariable("id") String id) {
		studentService.delete(id);
	}
}
