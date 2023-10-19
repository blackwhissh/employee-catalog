package com.epam.rd.autotasks.springemployeecatalog.entity;

import com.epam.rd.autotasks.springemployeecatalog.entity.Department;
import com.epam.rd.autotasks.springemployeecatalog.entity.FullName;
import com.epam.rd.autotasks.springemployeecatalog.domain.Position;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @Column(name = "ID")
    private Long id;
    @Embedded
    @AttributeOverride(name = "firstName", column = @Column(name = "firstname"))
    @AttributeOverride(name = "lastName", column = @Column(name = "lastname"))
    @AttributeOverride(name = "middleName", column = @Column(name = "middlename"))
    private FullName fullName;
    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(name = "hiredate")
    private LocalDate hired;
    @Column(name = "salary")
    private BigDecimal salary;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    public Employee(Long id, FullName fullName, Position position, LocalDate hired, BigDecimal salary, Employee manager, Department department) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.hired = hired;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getHired() {
        return hired;
    }

    public void setHired(LocalDate hired) {
        this.hired = hired;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return getFullName().getFirstName();
    }


    public String getLastName() {
        return getFullName().getLastName();
    }

    public String getMiddleName() {
        return getFullName().getMiddleName();
    }


}
