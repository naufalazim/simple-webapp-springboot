package com.project.employee.controller;

import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

   //connect with services or repo:
    @Autowired
    private EmployeeRepository eRepo;

    @GetMapping("/")
    public ModelAndView showEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
       List<Employee> list = eRepo.findAll();
       mav.addObject("employees", list);
       return mav;
    }
}
