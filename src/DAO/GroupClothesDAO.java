/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.Arena;
import ClassConstructor.GroupClothes;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class GroupClothesDAO implements DAOInterface<GroupClothes> {

    public static GroupClothesDAO getInstance() {
        return new GroupClothesDAO();
    }

    @Override
    public boolean Add(GroupClothes o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO GROUPCLOTHES_T(idGroup, nameGroup)" + "VALUES(?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, o.getID());
            pstm.setString(2, o.getName());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Group information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(GroupClothes o) {
        Connection conn = connectionDB.getConnection();
        String sql = "delete from GROUPCLOTHES_T where idGroup = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Group information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Update(GroupClothes o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update GROUPCLOTHES_T set nameGroup = ? where idGroup = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getName());
            pstm.setInt(2, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Group information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<GroupClothes> selectAll() {
        ArrayList<GroupClothes> listGroup = new ArrayList<GroupClothes>();
        String SQL = "select * from GROUPCLOTHES_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listGroup.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                GroupClothes a = new GroupClothes(
                        rs.getInt("idGroup"),
                        rs.getString("nameGroup")
                );
                listGroup.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listGroup;
    }

    @Override
    public ArrayList<GroupClothes> selectByCondition(String condition) {
        ArrayList<GroupClothes> listGroup = new ArrayList<GroupClothes>();
        String SQL = "select * from GROUPCLOTHES_T where '" + condition + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        listGroup.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                GroupClothes a = new GroupClothes(
                        rs.getInt("idGroup"),
                        rs.getString("nameGroup")
                );
                listGroup.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listGroup;
    }

}
