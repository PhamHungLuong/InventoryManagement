/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.HoaDonNhap;
import ClassConstructor.HoaDonXuat;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class ExportInvoiceDAO implements DAOInterface<HoaDonXuat> {

    public static ExportInvoiceDAO getInstance() {
        return new ExportInvoiceDAO();
    }

    @Override
    public boolean Add(HoaDonXuat o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO EXPORTINVOICE_T(idExpInv, idCus, idEmp, dateExp)" + "VALUES(?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, o.getID());
            pstm.setInt(2, o.getCustommerID());
            pstm.setString(3, o.getStaff());
            pstm.setString(4, o.getDate());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Exp information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(HoaDonXuat o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(HoaDonXuat o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDonXuat> selectAll() {
        ArrayList<HoaDonXuat> listHDX = new ArrayList<HoaDonXuat>();
        String SQL = "select * from EXPORTINVOICE_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listHDX.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDonXuat a = new HoaDonXuat(
                        rs.getString("idExpInv"),
                        rs.getDate("dateExp").toString(),
                        rs.getInt("idCus"),
                        rs.getString("idEmp")
                );
                listHDX.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listHDX;
    }

    @Override
    public ArrayList<HoaDonXuat> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
