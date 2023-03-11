/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.employee;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class EmployeeDTO {

    private String employeeID; // 1
    private String fullName; // 2
    private Date birthday; // 3
    private boolean gender; // 4
    private String email; // 5
    private String phone; // 6
    private String department; // 7
    private String address; // 8

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeID, String fullName, Date birthday, boolean gender, String email, String phone, String department, String address) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.address = address;
    }


    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeID=" + employeeID + ", fullName=" + fullName + ", birthday=" + birthday + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", department=" + department + ", address=" + address + '}' + "\n";
    }

    
}
