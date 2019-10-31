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
public class RegisterCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if (password1.equals(password2)) {
                Account account = controller.register(request.getParameter("name"), request.getParameter("phone"), request.getParameter("email"), password2);
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                session.setAttribute("role", account.getRole());
                if (account.getRole().equals("Admin")) {
                    return "admin";
                } else if (account.getRole().equals("customer")) {
                    request.setAttribute("tops", controller.getAllTops());
                    request.setAttribute("bottoms", controller.getAllBottoms());
                    return "shop";
                }
            } else {
                throw new LoginException("The two passwords did not match");
            }
        } catch (LoginException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        return "register";

    }

}
