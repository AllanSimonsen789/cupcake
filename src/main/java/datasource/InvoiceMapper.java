/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Invoice;
import model.OrderLine;

/**
 *
 * @author allan
 */
public class InvoiceMapper implements InvoiceMapperInterface {

    public void makeInvoice(Invoice invoice) {
        String sql = "INSERT INTO cupcakes.invoices (customerID, price, time) VALUES(?, ?, ?);";
        String sqlordreline = "INSERT INTO cupcakes.orderLines VALUES(?,?,?,?);";
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, invoice.getCustomerID());
            pstmt.setDouble(2, invoice.getPrice());
            pstmt.setTimestamp(3, invoice.getTime());
            pstmt.executeUpdate();

            for (OrderLine orderLine : invoice.getOrderlines()) {
                pstmt = conn.prepareStatement(sqlordreline);
                int id = getHighestID();
                pstmt.setInt(1, id);
                pstmt.setInt(2, orderLine.getTopID());
                pstmt.setInt(3, orderLine.getBottomID());
                pstmt.setInt(4, orderLine.getQty());
                pstmt.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println("InvoiceMapper - MakeInvoice" + ex.getMessage());

        }

    }

    public int getHighestID() {
        String sql = "SELECT * FROM cupcakes.invoices ORDER BY ID DESC LIMIT 0, 1";
        int returnInt = 0;
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                returnInt = 0;
            } else {
                res.next();
                returnInt = res.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("InvoiceMapper - getHighestID" + ex.getMessage());

        }
        return returnInt;
    }

    public Invoice getInvoiceFromID(int id) {
        String sql = "SELECT * FROM cupcakes.invoices WHERE ID = ?;";
        String sql2 = "SELECT * FROM cupcakes.orderlines WHERE invoiceID = ?;";
        Invoice invoice = null;
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "" + id);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                return null;
            } else {
                res.next();
                Connection conn2 = DB.getConnection();
                PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
                pstmt2.setString(1, "" + id);
                ResultSet res2 = pstmt2.executeQuery();
                ArrayList<OrderLine> ordreLines = new ArrayList<>();
                if (res2 == null) {
                    ordreLines = null;
                } else {
                    while (res2.next()) {
                        ordreLines.add(new OrderLine(res2.getInt(1), res2.getInt(2), res2.getInt(3), res2.getInt(4)));
                    }
                }
                invoice = new Invoice(res.getInt("ID"), res.getInt("customerID"), res.getDouble("price"), res.getTimestamp("time"), ordreLines);
            }
        } catch (SQLException ex) {
            System.out.println("Invoicemapper - getinvoicefromID" + ex.getMessage());

        }

        return invoice;
    }

    public ArrayList<Invoice> getAllInvoices() {
        String sql = "SELECT * FROM cupcakes.invoices;";
        String sql2 = "SELECT * FROM cupcakes.orderlines WHERE invoiceID = ?;";
        ArrayList<Invoice> orderList = new ArrayList<>();
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                return null;
            } else {
                //get tops
                //get bottoms
                while (res.next()) {
                    Connection conn2 = DB.getConnection();
                    PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
                    pstmt2.setString(1, "" + res.getInt("ID"));
                    ResultSet res2 = pstmt2.executeQuery();
                    ArrayList<OrderLine> ordreLines = new ArrayList<>();
                    if (res2 == null) {
                        ordreLines = null;
                    } else {
                        while (res2.next()) {
                            ordreLines.add(new OrderLine(res2.getInt(1), res2.getInt(2), res2.getInt(3), res2.getInt(4)));
                        }
                    }
                    orderList.add(new Invoice(res.getInt(1), res.getInt(2), res.getDouble(3), res.getTimestamp(4), ordreLines));
                }
            }
        } catch (SQLException ex) {
            System.out.println("InvoiceMapper - getAllINvoices" + ex.getMessage());

        }

        return orderList;
    }

    @Override
    public ArrayList<Invoice> getInvoicesWithCustomerID(int customerID) {
        String sql = "SELECT * FROM invoices WHERE customerID = ?;";
        String sql2 = "SELECT * FROM cupcakes.orderlines WHERE invoiceID = ?;";
        ArrayList<Invoice> orderList = new ArrayList<>();
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerID);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                return null;
            } else {
                //get tops
                //get bottoms
                while (res.next()) {
                    Connection conn2 = DB.getConnection();
                    PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
                    pstmt2.setString(1, "" + res.getInt("ID"));
                    ResultSet res2 = pstmt2.executeQuery();
                    ArrayList<OrderLine> ordreLines = new ArrayList<>();
                    if (res2 == null) {
                        ordreLines = null;
                    } else {
                        while (res2.next()) {
                            ordreLines.add(new OrderLine(res2.getInt(1), res2.getInt(2), res2.getInt(3), res2.getInt(4)));
                        }
                    }
                    orderList.add(new Invoice(res.getInt(1), res.getInt(2), res.getDouble(3), res.getTimestamp(4), ordreLines));
                }
            }
        } catch (SQLException ex) {
            System.out.println("InvoiceMapper - GetAllInvoicesWithCustomerID" + ex.getMessage());

        }

        return orderList;
    }

}
