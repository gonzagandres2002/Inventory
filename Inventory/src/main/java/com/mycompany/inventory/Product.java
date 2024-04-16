/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory;

import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class Product {

    private final String name;
    private final int quantity;
    private final double price;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Product(JTextField name, JTextField price, JTextField quantity) {
        this.name = name.getText();
        this.price = Double.valueOf(price.getText());
        this.quantity = Integer.valueOf(quantity.getText());
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString(){
        return this.name + ": " + this.quantity;
    }
}
