package com.IIYSoftware.otpauthentication;

import androidx.annotation.NonNull;

public class Visitor {
    private String StudentName;
    private String VisitorName;
    private String StudentClass;
    private String Section;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String phonenumber;

    public Visitor(String studentName, String visitorName, String studentClass, String section, String rollNo, String phoneNo) {
        StudentName = studentName;
        VisitorName = visitorName;
        StudentClass = studentClass;
        Section = section;
        RollNo = rollNo;
        phonenumber = phoneNo;
    }

    private String RollNo;

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getVisitorName() {
        return VisitorName;
    }

    public void setVisitorName(String visitorName) {
        VisitorName = visitorName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }
}
