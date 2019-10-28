/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import Exceptions.LoginException;
import model.Account;

/**
 *
 * @author allan
 */
public interface DataSourceFacadeInterface {
    
    public Account login(String email, String password)throws LoginException;
    
    public Account register(Account account)throws LoginException;
}
