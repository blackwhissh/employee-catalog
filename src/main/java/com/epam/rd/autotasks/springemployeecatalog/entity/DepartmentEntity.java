package com.epam.rd.autotasks.springemployeecatalog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class DepartmentEntity {

    @Id
    private Long id;

    private String name;

    private String location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}