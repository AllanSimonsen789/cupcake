package view;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.OrderLine;

/**
 *
 * @author Malthe
 */
public class PurchaseConfirmationPageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("tops", controller.getAllTops());
        request.setAttribute("bottoms", controller.getAllBottoms());
        if (((Account) session.getAttribute("account")).getBalance() >= Double.parseDouble(request.getParameter("totalprice"))) {
            controller.removeFunds(((Account) session.getAttribute("account")).getID(), Double.parseDouble(request.getParameter("totalprice")));
            controller.makeInvoice(((Account) session.getAttribute("account")).getID(), Double.parseDouble(request.getParameter("totalprice")), Timestamp.valueOf(LocalDateTime.now()), (ArrayList<OrderLine>) session.getAttribute("shoppingcart"));
            session.setAttribute("account", controller.getAccountWithID(((Account)session.getAttribute("account")).getID()git status
                    ));
            return "purchaseConfirmation";
        } else {
            session.removeAttribute("shoppingcart");
            return "products";
        }

    }

}
