/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author allan
 */
public class InvoiceMapper {
    
    public Invoice getInvoiceFromID(int id){
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
                ResultSet res2 = null;//pstmt2.executeQuery();
                ArrayList<OrderLine> ordreLines = new ArrayList<>();
                if (res2 == null) {
                    ordreLines = null;
                } else {
                    while (res2.next()) {
                    }
                }
                invoice = new Invoice(res.getInt("ID"),res.getInt("customerID") ,res.getDouble("price"), res.getTimestamp("tid"), ordreLines);
            }
        } catch (SQLException ex) {
            System.out.println("Invoicemapper - getinvoicefromID" + ex.getMessage());

        }

        return invoice;
    }
    
}
