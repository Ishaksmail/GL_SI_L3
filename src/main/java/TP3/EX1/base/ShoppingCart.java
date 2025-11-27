package TP3.EX1.base;

import java.util.ArrayList;

public class ShoppingCart {

    public ArrayList<Product> products;

    public ShoppingCart(ArrayList<Product> products) {
        this.products = products;
    }

    public ShoppingCart() {

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.removeIf(item -> item == product);
    }

}
