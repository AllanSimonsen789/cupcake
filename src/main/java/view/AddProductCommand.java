/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderLine;

/**
 *
 * @author allan
 */
public class AddProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<OrderLine> shoppingCart = new ArrayList<>();
        if (session.getAttribute("shoppingcart") != null) {
            shoppingCart = (ArrayList<OrderLine>) session.getAttribute("shoppingcart");
        }
        shoppingCart.add(new OrderLine(Integer.parseInt(request.getParameter("top")), Integer.parseInt(request.getParameter("bottom")), Integer.parseInt(request.getParameter("qty"))));
        session.setAttribute("shoppingcart", shoppingCart);
        request.setAttribute("tops", controller.getAllTops());
        request.setAttribute("bottoms", controller.getAllBottoms());
        return "products";

    }

}
