/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exceptions.LoginException;
import datasource.AccountMapper;
import datasource.AccountMapperInterface;
import datasource.CupcakeMapper;
import datasource.CupcakeMapperInterface;
import datasource.InvoiceMapper;
import datasource.InvoiceMapperInterface;
import model.Account;

/**
 *
 * @author allan
 */
public class Controller {
    private InvoiceMapperInterface im = new InvoiceMapper();
    private CupcakeMapperInterface cm = new CupcakeMapper();
    private AccountMapperInterface am = new AccountMapper();

    public Controller() {
    }
    
    public Account login(String email, String password){
        Account account = null;
        try{
            account = am.login(email, password);
         }catch(LoginException ex){
             account = null;
             System.out.println("CATCHED");
             System.out.println(email + " pass " + password + " " + ex.getMessage());
         }
        return account;
    }
    public Account register(String email, String password){
        Account account = null;
        try{
            am.createAccount(new Account("Test", 12345678, email, password, "customer", 0.00));
            account = am.getAccount(am.getHighestAccountID());
        }catch(Exception ex){
            account = null;
        }
        return account;
    }
}
