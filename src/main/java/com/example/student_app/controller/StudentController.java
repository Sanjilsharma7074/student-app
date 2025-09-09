package com.example.student_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student_app.entity.Student;
import com.example.student_app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Student> getAll(){
		return service.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {
		return service.getStudentById(id)
				.orElseThrow(() -> new RuntimeException("Student of ID "+id+" not found"));
	}
	
	@PostMapping
	public Student create(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student update(@PathVariable Long id, @RequestBody Student updated) {
		return service.updateStudent(updated, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteStudent(id);
	}
	
}
