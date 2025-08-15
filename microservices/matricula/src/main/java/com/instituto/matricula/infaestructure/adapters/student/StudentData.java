package com.instituto.matricula.infaestructure.adapters.student;

public class StudentData {
    private String uid;
    private String documentNumber;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String photo;
    private int active;

    public StudentData() {
    }

    public StudentData(String uid, String documentNumber, String name, String lastName, String phone, String email, String photo, int active) {
        this.uid = uid;
        this.documentNumber = documentNumber;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.active = active;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
