/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClassConstructor.Arena;
import HandleData.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public class AreaDAO implements DAOInterface<Arena> {

    public static AreaDAO getInstance() {
        return new AreaDAO();
    }

    @Override
    public boolean Add(Arena o) {
        Connection conn = connectionDB.getConnection();
        String SQL = "INSERT INTO AREA_T(idArea, nameArea)" + "VALUES(?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, o.getID());
            pstm.setString(2, o.getName());
            return pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Area information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Delete(Arena o) {
        Connection conn = connectionDB.getConnection();
        String sql = "delete from AREA_T where idArea = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Area information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean Update(Arena o) {
        Connection conn = connectionDB.getConnection();
        String sql = "update AREA_T set nameArea = ? where idArea = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, o.getName());
            pstm.setInt(2, o.getID());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't writer Area information");
        } finally {
            connectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public ArrayList<Arena> selectAll() {
        ArrayList<Arena> listArea = new ArrayList<Arena>();
        String SQL = "select * from AREA_T";
        Connection conn = null;
        PreparedStatement pstm = null;
        listArea.clear();
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Arena a = new Arena(
                        rs.getInt("idArea"),
                        rs.getString("nameArea")
                );
                listArea.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listArea;
    }

    @Override
    public ArrayList<Arena> selectByCondition(String condition) {
        ArrayList<Arena> listArea = new ArrayList<Arena>();
        String SQL = "select * from AREA_T where activate = '" + condition + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = connectionDB.getConnection();
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Arena a = new Arena(
                        rs.getInt("idArea"),
                        rs.getString("nameArea")
                );
                listArea.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(conn);
        }
        return listArea;
    }

}
