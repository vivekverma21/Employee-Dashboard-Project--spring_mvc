package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Handler for Home page
   @GetMapping("/employee")
   
    public ModelAndView getHomeView()
   {
        List<Employee> employeeList = employeeService.getList();
        ModelAndView modelAndView = new ModelAndView("employee-list");
        modelAndView.addObject("employees", employeeList);
      System.out.println("hello");
        return modelAndView;
    }
   
   @GetMapping("/employee/add")
   public String getAddEmployeeView() 
   {
       return "add-employee";
   }
   
   @PostMapping("/employee/save")
   public String saveEmployee(Employee employee) {
       employeeService.saveRecord(employee);
       return "redirect:/employee"; // redirect to employee list
   }
   
   @GetMapping("/employee/delete")
   public String deleteEmployee(int eid) 
   {
	   employeeService.deleteRecord(eid);
       return "redirect:/employee";  // redirect to employee list
   }
   
   @GetMapping("/employee/edit")
   public String getEditEmployeeView(int eid,Model model) 
   {
	   Employee employee = employeeService.getRecord(eid);
	   model.addAttribute("emp", employee);
       return "edit-employee";
   }
   
   @PostMapping("/employee/update")
   public String updateEmployeeView(Employee employee) 
   {
	   employeeService.updateRecord(employee);
       return "redirect:/employee";
   }
  


}
