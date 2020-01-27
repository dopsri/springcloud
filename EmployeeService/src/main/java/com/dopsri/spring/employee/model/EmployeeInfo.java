package com.dopsri.spring.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeInfo {
	
	@Getter @Setter
	private int employeeNumber;
	
	@Getter @Setter
	private String employeeName;
	
	@Getter @Setter
	private double salary;
	
	@Getter @Setter
	private String departmentName;	

}
