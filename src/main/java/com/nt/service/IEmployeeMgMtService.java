package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.model.Employee;


public interface IEmployeeMgMtService {
	public List<Employee> fetchAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int no);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int no);
}
