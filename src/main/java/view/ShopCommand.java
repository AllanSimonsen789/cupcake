/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Exceptions.ShopException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author allan
 */
public class ShopCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            request.setAttribute("tops", controller.getAllTops());
            request.setAttribute("bottoms", controller.getAllBottoms());
            
        } catch (ShopException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        return "login";

    }

}
