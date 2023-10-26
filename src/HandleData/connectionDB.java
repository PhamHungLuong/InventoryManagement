/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HandleData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author QUÂN BÙI
 */
public class connectionDB {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=DoAn_QuanLyKho;encrypt=false";
            String USER_NAME = "sa";
            String PASSWORD = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect success");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }


    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                System.out.println("Close Connect");
                conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = connectionDB.getConnection();
    }
}
