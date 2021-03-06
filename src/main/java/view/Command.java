/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Exceptions.InvoiceMapperException;
import Exceptions.LoginException;
import controller.Controller;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
public abstract class Command {

    private static HashMap<String, Command> commandList;
    protected Controller controller = new Controller();

    private static void initCommands() {
        commandList = new HashMap<>();
        commandList.put("login", new LoginCommand());
        commandList.put("register", new RegisterCommand());
        commandList.put("RegisterPage", new RegisterPageCommand());
        commandList.put("LoginPage", new LoginPageCommand());
        commandList.put("addproduct", new AddProductCommand());
        commandList.put("addfunds", new AddFundsCommand());
        commandList.put("showOrder", new AdminShowOrderCommand());
        commandList.put("shoppingCart", new ShoppingCartCommand());
        commandList.put("ProductPage", new ProductPageCommand());
        commandList.put("CustomerPage", new CustomerPageCommand());
        commandList.put("InvoicePage", new InvoicePageCommand());
        commandList.put("logout", new LogOutCommand());
        commandList.put("ConfirmationPage", new PurchaseConfirmationPageCommand());
        commandList.put("OrderFinalized", new OrderFinalizedProductsCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commandList == null) {
            initCommands();
        }
        return commandList.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
