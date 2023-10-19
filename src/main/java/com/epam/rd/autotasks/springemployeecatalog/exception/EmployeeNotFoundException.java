package com.epam.rd.autotasks.springemployeecatalog.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long employeeId){
        super("Employee not found with ID: " + employeeId);
    }
}
