package com.mycompany.edu.api.service;

import com.mycompany.edu.api.dto.Employee;
import com.mycompany.edu.api.exception.EmployeeNotFoundException;
import java.util.List;

/**
 *
 * @author yosrixp
 */
public interface EmployeeService {

    public List<Employee> getEmployeeList();

    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

}
