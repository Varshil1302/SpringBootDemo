package com.springboot.springMvc.controller;

import com.springboot.springMvc.dto.EmployeeDTO;
import com.springboot.springMvc.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController
{

    private final EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO)
    {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("Id") Long id)
    {
        return ResponseEntity.ok(employeeService.fetchEmployee(id));
    }

    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee()
    {
        return ResponseEntity.ok(employeeService.findlAllEmployee());
    }

    @DeleteMapping("/removeEmployee/{Id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("Id") Long id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @PutMapping("/updateEmployee/{Id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("Id") Long id,@RequestBody EmployeeDTO employeeDTO)
    {
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDTO));
    }

    @PatchMapping("/updatePartialEmployee/{Id}")
    public ResponseEntity<EmployeeDTO> updateParialEmployee(@PathVariable Long Id,
                                            @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updatePartialEmployeeDetail(Id,employeeDTO));
    }

}
