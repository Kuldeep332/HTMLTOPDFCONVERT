package com.example.htmlToPdf.dto;

import java.util.List;

public class InvoiceDto {
    private String name;
    private String address;
    private String number;
    private String date;
//    private List<InvoiceItemDto> items;

    // Constructors, getters, and setters
    // Constructor
    public InvoiceDto(String name, String address, String number, String date, List<InvoiceItemDto> items) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.date = date;
//        this.items = items;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
//
//    public List<InvoiceItemDto> getItems() {
//        return items;
//    }
//
//    public void setItems(List<InvoiceItemDto> items) {
//        this.items = items;
//    }
}
