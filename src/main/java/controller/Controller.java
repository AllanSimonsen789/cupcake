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
import java.util.ArrayList;
import model.Account;
import model.Bottom;
import model.Invoice;
import model.Top;

/**
 *
 * @author allan
 */
public class Controller {
    private DataSourceFacadeInterface DSfacade = new DataSourceFacade();
    
    public Controller() {
    }
    
    public Account login(String email, String password)throws LoginException{
        return DSfacade.login(email, password);
    }
    public Account register(String name, String phone, String email, String password)throws LoginException{
        return DSfacade.register(new Account(name, Integer.parseInt(phone), email, password, "customer" ,0.00));
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
}
