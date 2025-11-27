package TP3.EX1.base;

import java.util.ArrayList;

public class Order {
    protected Customer customer;
    protected ArrayList<Product> products;
    protected double totalPrice;
    protected OrderStatus status;

    public Order(Customer customer, ArrayList<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (Product prodect : this.products) {
            total += prodect.getPrice();
        }

        totalPrice = total;
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
