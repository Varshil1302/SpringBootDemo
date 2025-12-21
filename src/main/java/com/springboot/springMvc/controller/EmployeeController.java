package com.springboot.springMvc.controller;

import com.springboot.springMvc.dto.EmployeeDTO;
import com.springboot.springMvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController
{

    private final EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.createEmployee(employeeDTO);
    }

}
