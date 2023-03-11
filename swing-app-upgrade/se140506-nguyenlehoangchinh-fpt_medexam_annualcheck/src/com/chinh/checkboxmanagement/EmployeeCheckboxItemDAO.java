/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.checkboxmanagement;

import com.chinh.employee.EmployeeDTO;
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
public class EmployeeCheckboxItemDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<EmployeeCheckboxItemDTO> getEmployeeChecboxNameByEmployeeID(String employeeID) {
        String sql = "select cm.employeeID, c.itemName\n"
                + "from TblCheckListManagement cm inner join TblCheckList c on cm.itemID = c.itemID\n"
                + "where employeeID = ? and status = 'checked'";

        try {
            List<EmployeeCheckboxItemDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new EmployeeCheckboxItemDTO(rs.getString(1), rs.getString(2)));
            }
            return list;
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

    public boolean saveAllEmployeeCheckBox(EmployeeCheckboxItemDTO employeeCheckBox) {
        String sql = "insert into TblCheckListManagement \n"
                + "values(?, ?, ?, ?)";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeCheckBox.getId());
            ps.setString(2, employeeCheckBox.getEmployeeID());
            ps.setString(3, employeeCheckBox.getItemName());
            ps.setString(4, employeeCheckBox.getStatus());
            ps.executeUpdate();
            return true;
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
        return false;
    }

    public int getCheckBoxIDByCheckBoxName(String itemName) {
        String sql = "select itemID\n"
                + "from TblCheckList\n"
                + "where itemName = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, itemName);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = rs.getInt(1);
                return itemID;
            }
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

    public List<EmployeeCheckboxItemDTO> getItemManage() {
        List<EmployeeCheckboxItemDTO> list = new ArrayList<>();
        String sql = "select id, employeeID, itemID, status\n"
                + "from TblCheckListManagement";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new EmployeeCheckboxItemDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4).trim()));
            }
        } catch (Exception e) {
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
        return list;
    }

    public boolean updateCheckListManagementStatus(int id, String employeeID, String itemID, String status) {
        String sql = "update TblCheckListManagement\n"
                + "set employeeID = ?, itemID = ?, status = ?\n"
                + "where id = ?";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            ps.setString(2, itemID);
            ps.setString(3, status);
            ps.setInt(4, id);
            int row = ps.executeUpdate();

            if (row > 0) {
                return true;
            }

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
        return false;
    }

    public List<String> getAllCheckBoxManagementItemID(String employeeID) {
        String sql = "select itemID\n"
                + "from TblCheckListManagement\n"
                + "where employeeID = ?";

        try {
            List<String> listItemID = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                listItemID.add(rs.getString(1));
            }
            return listItemID;
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

    public int getIDByEmployeeIDAndItemID(String employeeID, int itemID) {
        String sql = "select id \n"
                + "from TblCheckListManagement\n"
                + "where employeeID = ? and itemID = ?";

        try {
            int id = 0;
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            ps.setInt(2, itemID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
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

    public boolean deleteEmployeeCheckBox(String employeeID) {
        String sql = "delete from TblCheckListManagement\n"
                + "where employeeID = ?";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            int row = ps.executeUpdate();

            if (row > 0) {
                return true;
            }
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
        return false;
    }

    public static void main(String[] args) {
        EmployeeCheckboxItemDAO edao = new EmployeeCheckboxItemDAO();
//        EmployeeCheckboxItemDTO employeeCheckBox = new EmployeeCheckboxItemDTO("7", "1", "1", "test");
//        System.out.println(edao.saveAllEmployeeCheckBox(employeeCheckBox));
        //System.out.println(edao.getItemManage());
        //edao.updateCheckListManagementStatus(129, "ASS22", "4", "unchecked");
        System.out.println(edao.deleteEmployeeCheckBox("TEST55"));
    }
}
