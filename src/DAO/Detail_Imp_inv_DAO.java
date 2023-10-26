/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.CTDS;
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
public class Detail_Imp_inv_DAO implements DAOInterface<CTDS> {

    public static Detail_Imp_inv_DAO getInstance() {
        return new Detail_Imp_inv_DAO();
    }

    @Override
    public boolean Add(CTDS o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO DETAIL_IMP_INV_T(idImpInv, idClothes, quantityDetail)" + "VALUES(?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, o.getIdHD());
            pstm.setInt(2, o.getIdClothes());
            pstm.setInt(3, o.getNumberCount());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Detail information");
        }finally{
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(CTDS o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(CTDS o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CTDS> selectAll() {
        ArrayList<CTDS> listCTDS = new ArrayList<CTDS>();
        String SQL = "select * from DETAIL_IMP_INV_T ";
        Connection conn = null;
        PreparedStatement pstm = null;
        listCTDS.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CTDS a = new CTDS(
                        rs.getString("idImpInv"),
                        rs.getInt("idClothes"),
                        rs.getInt("quantityDetail")
                );
                listCTDS.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listCTDS;
    }

    @Override
    public ArrayList<CTDS> selectByCondition(String condition) {

        return null;

    }

}
