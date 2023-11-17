package com.unistmo.service;


import com.unistmo.dto.EmployeeDTO;
import com.unistmo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeesList();

    Object saveEmployee(EmployeeDTO employeeDTO);
}
