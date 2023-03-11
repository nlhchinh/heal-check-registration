/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.checkboxmanagement;

/**
 *
 * @author Admin
 */
public class EmployeeCheckboxItemDTO {

    private int id;
    private String employeeID;
    private String itemName;
    private String status;

    public EmployeeCheckboxItemDTO() {
    }

    public EmployeeCheckboxItemDTO(String employeeID, String itemName) {
        this.employeeID = employeeID;
        this.itemName = itemName;
    }

    public EmployeeCheckboxItemDTO(int id, String employeeID, String itemName, String status) {
        this.id = id;
        this.employeeID = employeeID;
        this.itemName = itemName;
        this.status = status;
    }

    public EmployeeCheckboxItemDTO(String employeeID) {
        this.employeeID = employeeID;
    }
    

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeCheckboxItemDTO{" + "id=" + id + ", employeeID=" + employeeID + ", itemName=" + itemName + ", status=" + status + '}';
    }
}
