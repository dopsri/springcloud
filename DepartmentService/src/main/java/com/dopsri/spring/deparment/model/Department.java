package com.dopsri.spring.deparment.model;

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
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@ToString
public class Department {
	
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Getter @Setter
	@Id
	@GeneratedValue
	@Column(name = "deptno")
	private long departmentNumber;
	
	@Getter @Setter
	@Column(name = "deptname", unique = true)
	private String departmentName;
	

}
