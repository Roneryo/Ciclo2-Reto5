package com.example.demo1;

public class Lider {

    private Integer id =null;
    private String firstName = null;
    private String lastName = null;
    private String City = null;
    public Lider() {
    }

    public String getCity() {
        return City;
    }

    public Lider(Integer id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        City = city;
    }

    public void setCity(String city) {
        City = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lider(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
