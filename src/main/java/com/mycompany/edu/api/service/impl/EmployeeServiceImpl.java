package com.mycompany.edu.api.service.impl;

import com.mycompany.edu.api.dto.Employee;
import com.mycompany.edu.api.exception.EmployeeNotFoundException;
import com.mycompany.edu.api.service.EmployeeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.glassfish.jersey.internal.guava.Lists;

/**
 *
 * @author yosrixp
 */
public class EmployeeServiceImpl implements EmployeeService {

    Map<Long, Employee> employeeMap = new HashMap<Long, Employee>() {
        {
            put(1l, new Employee(1l, "Ahmad", "Senior Software Engineer"));
            put(2l, new Employee(2l, "Ali", "Staff Engineer"));
            put(3l, new Employee(3l, "Tamer", "Junior Software Engineer"));
        }
    };

    @Override
    public List<Employee> getEmployeeList() {
        return Lists.newArrayList(employeeMap.values());
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException(String.format("Employee with id: %d is not found", employeeId));
        }
        return employee;
    }

}
