package com.springboot.springMvc.service;

import com.springboot.springMvc.dto.EmployeeDTO;
import com.springboot.springMvc.entity.EmployeeEntity;
import com.springboot.springMvc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public EmployeeDTO fetchEmployee(Long Id)
    {
        EmployeeEntity employee=employeeRepository.findById(Id).orElse(null);
        return mapper.map(employee,EmployeeDTO.class);
    }
    public List<EmployeeDTO> findlAllEmployee()
    {
        List<EmployeeEntity> lstEmp=employeeRepository.findAll();
        List<EmployeeDTO> result=lstEmp.stream().map(emp->mapper.map(emp,EmployeeDTO.class)).collect(Collectors.toList());
        return result;
    }
    public boolean deleteEmployee(Long Id)
    {
        boolean isexists=employeeRepository.existsById(Id);
        if(!isexists) return false;
        employeeRepository.deleteById(Id);
        return true;
    }
    public EmployeeDTO updateEmployee(Long Id,EmployeeDTO employeeDTO)
    {
       // EmployeeEntity employeeEntity=mapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity employeeEntity1=employeeRepository.findById(Id).orElse(null);
        employeeEntity1.setAge(employeeDTO.getAge());
        employeeEntity1.setDateOfJoining(employeeDTO.getDateOfJoining());
        employeeEntity1.setEmail(employeeDTO.getEmail());
        employeeEntity1.setRole(employeeDTO.getRole());
        employeeEntity1.setName(employeeDTO.getName());
        employeeEntity1.setSalary(employeeDTO.getSalary());
        EmployeeEntity savedEmployee=employeeRepository.save(employeeEntity1);
        return mapper.map(savedEmployee,EmployeeDTO.class);
    }
    public EmployeeDTO updatePartialEmployeeDetail(Long Id,EmployeeDTO empdto)
    {
        EmployeeEntity employeeEntity=employeeRepository.findById(Id).orElse(null);
        employeeEntity.setEmail(empdto.getEmail());
        EmployeeEntity savedEmployee=employeeRepository.save(employeeEntity);
        return mapper.map(savedEmployee,EmployeeDTO.class);
    }

}
