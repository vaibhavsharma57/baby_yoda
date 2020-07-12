package com.example.baby_yoda;

public class MydataItems {
    String name;
    String contact_number;

    public MydataItems(String name, String contact_number) {
        this.name = name;
        this.contact_number = contact_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "MydataItems{" +
                "name='" + name + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
