/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.NhaCungCap;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class SupplierDAO implements DAOInterface<NhaCungCap> {

    public static SupplierDAO getInstance() {
        return new SupplierDAO();
    }

    @Override
    public boolean Add(NhaCungCap o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO SUPPLIER_T(idSup, nameSup, contactSup, addressSup)" + "VALUES(?,?,?,?)";
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
            System.out.println("Can't writer supplier information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(NhaCungCap o) {
        Connection conn = connectionDB.getConnection();
        String sql = "delete from SUPPLIER_T where idSup = ?";
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
    public boolean Update(NhaCungCap o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update SUPPLIER_T set nameSup = ?, contactSup = ?, addressSup = ? where idSup = ?";
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
            System.out.println("Can't Update Supplier information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<NhaCungCap> selectAll() {
  ArrayList<NhaCungCap> listNnc = new ArrayList<NhaCungCap>();
        String SQL = "select * from SUPPLIER_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listNnc.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhaCungCap nnc = new NhaCungCap(
                        rs.getInt("idSup"),
                        rs.getString("nameSup"),
                        rs.getString("contactSup"),
                        rs.getString("addressSup")
                );
                listNnc.add(nnc);
            }
        } catch (Exception e) {
            System.out.println("Can't writer Sup information");
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listNnc;    }

    @Override
    public ArrayList<NhaCungCap> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
