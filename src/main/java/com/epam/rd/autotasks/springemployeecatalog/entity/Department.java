package com.epam.rd.autotasks.springemployeecatalog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    private Long id;
    private String name;
    private String location;

    public Department(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // constructors, getters, setters
}
