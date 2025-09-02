package com.hexaware.SpringBootApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
 
import com.hexaware.SpringBootApplication.Model.Student;
import com.hexaware.SpringBootApplication.repository.DepartmentRepository;
import com.hexaware.SpringBootApplication.repository.StudentRepository;
 
@Service
public class StudentServiceImplementation implements StudentService {
 
	private StudentRepository studentRepo;
	private DepartmentRepository departmentRepo;
	public StudentServiceImplementation(StudentRepository studentRepo, DepartmentRepository departmentRepo) {
		super();
		this.studentRepo = studentRepo;
		this.departmentRepo = departmentRepo;
	}
 
	@Override
	public Student createUser(Student stud) {
		// TODO Auto-generated method stub
		return studentRepo.save(stud);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	//to get information from tale by using id 2 methods- 1. findById() and get()
	@Override
	public Student getStudentById(int studId) {
		// TODO Auto-generated method stub
		Optional <Student> studentId=studentRepo.findById(studId);
		return studentId.get();
	}

	@Override
	public Student deleteStudentById(int studId) {
		// TODO Auto-generated method stub
		Optional <Student> studentId=studentRepo.findById(studId);
		return null;
	}
	
	@Override
	public Student updateStudent(int studId, Student stud) {
	    Student updateStud = studentRepo.findById(studId).get();

	    // Update only name & age
	    updateStud.setStudentName(stud.getStudentName());
	    updateStud.setStudentAge(stud.getStudentAge());

	    return studentRepo.save(updateStud);
	}



}