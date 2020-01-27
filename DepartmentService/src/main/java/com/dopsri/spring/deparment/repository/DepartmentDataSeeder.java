package com.dopsri.spring.deparment.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dopsri.spring.deparment.model.Department;

@Component
public class DepartmentDataSeeder implements CommandLineRunner {

	@Autowired
	private DepartmentRepository DepartmentRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Department> departments = Arrays.asList("HR", "FINANCE", "ADMIN", "SALES", "OPERATIONS", "IT").stream()
				.map(dept -> new Department(dept)).collect(Collectors.toList());

		DepartmentRepository.saveAll(departments);

	}

}
