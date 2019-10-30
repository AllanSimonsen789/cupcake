/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import model.Account;
import Exceptions.LoginException;
import java.util.ArrayList;

/**
 *
 * @author Malthe
 */
public interface AccountMapperInterface {
    
    public Account login(String email, String password) throws LoginException;
    
    public void createAccount(Account account)throws LoginException;
    
    public Account getAccount(int id);
    
    public int getHighestAccountID();
    
    public ArrayList<Account> getAllAccounts();

    public void addFunds(int accountid, int funds);

    public void removeFunds(int id, double invoiceprice);
       
}
