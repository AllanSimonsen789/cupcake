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

/**
 *
 * @author allan
 */
public class RegisterCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            controller.register(email, password2);
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            session.setAttribute("role", user.getRole());
//            return user.getRole() + "page";
              return "shop";
        } else {
            request.setAttribute("error", "the two passwords did not match");
            return "login";
        }
    }
    
}
