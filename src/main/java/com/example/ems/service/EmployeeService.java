package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById(Long employeeId);
    
    List <EmployeeDto> getAllEmployee();
    
    EmployeeDto updateEmployee (Long employeeId, EmployeeDto UpdatedEmployee);
    
    void deleteEmployee (Long EmployeeId);
}
