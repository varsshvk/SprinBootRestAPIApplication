package com.hexaware.SpringBootApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.SpringBootApplication.Model.Department;
import com.hexaware.SpringBootApplication.Model.Student;
import com.hexaware.SpringBootApplication.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	// communication between http and response- client(postman app)
	@PostMapping
	 public ResponseEntity<Department> CreateUser(@RequestBody Department dept)
	    {
		    Department savedDepartment=departmentService.createUser(dept);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    
	    }
	@GetMapping
	public ResponseEntity <List<Department>> getDepartments(){
		List<Department> getDepartment=departmentService.getAllDepartments();
		return  new ResponseEntity<>(getDepartment, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int deptId){
		Department getDepartmentById = departmentService.getDepartmentById(deptId);
		return new ResponseEntity<>(getDepartmentById,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") int deptId){
		departmentService.deleteDepartmentById(deptId);
		return new ResponseEntity<>("record deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment( @PathVariable("id") int deptId,
            @RequestBody Department dept) {

		Department updatedDept =departmentService.updateDepartment(deptId, dept);

        return new ResponseEntity<>(updatedDept,HttpStatus.OK);
    }


}
