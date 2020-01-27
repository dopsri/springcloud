package com.dopsri.spring.deparment.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dopsri.spring.deparment.model.Department;
import com.dopsri.spring.deparment.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping(value = "/list")
	public List<Department> getDepartments() {		
		return departmentRepository.findAll();		
	}
	
	@GetMapping(value = "/{id}")
	public Department getDepartment(@PathVariable(name = "id") Long id) {
		return departmentRepository.findById(id).get();
	}

}
