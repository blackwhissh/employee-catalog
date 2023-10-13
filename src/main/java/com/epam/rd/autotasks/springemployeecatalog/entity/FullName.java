package com.epam.rd.autotasks.springemployeecatalog.entity;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {
    private String firstName;
    private String lastName;
    private String middleName;

    public FullName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public FullName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


}
