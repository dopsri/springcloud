package com.dopsri.spring.deparment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dopsri.spring.deparment.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
