package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class PurchaseConfirmationPageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("tops", controller.getAllTops());
        request.setAttribute("bottoms", controller.getAllBottoms());
        request.removeAttribute("shoppingcart");
        return "purchaseConfirmation";
    }
    
}
