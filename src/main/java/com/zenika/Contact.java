package com.zenika;

import java.util.Date;

/**
 *
 *
 */
public class Contact {

    private Long id;

    private String firstname,lastname;

    private Date birth;

    public Contact() {}

    public Contact(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Contact(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Contact(String firstname, String lastname, Date birth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirth() {
        return birth;
    }
}
