package servletController;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DAOFactory;
import dao.UserControllerDAO;
import model.User;

import java.util.Date;

@Controller
public class LoginServletController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginFrom(ModelMap model, HttpSession session,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "password", required = false) String password) {
        return "log";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLoginPage(ModelMap model, HttpSession session,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "logout", required = false) String logout) {

        model.addAttribute("color", "red");
        model.addAttribute("message", "Access Denied");

        DAOFactory factory = DAOFactory.getFactory(1);
        UserControllerDAO userControllerDAO = factory.getUserControllerDAO();

        if (email != null && password != null) {

            User user = userControllerDAO.getUserByEmail(email);


            if (user != null) {
                if (user.getPassword().equals(userControllerDAO.getHash(password))) {
                    session.setAttribute("user", user);
                    model.addAttribute("color", "green");
                    model.addAttribute("message", "Access Granted");
                    return "log";
                }
            } else {
                model.addAttribute("errorMessage", "Wrong Email or Password");
            }
        }
        if (logout != null) {
            session.invalidate(); // null
        }
        return "log";
    }
}
