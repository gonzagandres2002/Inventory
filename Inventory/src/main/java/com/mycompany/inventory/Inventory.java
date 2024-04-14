/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.inventory;

/**
 *
 * @author andre
 */
public class Inventory {

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product product1 = new Product("Product 1", 10, 10.99);
        Product product2 = new Product("Product 2", 5, 15.99);

        manager.addProduct(product1);
        manager.addProduct(product2);

        System.out.println("All products: " + manager.getAllProducts());

        Product product3 = manager.getProduct("Product 1");
        if (product3 != null) {
            product3.setQuantity(8);
            manager.updateProductQuantity(product3.getName(), product3.getQuantity());
        }

        System.out.println("All products: " + manager.getAllProducts());
    }
}