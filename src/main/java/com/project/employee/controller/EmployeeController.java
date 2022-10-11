package com.project.employee.controller;

import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

   //connect with services or repo:
    @Autowired
    private EmployeeRepository eRepo;

    //Get all list of Data:
    @GetMapping("/")
    public ModelAndView showEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
       List<Employee> list = eRepo.findAll();
       mav.addObject("employees", list);
       return mav;
    }

    //Add new data:
    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return  mav;
    }


    //User click button save function:
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        eRepo.save(employee);
        return "redirect:/";
    }


    //User update the data:
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = eRepo.findById(employeeId).get();
        mav.addObject("employee", employee);
        return mav;
    }

    //delete data:
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId) {
        eRepo.deleteById(employeeId);
        return "redirect:/";
    }


}
