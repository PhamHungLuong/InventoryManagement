/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.NhanVien;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUÂN BÙI
 */
public class EmployeeDAO implements DAOInterface<NhanVien> {

    public static EmployeeDAO getInstance() {
        return new EmployeeDAO();
    }

    @Override
    public boolean Add(NhanVien o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO EMPLOYEE_T(idEmp, nameEmp, sex, addressEmp,birthDay,accEmp, passwordEmp,  empPosition, activeEmp)" + "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, o.getID());
            pstm.setString(2, o.getHoTen());
            pstm.setString(3, o.getGioiTinh());
            pstm.setString(4, o.getQue());
            pstm.setString(5, o.getBirthDay());
            pstm.setString(6, o.getUser());
            pstm.setString(7, o.getPass());
            pstm.setString(8, o.getPosition());
            pstm.setString(9, o.getActive());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer staff information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(NhanVien o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update EMPLOYEE_T set activeEmp = 'off' where idEmp = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer staff information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Update(NhanVien o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update EMPLOYEE_T set nameEmp = ?, sex = ?, addressEmp = ? , birthDay = ? , accEmp = ? ,passwordEmp = ?, empPosition = ? where idEmp = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getHoTen());
            pstm.setString(2, o.getGioiTinh());
            pstm.setString(3, o.getQue());
            pstm.setString(4, o.getBirthDay());
            pstm.setString(5, o.getUser());
            pstm.setString(6, o.getPass());
            pstm.setString(7, o.getPosition());
            pstm.setString(8, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer staff information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
        ArrayList<NhanVien> listEmp = new ArrayList<NhanVien>();
        String SQL = "select * from EMPLOYEE_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listEmp.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("idEmp"),
                        rs.getString("nameEmp"),
                        rs.getString("sex"),
                        rs.getString("addressEmp"),
                        rs.getString("birthDay"),
                        rs.getString("accEmp"),
                        rs.getString("passwordEmp"),
                        rs.getString("empPosition"),
                        rs.getString("activeEmp")
                );
                listEmp.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("check");
            connectionDB.closeConnection(conn);
        }
        return listEmp;
    }

    @Override
    public ArrayList<NhanVien> selectByCondition(String condition) {
        ArrayList<NhanVien> listEmp = new ArrayList<NhanVien>();
        String SQL = "select * from EMPLOYEE_T where activeEmp = '" + condition + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("idEmp"),
                        rs.getString("nameEmp"),
                        rs.getString("sex"),
                        rs.getString("addressEmp"),
                        rs.getString("birthDay"),
                        rs.getString("accEmp"),
                        rs.getString("passwordEmp"),
                        rs.getString("empPosition"),
                        rs.getString("activeEmp")
                );
                listEmp.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listEmp;
    }

}
