package com.team7.team7_school;

public class Math {
    private String math_Department;
    private String math_Name;
    private String math_Office;
    private String math_Phone;
    private String math_Email;
    private String math_Spec;


    Math() {

    }

    public String getMath_Department() {
        return math_Department;
    }

    public void setMath_Department(String math_Department) {
        this.math_Department = math_Department;
    }

    public String getMath_Name() {
        return math_Name;
    }

    public void setMath_Name(String math_Name) {
        this.math_Name = math_Name;
    }

    public String getMath_Office() {
        return math_Office;
    }

    public void setMath_Office(String math_Office) {
        this.math_Office = math_Office;
    }

    public String getMath_Phone() {
        return math_Phone;
    }

    public void setMath_Phone(String math_Phone) {
        this.math_Phone = math_Phone;
    }

    public String getMath_Email() {
        return math_Email;
    }

    public void setMath_Email(String math_Email) {
        this.math_Email = math_Email;
    }

    public String getMath_Spec() {
        return math_Spec;
    }

    public void setMath_Spec(String math_Spec) {
        this.math_Spec = math_Spec;
    }

    @Override
    public String toString() {
        return math_Name;
    }
}
