package com.hexaware.SpringBootApplication.service;

import java.util.List;

import com.hexaware.SpringBootApplication.Model.Department;



public interface DepartmentService {
	Department createUser(Department dept);
	
	List<Department> getAllDepartments();
	Department getDepartmentById(int deptId);
	Department deleteDepartmentById(int deptId);
	Department updateDepartment(int deptId, Department dept);

}
