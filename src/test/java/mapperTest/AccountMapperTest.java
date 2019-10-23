/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperTest;

import model.Account;
import model.AccountMapper;
import model.LoginException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malthe
 */
// Re-run SQL script before testing!
// Re-run SQL script before testing!
// Re-run SQL script before testing!
public class AccountMapperTest {
        private final AccountMapper am = new AccountMapper();
    
    @Test
    public void getAccountTest() {
        Account account = am.getAccount(4);
        assertEquals(4, account.getID());
    }
    
    @Test
    public void loginTest() throws LoginException {
        Account account = am.login("admin@cupcake.dk", "admin123");
        assertEquals(1, account.getID());
        assertEquals("Casper Bo Woschek", account.getName());
        assertEquals(12345678, account.getPhone());
        assertEquals("admin@cupcake.dk", account.getEmail());
        assertEquals("admin123", account.getPassword());
        assertEquals("Admin", account.getRole());
        assertNotEquals(1, account.getBalance());
    }
    
    @Test
    public void createAccountTest() {
        Account account = new Account("Arthur Fleck", 66666666, "joker@hotmail.com", "wanttohearajoke+", "customer", 0.00);
        am.createAccount(account);
        assertEquals(11, am.getHighestAccountID());
    }
    
}
