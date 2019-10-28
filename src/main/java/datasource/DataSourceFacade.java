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

}
