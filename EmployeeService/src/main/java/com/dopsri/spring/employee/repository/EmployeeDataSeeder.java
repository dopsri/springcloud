package com.dopsri.spring.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dopsri.spring.employee.model.Employee;
import com.dopsri.spring.employee.model.EmployeeInfo;

@Component
public class EmployeeDataSeeder implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		List<Employee> empList = new ArrayList<>();
		empList.add(createEmployee("John", 1000, 1L));
		empList.add(createEmployee("Peter", 900, 3L));
		empList.add(createEmployee("Scott", 2500, 2L));
		empList.add(createEmployee("King", 1200, 2L));
		empList.add(createEmployee("Martin", 1400, 3L));
		System.out.println("Saving : " + empList);
		employeeRepository.saveAll(empList);		
		
	}
	
	private Employee createEmployee(String name, double salary, long deptNo) {
		Employee emp = new Employee();
		
		emp.setEmployeeName(name);
		emp.setSalary(salary);
		emp.setDepartmentNumber(deptNo);
		
		return emp;
	}

}
