package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;

@Service("empService")
public class EmployeeMgMtServiceImpl implements IEmployeeMgMtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> fetchAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		//save the object
		int idVal=empRepo.save(emp).getEmpno();
		return "Employee saved with idVal " +idVal;
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		// 
		Employee emp=empRepo.getReferenceById(no);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		Optional<Employee> opt= empRepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			empRepo.save(emp);
			return emp.getEmpno()+"employee is updated";
		}
		return emp.getEmpno()+"employee is not available for updation";
	}

	@Override
	public String deleteEmployee(int no) {
		empRepo.deleteById(no);
		return "employee is deleted";
	}

}
