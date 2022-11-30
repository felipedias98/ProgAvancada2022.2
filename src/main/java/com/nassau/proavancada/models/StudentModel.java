package com.nassau.proavancada.models;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(length = 45)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(length = 45)
    private String address;

    @Column(unique = true, length = 20)
    private String document;

    public StudentModel() {}

    public StudentModel (String name, String phone, String address, String document) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.document = document;
    }

    public StudentModel (int id, String name, String phone, String address, String document) {
        this.studentId = id;
        this.name = name;
        this.phone = phone;
        this.document = document;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
