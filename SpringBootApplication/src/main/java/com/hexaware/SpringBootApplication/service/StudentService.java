package com.hexaware.SpringBootApplication.service;

import java.util.List;

import com.hexaware.SpringBootApplication.Model.Student;

public interface StudentService {
	Student createUser(Student stud);
	List<Student> getAllStudents();
	Student getStudentById(int studId);
	Student deleteStudentById(int studId);
	Student updateStudent(int studId, Student stud);


}
