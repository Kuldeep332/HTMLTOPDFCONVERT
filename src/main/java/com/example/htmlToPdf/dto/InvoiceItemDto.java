package com.example.htmlToPdf.dto;

public class InvoiceItemDto {
    private String itemName;
    private int quantity;
    private double price;
    private double totalPrice;

    // Constructors, getters, and setters
    // Constructor
    public InvoiceItemDto(String itemName, int quantity, double price, double totalPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
