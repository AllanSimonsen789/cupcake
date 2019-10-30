package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class InvoicePageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("invoice", controller.getInvoiceFromId(Integer.parseInt(request.getParameter("invoiceid"))));
        return "invoice";
    }
    
}
