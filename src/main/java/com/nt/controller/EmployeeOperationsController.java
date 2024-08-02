package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgMtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgMtService empService;
	
	@GetMapping("/")
	public String showEmployee(){
		
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showEmpReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.showEmpReport()");
		List<Employee> empList=empService.fetchAllEmployees();
		map.put("empsInfo", empList);
		return "show_report";
	}
	
	
	@GetMapping("/register")
	public String showRegisterEmployee(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.showRegisterEmployeeFormPage()");
		return "employee_register_form";
		
	}
	
	/*
	 * @PostMapping("/register") public String processRegisterEmployee(Map<String,
	 * Object> map, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); List<Employee>
	 * list=empService.fetchAllEmployees(); map.put("resultMsg", msg);
	 * map.put("empsInfo", list); return "show_report";
	 * 
	 * }
	 */
	
	/*
	 * @PostMapping("/register") //prg pattern solve double posting problem public
	 * String processRegisterEmployee(Map<String, Object>
	 * map, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); // List<Employee>
	 * list=empService.fetchAllEmployees(); map.put("resultMsg", msg);
	 * //map.put("empsInfo", list); return "redirect:report";
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/register") //prg pattern solve double posting problem + flash
	 * attribute public String processRegisterEmployee(RedirectAttributes
	 * attrs, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); // List<Employee>
	 * list=empService.fetchAllEmployees(); attrs.addFlashAttribute("resultMsg",
	 * msg); //map.put("empsInfo", list); return "redirect:report";
	 * 
	 * }
	 */
	

	@PostMapping("/register") //prg pattern solve double posting problem + flash attribute
	public String processRegisterEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.showRegisterEmployeeFormPage()");
		//use service  clas
		String msg=empService.registerEmployee(emp);
	//	List<Employee> list=empService.fetchAllEmployees();
		ses.setAttribute("resultMsg", msg);
		//map.put("empsInfo", list);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,  @ModelAttribute("emp") Employee emp) {
		Employee emp1=empService.getEmployeeByNo(no);
		//keep emp1 model object data to emp
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit_form";
	}
	@PostMapping("/edit")
	public String processEditFormPage(RedirectAttributes attrs,  @ModelAttribute("emp") Employee emp) {
		
		String msg=empService.updateEmployee(emp);
		//keep emp1 model object data to emp
		
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String showDeleteEmployee(@RequestParam("no") int no, RedirectAttributes attrs) {
		//use service
		String msg=empService.deleteEmployee(no);
		//keep the result in modelAttribute
		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
	}



}
