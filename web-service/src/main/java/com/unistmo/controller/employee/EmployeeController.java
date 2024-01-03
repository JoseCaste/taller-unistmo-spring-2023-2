/**
 * This module is about impact of the final keyword on performance
 * <p>
 * This module explores  if there are any performance benefits from
 * using the final keyword in our code. This module examines the performance
 * implications of using final on a variable, method, and class level.
 * </p>
 *
 * @since 1.0
 * @author baeldung
 * @version 1.1
 */
package com.unistmo.controller.employee;

import com.unistmo.dto.EmployeeDTO;
import com.unistmo.entity.Employee;
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
import java.util.List;

@RestController
@RequestMapping(BASE_EMPLOYEE_PATH_WS)
public class EmployeeController {

    /**
     *
     */
    private final EmployeeService employeeService;

    /**
     * Constructor.
     * @param employeeService
     */
    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Método GET para obtener todos los empleados.
     * @return {@link ResponseEntity}
     */
    @GetMapping(EMPLOYEE_GET_ALL)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployeesList());
    }

    /**
     * Métoo POST para guardar un nuevo empleado.
     * @param employeeDTO
     * @return {@link ResponseEntity}
     */
    @PostMapping(EMPLOYEE_SAVE)
    public ResponseEntity<String> saveNewEmployee(@RequestBody @Valid final EmployeeDTO employeeDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(employeeDTO));
    }
}
