package com.unistmo.service.employee;


import com.unistmo.dto.EmployeeDTO;
import com.unistmo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeesList();

    Object saveEmployee(EmployeeDTO employeeDTO);
}
