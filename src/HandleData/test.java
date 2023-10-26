/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HandleData;

import java.sql.Connection;

/**
 *
 * @author QUÂN BÙI
 */
public class test {
    public static void main(String[] args) {
         Connection connection = connectionDB.getConnection();
         connectionDB.closeConnection(connection);
    }
    
}
