package com.mycompany.edu.api.web;

import com.mycompany.edu.api.dto.Employee;
import com.mycompany.edu.api.exception.EmployeeNotFoundException;
import com.mycompany.edu.api.service.EmployeeService;
import com.mycompany.edu.api.service.impl.EmployeeServiceImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author yosrixp
 */
@Path("/")
public class EmployeeResource {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employeeService.getEmployeeList();
    }

    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") Long employeeId) throws EmployeeNotFoundException {
        try {
            return employeeService.getEmployeeById(employeeId);
        } catch (EmployeeNotFoundException ex) {
            throw new WebApplicationException(ex.getMessage(), ex.toResponse());
        }
    }
}
