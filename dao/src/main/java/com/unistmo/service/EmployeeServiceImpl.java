package com.unistmo.service;

import com.unistmo.dto.EmployeeDTO;
import com.unistmo.entity.Employee;
import com.unistmo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee
                .builder()
                .lastname(employeeDTO.getLastname())
                .build();

        employeeRepository.save(employee);
        return "Usuario creado";
    }
}
