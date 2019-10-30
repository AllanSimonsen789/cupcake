package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import Exceptions.LoginException;
import java.util.ArrayList;

/**
 *
 * @author malthe
 */
public class AccountMapper implements AccountMapperInterface {

    @Override
    public Account login(String email, String password) throws LoginException {
        try {
            Connection con = DB.getConnection();
            String SQL = "SELECT * FROM cupcakes.accounts WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int phone = res.getInt("phone");
                String role = res.getString("role");
                double balance = res.getInt("balance");
                Account user = new Account(id, name, phone, email, password, role, balance);
                if (user == null) {
                    System.out.println("null in accountmapper");
                }
                return user;
            } else {
                throw new LoginException("Could not validate user.");
            }
        } catch (SQLException ex) {
            try {
                throw new LoginException(ex.getMessage());
            } catch (LoginException ex1) {
                Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (LoginException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void createAccount(Account account) throws LoginException {
        String sql = "INSERT INTO cupcakes.accounts (name, phone, email, password, role, balance) VALUES (?,?,?,?,?,0.00)";
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "" + account.getName());
            pstmt.setString(2, "" + account.getPhone());
            pstmt.setString(3, "" + account.getEmail());
            pstmt.setString(4, "" + account.getPassword());
            pstmt.setString(5, "" + account.getRole());
            pstmt.executeUpdate();
            ResultSet ids = pstmt.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            account.setID(id);

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new LoginException("Der findes allerede en bruger med denne email addresse");
            } else {
                System.out.println(ex.getMessage());
            }
        }

    }

    @Override
    public Account getAccount(int id) {
        String sql = "SELECT * FROM cupcakes.accounts WHERE ID = ?;";
        Account account = null;

        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "" + id);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                return null;
            } else {
                res.next();
                account = new Account(res.getInt("ID"), res.getString("name"), res.getInt("phone"), res.getString("email"), res.getString("password"), res.getString("role"), res.getDouble("balance"));
            }
        } catch (SQLException ex) {
            System.out.println("AccountMapper - getAccount" + ex.getMessage());
        }
        return account;
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        String sql = "SELECT * FROM accounts WHERE role = ? ;";
        ArrayList<Account> accountlist = new ArrayList<>();

        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "customer");
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                return null;
            } else {
                while (res.next()) {
                    accountlist.add(new Account(res.getInt("ID"), res.getString("name"), res.getInt("phone"), res.getString("email"), res.getString("password"), res.getString("role"), res.getDouble("balance")));
                }
            }
        } catch (SQLException ex) {
            System.out.println("AccountMapper - getAllAccounts" + ex.getMessage());
        }
        return accountlist;
    }

    @Override
    public int getHighestAccountID() {
        String sql = "SELECT * FROM cupcakes.accounts ORDER BY ID DESC LIMIT 0, 1";
        int returnInt = 0;
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {

                returnInt = 0;
            } else {
                res.next();
                returnInt = res.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("AccountMapper - getHighestID" + ex.getMessage());

        }
        return returnInt;
    }

    @Override
    public void addFunds(int accountid, int funds) {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE ID = ?;";
        try {

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "" + funds );
            pstmt.setString(2, "" + accountid);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("AccountMapper - Addfunds" + ex.getMessage());

        }
    }

}
