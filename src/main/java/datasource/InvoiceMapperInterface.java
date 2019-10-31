/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.util.ArrayList;
import model.Invoice;

/**
 *
 * @author allan
 */
public interface InvoiceMapperInterface {

    public void makeInvoice(Invoice invoice);

    public int getHighestID();

    public Invoice getInvoiceFromID(int id);

    public ArrayList<Invoice> getAllInvoices();

    public ArrayList<Invoice> getInvoicesWithCustomerID(int customerID);

}
