package com.modular.dto;

import java.time.LocalDate;

public class User {
    private String name;
    private String surname;
    private LocalDate birthday;


    public User(String name, String surname, int year, int month, int day) {
        this.name = name;
        this.surname = surname;
        this.birthday = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return getName().toUpperCase()+" "+getSurname().toUpperCase();
    }
}
