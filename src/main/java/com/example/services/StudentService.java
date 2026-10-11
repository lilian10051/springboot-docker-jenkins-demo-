package com.example.services;

import com.example.data.Student;
import com.example.repos.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepo studentRepo;

	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepo.findById(id);
	}

	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}
}
