package com.example.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.EmployeeMapper;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
    	if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
    	
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(()->
		new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto UpdatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("Employee is not exist with given id :" + employeeId)
				);
		employee.setFirstName(UpdatedEmployee.getFirstName());
		employee.setLastName(UpdatedEmployee.getLastName());
		employee.setEmail(UpdatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper. mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long EmployeeId) {
		Employee employee = employeeRepository.findById(EmployeeId).orElseThrow(
				()-> new ResourceNotFoundException("Employee is not exist with given id :" + EmployeeId)
				);
		
		employeeRepository.deleteById(EmployeeId);
		
	}
}
