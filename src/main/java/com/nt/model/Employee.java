package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp")
public class Employee {

	@Id
	
	@SequenceGenerator(name="gen1" ,sequenceName = "EMP_ID_SEQ",initialValue = 1,allocationSize = 10000)
	@GeneratedValue(generator ="gen1", strategy = GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String ejob="manager";
	private Double esalary;
	private Integer edeptno;
}
