/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.Customer;
import ClassConstructor.NhanVien;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class CustomerDAO implements DAOInterface<Customer> {

    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    @Override
    public boolean Add(Customer o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO CUSTOMER_T(idCus, nameCus, contactCus, addressCus)" + "VALUES(?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, o.getID());
            pstm.setString(2, o.getName());
            pstm.setString(3, o.getPhone());
            pstm.setString(4, o.getAddress());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Customer information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(Customer o) {
        Connection conn = connectionDB.getConnection();
        String sql = "delete from CUSTOMER_T where idCus = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, o.getID());
            pstm.execute();
        } catch (Exception e) {
            System.out.println("loi roi thang cho, tu tim loi di ");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Update(Customer o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update CUSTOMER_T set nameCus = ?, contactCus = ?, addressCus = ? where idCus = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getName());
            pstm.setString(2, o.getPhone());
            pstm.setString(3, o.getAddress());
            pstm.setInt(4, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Custommer information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> listCus = new ArrayList<Customer>();
        String SQL = "select * from CUSTOMER_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listCus.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer(
                        rs.getInt("idCus"),
                        rs.getString("nameCus"),
                        rs.getString("contactCus"),
                        rs.getString("addressCus")
                );
                listCus.add(cus);
            }
        } catch (Exception e) {
            System.out.println("Can't writer Custommer information");
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listCus;
    }

    @Override
    public ArrayList<Customer> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
