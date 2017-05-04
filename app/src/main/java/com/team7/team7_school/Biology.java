package com.team7.team7_school;

public class Biology {
    private String biology_Department;
    private String biology_Name;
    private String biology_Office;
    private String biology_Phone;
    private String biology_Email;


    Biology() {

    }

    public String getBiology_Department() {
        return biology_Department;
    }

    public void setBiology_Department(String biology_Department) {
        this.biology_Department = biology_Department;
    }

    public String getBiology_Name() {
        return biology_Name;
    }

    public void setBiology_Name(String biology_Name) {
        this.biology_Name = biology_Name;
    }

    public String getBiology_Office() {
        return biology_Office;
    }

    public void setBiology_Office(String biology_Office) {
        this.biology_Office = biology_Office;
    }

    public String getBiology_Phone() {
        return biology_Phone;
    }

    public void setBiology_Phone(String biology_Phone) {
        this.biology_Phone = biology_Phone;
    }

    public String getBiology_Email() {
        return biology_Email;
    }

    public void setBiology_Email(String biology_Email) {
        this.biology_Email = biology_Email;
    }

    @Override
    public String toString() {
        return biology_Name;
    }
}
