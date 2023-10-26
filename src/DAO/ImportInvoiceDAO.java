/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.Arena;
import ClassConstructor.HoaDonNhap;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class ImportInvoiceDAO implements DAOInterface<HoaDonNhap> {

    public static ImportInvoiceDAO getInstance() {
        return new ImportInvoiceDAO();
    }

    @Override
    public boolean Add(HoaDonNhap o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO IMPORTINVOICE_T(idImpInv, idSup, idEmp, dateImp)" + "VALUES(?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, o.getID());
            pstm.setInt(2, o.getNCCID());
            pstm.setString(3, o.getStaff());
            pstm.setString(4, o.getDate());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Imp information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(HoaDonNhap o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(HoaDonNhap o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDonNhap> selectAll() {
        ArrayList<HoaDonNhap> listHDN = new ArrayList<HoaDonNhap>();
        String SQL = "select * from IMPORTINVOICE_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listHDN.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDonNhap a = new HoaDonNhap(
                        rs.getString("idImpInv"),
                        rs.getDate("dateImp").toString(),
                        rs.getInt("idSup"),
                        rs.getString("idEmp")
                );
                listHDN.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listHDN;
    }

    @Override
    public ArrayList<HoaDonNhap> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
