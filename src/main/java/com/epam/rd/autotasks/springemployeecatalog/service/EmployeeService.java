package com.epam.rd.autotasks.springemployeecatalog.service;

import com.epam.rd.autotasks.springemployeecatalog.entity.Employee;
import com.epam.rd.autotasks.springemployeecatalog.exception.EmployeeNotFoundException;
import com.epam.rd.autotasks.springemployeecatalog.repository.DepartmentRepository;
import com.epam.rd.autotasks.springemployeecatalog.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private final DepartmentRepository departmentRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort).ascending());
        Page<Employee> employeePage = employeeRepository.findAll(pageRequest);
        return employeePage.getContent();
    }

    public Employee getEmployeeById(Long employeeId, boolean fullChain) {
        if(fullChain){
            return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        }else {
            return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId)).getManager();
        }
    }

    public List<Employee> getEmployeesByManagerId(Long managerId, int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
        Page<Employee> employeePage = employeeRepository.findAllByManagerId(managerId, pageRequest);
        return employeePage.getContent();
    }

    public List<Employee> getEmployeesByDepartment(String identifier, int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
        Page<Employee> employeePage;
        if (isId(identifier)) {
            employeePage = employeeRepository.findAllByDepartmentId(Long.parseLong(identifier), pageRequest);
        } else {
            employeePage = employeeRepository.findAllByDepartmentId(departmentRepository.findDepartmentId(identifier), pageRequest);
        }
        return employeePage.getContent();
    }

    private static boolean isId(String identifier) {
        try {
            Long.parseLong(identifier);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
