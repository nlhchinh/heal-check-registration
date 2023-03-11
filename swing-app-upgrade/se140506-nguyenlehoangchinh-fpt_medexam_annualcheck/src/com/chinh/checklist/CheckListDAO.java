/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.checklist;

import com.chinh.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CheckListDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int countRowCheckListTable() {
        String sql = "select count(itemName) \n"
                + "from TblCheckList";

        try {
            int totalRow = 0;
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRow = rs.getInt(1);
            }
            return totalRow;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return -1;
    }

    public List<String> getAllItemName() {
        String sql = "select itemName\n"
                + "from TblCheckList";

        try {
            List<String> listItem = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listItem.add(rs.getString(1));
            }
            return listItem;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CheckListDAO cdao = new CheckListDAO();
        System.out.println(cdao.getAllItemName());
    }
}
