/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author allan
 */
public class OrderLine {

    private int invoiceID;
    private int topID;
    private int bottomID;
    private int qty;

    public OrderLine(int invoiceID, int topID, int bottomID, int qty) {
        this.invoiceID = invoiceID;
        this.topID = topID;
        this.bottomID = bottomID;
        this.qty = qty;
    }

    public OrderLine(int topID, int bottomID, int qty) {
        this.topID = topID;
        this.bottomID = bottomID;
        this.qty = qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public int getTopID() {
        return topID;
    }

    public int getBottomID() {
        return bottomID;
    }

    public int getQty() {
        return qty;
    }

}
