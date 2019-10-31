/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import Exceptions.LoginException;
import java.util.ArrayList;
import model.Account;
import model.Bottom;
import model.Invoice;
import model.Top;

/**
 *
 * @author allan
 */
public class DataSourceFacade implements DataSourceFacadeInterface {

    private InvoiceMapperInterface im = new InvoiceMapper();
    private CupcakeMapperInterface cm = new CupcakeMapper();
    private AccountMapperInterface am = new AccountMapper();

    @Override
    public Account login(String email, String password) throws LoginException {
        return am.login(email, password);
    }

    @Override
    public Account register(Account account) throws LoginException {
        am.createAccount(account);
        return am.getAccount(am.getHighestAccountID());
    }

    @Override
    public ArrayList<Top> getAllTops() {
        return cm.getTops();
    }

    @Override
    public ArrayList<Bottom> getAllBottoms() {
        return cm.getBottoms();
    }

    @Override
    public ArrayList<Invoice> getAllInvoices() {
        return im.getAllInvoices();
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        return am.getAllAccounts();
    }

    @Override
    public void addFunds(int accountid, int funds) {
        am.addFunds(accountid, funds);
    }

    @Override
    public ArrayList<Invoice> getInvoiceWithCustomerID(int customerID) {
        return im.getInvoicesWithCustomerID(customerID);
    }

    @Override
    public Invoice getAllInvoiceWithID(int invoiceid) {
        return im.getInvoiceFromID(invoiceid);
    }

    @Override
    public void makeInvoice(Invoice invoice) {
        im.makeInvoice(invoice);
    }

    @Override
    public void removeFunds(int id, double invoiceprice) {
        am.removeFunds(id, invoiceprice);
    }

    @Override
    public Account getAccountWithID(int id) {
        return am.getAccount(id);
    }

    @Override
    public int getHighestID() {
        return im.getHighestID();
    }
}
