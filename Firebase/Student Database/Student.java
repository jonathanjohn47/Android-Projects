package com.example.jonathan;

import android.net.Uri;

public class Student {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student( String name, String course, String school) {
        this.name = name;
        this.course = course;
        this.school = school;
    }

    public Student() {
    }

    private String name, email, course, school;

}
