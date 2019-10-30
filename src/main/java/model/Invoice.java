/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author allan
 */
public class Invoice {

    private int ID;
    private int CustomerID;
    private double price;
    private Timestamp time;
    private ArrayList<OrderLine> orderlines;

    public Invoice(int ID, int CustomerID, double price, Timestamp time, ArrayList<OrderLine> orderlines) {
        this.ID = ID;
        this.CustomerID = CustomerID;
        this.price = price;
        this.time = time;
        this.orderlines = orderlines;
    }

    public Invoice(int CustomerID, double price, Timestamp time, ArrayList<OrderLine> orderlines) {
        this.CustomerID = CustomerID;
        this.price = price;
        this.time = time;
        this.orderlines = orderlines;
    }

    public int getID() {
        return ID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getTime() {
        return time;
    }

    public ArrayList<OrderLine> getOrderlines() {
        return orderlines;
    }

}
