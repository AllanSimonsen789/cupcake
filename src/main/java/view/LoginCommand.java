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
public class LoginCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        Account account = controller.login(request.getParameter("email"), request.getParameter("password"));
        if(account != null){
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            session.setAttribute("role", account.getRole());
            if(account.getRole().equals("Admin")){
                return "admin";
            }else if ( account.getRole().equals("customer")){
                return "shop";
            }
        }
        request.setAttribute("error", "Email eller kodeord var forkert, prøv igen");
        return "login";
    }
    
}
