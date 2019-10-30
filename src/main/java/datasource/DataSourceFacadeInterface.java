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
public interface DataSourceFacadeInterface {
    
    public Account login(String email, String password)throws LoginException;
    
    public Account register(Account account)throws LoginException;
    
    public ArrayList<Top> getAllTops();
    
    public ArrayList<Bottom> getAllBottoms();

    public ArrayList<Invoice> getAllInvoices();
    
    public ArrayList<Account> getAllAccounts();

    public void addFunds(int accountid, int funds);
}
