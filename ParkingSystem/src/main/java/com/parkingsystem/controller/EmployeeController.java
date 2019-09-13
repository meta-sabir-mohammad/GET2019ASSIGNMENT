package com.parkingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.service.EmployeeService;
@Controller
public class EmployeeController {

	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employeePOJO") EmployeePOJO employeePOJO,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "employeeregistration";
		}else {
			EmployeeService employeeService = new EmployeeService();
			try {
				int employeeId = employeeService.addEmployee(employeePOJO);
				if(employeeId > 0) {
					return "login";
				}else {
					return "employeeregistration";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "employeeregistration";
			}
		}
		
	}
	
	@GetMapping("/addemployeepage")
	public String showAddEmployeePage(Model model) {
		model.addAttribute(new EmployeePOJO());
		return "employeeregistration";
	}
	
	@GetMapping("/homepage")
	public String showEmployeeHomePage(Model model,HttpSession session) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeService employeeService = new EmployeeService();
		String email = (String)session.getAttribute("email");
		try {
			employeeDTO = employeeService.getEmployeeDetail(email);
			model.addAttribute(employeeDTO);
			return "private/employeehome";
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
	}
	
	@GetMapping("/editemployeedetail")
	public String showEmployeeDetailUpdatePage(Model model) {
		
		return "private/updateemployeedetails";
	}
	
	@GetMapping("/friendslistpage")
	public String showFriendsListPage(Model model,HttpSession session) {
		
		String email = (String)session.getAttribute("email");
		EmployeeService employeeService = new EmployeeService();
		try {
			List<EmployeeDTO> friendList = employeeService.getFriendList(email);
			model.addAttribute(friendList);
			return "private/employeefriends";
		} catch (Exception e) {
			e.printStackTrace();
			return "private/employeehome";
		}
	}
}
