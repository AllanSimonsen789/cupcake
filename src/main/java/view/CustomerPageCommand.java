package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Malthe
 */
public class CustomerPageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("invoices", controller.getInvoicesWithCustomerID(((Account) session.getAttribute("account")).getID()));
        return "customer";
    }

}
