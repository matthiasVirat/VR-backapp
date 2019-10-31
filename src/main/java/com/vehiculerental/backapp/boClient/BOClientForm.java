package com.vehiculerental.backapp.boClient;

public class BOClientForm {

    private int id;
    private String firstname;
    private String lastname;
    private int dateOfBirth;
    private int licenseObtentionDate;
    private int driversLicenseNumber;
    private String mail;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLicenseObtentionDate() {
        return licenseObtentionDate;
    }

    public void setLicenseObtentionDate(int licenseObtentionDate) {
        this.licenseObtentionDate = licenseObtentionDate;
    }

    public int getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(int driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
