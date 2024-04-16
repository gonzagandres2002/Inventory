/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ConnectDB {
    public static Connection conn;
    public String user = "sqluser"; 
//real SQL user using SQL Server Authentication with write and read permissons
    public String pass = "1234";
    public String url = "jdbc:sqlserver://localhost:1433;databaseName"
            + "=InventoryDB;trustServerCertificate=true"; 
    //Use trustServerCertificate=true if you don't have a SQL Server paid version
    public Connection Connect(){
        conn = null;
        
        try{
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            if(conn!=null){
               JOptionPane.showMessageDialog(null, "Connected!"); 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        return conn;
    }
} 
