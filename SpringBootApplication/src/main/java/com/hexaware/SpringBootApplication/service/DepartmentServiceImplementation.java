package com.hexaware.SpringBootApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.SpringBootApplication.Model.Department;
import com.hexaware.SpringBootApplication.Model.Student;
import com.hexaware.SpringBootApplication.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
	private DepartmentRepository deptRepo;
	public DepartmentServiceImplementation(DepartmentRepository deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}
	
	@Override
	public Department createUser(Department dept) {
		// TODO Auto-generated method stub
		return deptRepo.save(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public Department getDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		return deptRepo.findById(deptId).orElse(null);
	}

	@Override
	public Department deleteDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		Optional <Department> departmentId=deptRepo.findById(deptId);
		return departmentId.get();
	}

	@Override
	public Department updateDepartment(int deptId, Department dept) {
		 Department updateDepartment = deptRepo.findById(deptId).get();

		    // Update only name & age
		 updateDepartment.setDeptName(dept.getDeptName());
		

		    return deptRepo.save(updateDepartment);
	}

}
