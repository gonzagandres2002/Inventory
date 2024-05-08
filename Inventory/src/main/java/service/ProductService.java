/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbo.ConnectDB;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ProductService {

    public ProductService() {
    }

    private final ConnectDB conn = new ConnectDB();
    private final Connection connection = conn.Connect();

    public Connection getConnection() {
        return connection;
    }

    public void InsertRecordStoredProcedure(String name, Double price, Integer quantity) {

        if (price > 0 && price < 999999 && quantity > 0 && quantity < 999999) {
            try {
                CallableStatement proc = connection.prepareCall("{call InsertNewItem(?, ?, ?)}");
                proc.setString(1, name);
                proc.setBigDecimal(2, new BigDecimal(price));
                proc.setInt(3, quantity);
                proc.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Incorrect Format: \n" + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Price or quantity out of range");
        }
    }

    public void deleteRecord(String id) {
        try {
            String sql = "delete from items where ItemID = " + id;
            Statement st;
            st = connection.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "The Record has been eliminated successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateItem(String name, Double price, Integer quantity, String id) {

        if (price > 0 && price < 999999 && quantity > 0 && quantity < 999999) {
            try {

                String sql = "UPDATE Items SET Name = '" + name + "', Price = " + price
                        + ", Quantity = " + quantity + " WHERE ItemID = " + id + ";";

                Statement st;
                st = connection.createStatement();
                int rs = st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "The Record has been updated");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Incorrect Format: \n" + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Price or quantity out of range");
        }

    }
}
