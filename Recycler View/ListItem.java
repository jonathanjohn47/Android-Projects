package com.example.recyclerview;

public class ListItem {
    private String firstname, lastname;
    private int marks;

    public ListItem(String firstname, String lastname, int marks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.marks = marks;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
