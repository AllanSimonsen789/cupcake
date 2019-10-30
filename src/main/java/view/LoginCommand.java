/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author allan
 */
public class LoginCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = controller.login(request.getParameter("email"), request.getParameter("password"));
            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                if (account == null) {
                    System.out.println("null");
                }
                System.out.println(account.toString());
                session.setAttribute("role", account.getRole());
                if (account.getRole().equals("Admin")) {
                    request.setAttribute("invoices", controller.getAllInvoices());
                    request.setAttribute("customers", controller.getAllAccounts());
                    return "admin";
                }else if (account.getRole().equals("customer")) {
                    request.setAttribute("tops", controller.getAllTops());
                    request.setAttribute("bottoms", controller.getAllBottoms());
                    return "products";
                }
            } else {
                throw new LoginException("Email eller kodeord var forkert, prøv igen");
            }

        } catch (LoginException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        return "login";
    }

}
