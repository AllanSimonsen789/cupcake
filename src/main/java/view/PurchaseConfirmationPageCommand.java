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
        ArrayList<OrderLine> orderlines = (ArrayList<OrderLine>) session.getAttribute("shoppingcart");
        Account account = (Account) session.getAttribute("account");
        Double totalprice = Double.parseDouble(request.getParameter("totalprice"));
        if ( orderlines != null && orderlines.size() > 0 && account.getBalance() >=  totalprice) {
            controller.removeFunds(account.getID(), totalprice);
            controller.makeInvoice(account.getID(), totalprice, Timestamp.valueOf(LocalDateTime.now()), orderlines);
            request.setAttribute("id", controller.getHighestInvoiceId());
            session.setAttribute("account", controller.getAccountWithID(account.getID()));
            return "purchaseConfirmation";
        } else {
            session.removeAttribute("shoppingcart");
            return "products";
        }

    }

}
