package com.dopsri.spring.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dopsri.spring.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
