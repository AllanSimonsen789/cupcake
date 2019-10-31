/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exceptions.LoginException;
import Exceptions.ShopException;
import datasource.DataSourceFacade;
import datasource.DataSourceFacadeInterface;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Account;
import model.Bottom;
import model.Invoice;
import model.OrderLine;
import model.Top;

/**
 *
 * @author allan
 */
public class Controller {

    private DataSourceFacadeInterface DSfacade = new DataSourceFacade();

    public Controller() {
    }

    public Account login(String email, String password) throws LoginException {
        return DSfacade.login(email, password);
    }

    public Account register(String name, String phone, String email, String password) throws LoginException {
        return DSfacade.register(new Account(name, Integer.parseInt(phone), email, password, "customer", 0.00));
    }

    public ArrayList<Top> getAllTops() {
        return DSfacade.getAllTops();
    }

    public ArrayList<Bottom> getAllBottoms() {
        return DSfacade.getAllBottoms();
    }

    public ArrayList<Invoice> getAllInvoices() {
        return DSfacade.getAllInvoices();
    }

    public ArrayList<Account> getAllAccounts() {
        return DSfacade.getAllAccounts();
    }

    public void addFunds(int accountid, int funds) {
        DSfacade.addFunds(accountid, funds);
    }

    public ArrayList<Invoice> getInvoicesWithCustomerID(int customerID) {
        return DSfacade.getInvoiceWithCustomerID(customerID);
    }

    public Invoice getInvoiceFromId(int invoiceid) {
        return DSfacade.getAllInvoiceWithID(invoiceid);
    }
    
    public int getHighestInvoiceId() {
        return DSfacade.getHighestID();
    }

    public void makeInvoice(int id, double price, Timestamp time, ArrayList<OrderLine> orderLines) {
        DSfacade.makeInvoice(new Invoice(id, price, time, orderLines));
    }

    public void removeFunds(int id, double invoiceprice) {
        DSfacade.removeFunds(id, invoiceprice);
    }

    public Account getAccountWithID(int id) {
        return DSfacade.getAccountWithID(id);
    }
}
