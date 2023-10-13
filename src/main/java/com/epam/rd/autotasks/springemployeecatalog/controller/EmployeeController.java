package com.epam.rd.autotasks.springemployeecatalog.controller;

import com.epam.rd.autotasks.springemployeecatalog.entity.Employee;
import com.epam.rd.autotasks.springemployeecatalog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "salary") String sort){
        return employeeService.getAllEmployees(page,size,sort);
    }

    @GetMapping(path = "{employee_id}")
    public Employee getEmployee(@PathVariable("employee_id") Long employeeId,
                                @RequestParam(name = "full_chain", required = false, defaultValue = "false") boolean fullChain){
        return employeeService.getEmployeeById(employeeId, fullChain);
    }
    @GetMapping(path = "/by_manager/{manager_id}")
    public List<Employee> getEmployeesByManagerId(@PathVariable("manager_id") Long managerId,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "salary") String sort){
        return employeeService.getEmployeesByManagerId(managerId, page, size, sort);
    }

    @GetMapping(path = "/by_department/{department_identifier}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("department_identifier") String identifier,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(defaultValue = "salary") String sort){
        return employeeService.getEmployeesByDepartment(identifier, page, size, sort);
    }
}
