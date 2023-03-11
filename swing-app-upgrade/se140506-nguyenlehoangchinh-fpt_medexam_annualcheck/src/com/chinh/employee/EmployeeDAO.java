/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.employee;

import com.chinh.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<EmployeeDTO> getAllEmployeeInfor() {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee";
        try {
            List<EmployeeDTO> listEmp = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listEmp.add(new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
            return listEmp;
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

    public EmployeeDTO getEmployeeByID(String employeeID) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where employeeID = ?";
        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public EmployeeDTO checkExistedEmployeeID(String employeeID) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where employeeID = ?";

        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public EmployeeDTO checkExistedPhone(String phone) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where phone = ?";

        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public EmployeeDTO checkExistedEmail(String email) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where email = ?";

        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public boolean saveNewEmployeeInfor(EmployeeDTO employee) {
        String sql = "insert into TblEmployee \n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeID());
            ps.setString(2, employee.getFullName());
            ps.setDate(3, (Date) employee.getBirthday());
            ps.setBoolean(4, employee.isGender());
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getPhone());
            ps.setString(7, employee.getDepartment());
            ps.setString(8, employee.getAddress());
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

    public boolean updateEmployeeInfor(EmployeeDTO employee) {
        String sql = "update TblEmployee\n"
                + "set fullName = ?, birthday = ?, gender = ?, email = ?, phone = ?, department = ?, address =?\n"
                + "where employeeID = ?";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getFullName());
            ps.setDate(2, (Date) employee.getBirthday());
            ps.setBoolean(3, employee.isGender());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getDepartment());
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getEmployeeID());
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

    public EmployeeDTO checkExistedPhoneForUpdate(String phone, String employeeID) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where phone = ? and employeeID != ?";

        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public EmployeeDTO checkExistedEmailForUpdate(String email, String employeeID) {
        String sql = "select employeeID, fullName, birthday, gender, email, phone, department, address\n"
                + "from TblEmployee\n"
                + "where email = ? and employeeID != ?";

        try {
            EmployeeDTO employee = new EmployeeDTO();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, employeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee = new EmployeeDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return employee;
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

    public boolean deleteEmployee(String employeeID) {
        String sql = "delete from TblEmployee\n"
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
        EmployeeDAO edao = new EmployeeDAO();
        String date = "1999-01-01";
        Date parsed = Date.valueOf(date);
        //EmployeeDTO employee = new EmployeeDTO("a1", "2", parsed, true, "5", "6", "7", "8");
        //System.out.println(edao.checkExistedEmail("da@gmail.com"));
        //EmployeeDTO employee = new EmployeeDTO("TEST22", "Chinh Le", parsed, true, "chinhnguyen16@gmail.com", "0328802216", "Business Administration", "123b");
        System.out.println(edao.deleteEmployee("TEST44"));
    }
}
