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
 * @author allan
 */
public class AddFundsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        controller.addFunds(Integer.parseInt(request.getParameter("accountid")), Integer.parseInt(request.getParameter("funds")));
        request.setAttribute("invoices", controller.getAllInvoices());
        request.setAttribute("customers", controller.getAllAccounts());
        return "admin";
    }

}
