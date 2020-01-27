package com.dopsri.spring.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@ToString
public class Employee {
	
	@Getter @Setter
	@Id
	@GeneratedValue
	@Column(name = "empno")
	private int employeeNumber;
	
	@Getter @Setter
	@Column(name = "empname")
	private String employeeName;
	
	@Getter @Setter
	@Column(name = "salary")
	private double salary;
	
	@Getter @Setter
	@Column(name = "deptno")
	private long departmentNumber;	

}
