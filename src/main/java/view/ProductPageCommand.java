/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class ProductPageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        
        request.setAttribute("tops", controller.getAllTops());
        request.setAttribute("bottoms", controller.getAllBottoms());
        request.removeAttribute("shoppingcart");
        return "products";
    }
    
}
