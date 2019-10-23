/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Malthe
 */
public interface AccountMapperInterface {
    
    public Account login(String email, String password) throws LoginException;
    
    public void createAccount(Account account);
    
    public Account getAccount(int id);
    
    public int getHighestAccountID();
       
}
