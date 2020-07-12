package com.example.baby_yoda;

public class database_model {
    private String name;
    private String contact;

    public database_model() {
    }

    public database_model(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
