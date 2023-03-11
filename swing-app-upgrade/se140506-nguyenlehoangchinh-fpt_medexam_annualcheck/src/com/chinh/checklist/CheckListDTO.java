/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.checklist;

/**
 *
 * @author Admin
 */
public class CheckListDTO {

    private int itemID;
    private String itemName;

    public CheckListDTO() {
    }

    public CheckListDTO(int itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "CheckListDTO{" + "itemID=" + itemID + ", itemName=" + itemName + '}';
    }
}
