/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.Clothes;
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
public class ClothesDAO implements DAOInterface<Clothes> {

    public static ClothesDAO getInstance() {
        return new ClothesDAO();
    }

    @Override
    public boolean Add(Clothes o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO CLOTHES_T(idClothes, nameClothes, sizeClothes, colorClothes, priceClothes,  priceImpClothes, currentQuantityClothes, idGroup , idArea)" + "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, o.getId());
            pstm.setString(2, o.getTenSP());
            pstm.setString(3, o.getSize());
            pstm.setString(4, o.getMau());
            pstm.setLong(5, o.getGiaBan());
            pstm.setLong(6, o.getGiaGoc());
            pstm.setInt(7, o.getSLHienTai());
            pstm.setInt(8, o.getIdNhom());
            pstm.setInt(9, o.getIdDistrict());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer CLothes information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(Clothes o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "delete from CLOTHES_T where idClothes = ?";
//        String sql = "update CLOTHES_T set activate = 'Out of stock' where idClothes = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, o.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Clothes information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Update(Clothes o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update CLOTHES_T set nameClothes = ?, sizeClothes = ?, colorClothes = ?, priceClothes = ?, priceImpClothes = ?, currentQuantityClothes = ?,idGroup = ?, idArea = ?  where idClothes = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getTenSP());
            pstm.setString(2, o.getSize());
            pstm.setString(3, o.getMau());
            pstm.setLong(4, o.getGiaBan());
            pstm.setLong(5, o.getGiaGoc());
            pstm.setInt(6, o.getSLHienTai());
            pstm.setInt(7, o.getIdNhom());
            pstm.setInt(8, o.getIdDistrict());
            pstm.setInt(9, o.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Clothes information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<Clothes> selectAll() {
        ArrayList<Clothes> listClothes = new ArrayList<Clothes>();
        String SQL = "select * from CLOTHES_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listClothes.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Clothes cl = new Clothes(
                        rs.getInt("idClothes"),
                        rs.getString("nameClothes"),
                        rs.getString("sizeClothes"),
                        rs.getString("colorClothes"),
                        rs.getInt("priceClothes"),
                        rs.getInt("priceImpClothes"),
                        rs.getInt("currentQuantityClothes"),
                        rs.getInt("idArea"),
                        rs.getInt("idGroup")
                );
                listClothes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listClothes;
    }

    @Override
    public ArrayList<Clothes> selectByCondition(String condition) {
        ArrayList<Clothes> listClothes = new ArrayList<Clothes>();
        String SQL = "select * from CLOTHES_T where activate = '" + condition + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        listClothes.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Clothes cl = new Clothes(
                        rs.getInt("idClothes"),
                        rs.getString("nameClothes"),
                        rs.getString("sizeClothes"),
                        rs.getString("colorClothes"),
                        rs.getInt("priceClothes"),
                        rs.getInt("priceImpClothes"),
                        rs.getInt("currentQuantity"),
                        rs.getInt("idArea"),
                        rs.getInt("idGroup")
                );
                listClothes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listClothes;
    }

}
