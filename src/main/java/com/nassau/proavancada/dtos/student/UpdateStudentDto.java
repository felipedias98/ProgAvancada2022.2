package com.nassau.proavancada.dtos.student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateStudentDto {
    @Size(min = 1, max = 45, message = "Phone must be 1 to 45 characters")
    private String name;

    @Size(min = 1, max = 20, message = "Phone must be 1 to 20 characters")
    private String phone;

    @Size(min = 1, max = 45, message = "Address must be 1 to 45 characters")
    private String address;

    @Size(min = 1, max = 20, message = "Document must be 1 to 20 characters")
    private String document;

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
