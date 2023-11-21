package com.unistmo.controller.employee;

import com.unistmo.dto.EmployeeDTO;
import com.unistmo.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static com.unistmo.ws.ConstantsWs.BASE_EMPLOYEE_PATH_WS;
import static com.unistmo.ws.ConstantsWs.EMPLOYEE_GET_ALL;
import static com.unistmo.ws.ConstantsWs.EMPLOYEE_SAVE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(BASE_EMPLOYEE_PATH_WS)
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(EMPLOYEE_GET_ALL)
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getEmployeesList());
    }

    @PostMapping(EMPLOYEE_SAVE)
    public ResponseEntity<?> saveNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeDTO));
    }
}
