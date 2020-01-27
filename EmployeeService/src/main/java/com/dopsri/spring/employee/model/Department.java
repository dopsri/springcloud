package com.dopsri.spring.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
	
	@Getter @Setter
	private long departmentNumber;
	
	@Getter @Setter
	private String departmentName;

}
