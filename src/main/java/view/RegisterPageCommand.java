package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class RegisterPageCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }

}
