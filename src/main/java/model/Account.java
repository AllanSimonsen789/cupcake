package model;

/**
 *
 * @author Malthe
 */
public class Account {

    private int ID;
    private String name;
    private int phone;
    private String email;
    private String password;
    private String role;
    private double balance;

    public Account(String name, int phone, String email, String password, String role, double balance) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public Account(int ID, String name, int phone, String email, String password, String role, double balance) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password + ", role=" + role + ", balance=" + balance + '}';
    }

}
