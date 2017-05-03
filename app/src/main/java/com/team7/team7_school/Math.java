package com.team7.team7_school;

public class Math {
    private int Building_ID;
    private String Department;
    private String Name;
    private String Office;
    private String Phone;
    private String Email;
    private String Spec;

    Math() {

    }

    public int getBuilding_ID() {
        return Building_ID;
    }

    public void setBuilding_ID(int Building_ID) {
        this.Building_ID = Building_ID;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String Office) {
        this.Office = Office;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String Spec) {
        this.Spec = Spec;
    }

    @Override
    public String toString() {
        return Name;
    }
}
