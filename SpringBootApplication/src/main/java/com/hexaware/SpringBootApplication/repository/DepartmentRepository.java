package com.hexaware.SpringBootApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.SpringBootApplication.Model.Department;

public interface DepartmentRepository extends  JpaRepository<Department, Integer> {

}
