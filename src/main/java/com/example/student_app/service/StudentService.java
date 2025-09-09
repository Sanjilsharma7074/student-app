package com.example.student_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_app.entity.Student;
import com.example.student_app.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	public StudentService() {
		super();
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public Optional<Student> getStudentById (Long id){
		return repository.findById(id);
	}
	
	public Student addStudent(Student student) {
		return repository.save(student);
	}
	
	public Student updateStudent(Student updated,Long id) {
		return repository.findById(id)
				.map(s -> {
					s.setName(updated.getName());
					s.setEmail(updated.getEmail());
					return repository.save(s);
				})
				.orElseThrow(() -> new RuntimeException("Student not found"));
	}
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
}
