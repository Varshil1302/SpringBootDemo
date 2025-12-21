package com.springboot.springMvc.service;

import com.springboot.springMvc.dto.EmployeeDTO;
import com.springboot.springMvc.entity.EmployeeEntity;
import com.springboot.springMvc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService
{
    private final ModelMapper mapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity  employeeEntity=mapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity savedEmployee=employeeRepository.save(employeeEntity);
        return mapper.map(savedEmployee,EmployeeDTO.class);
    }

}
