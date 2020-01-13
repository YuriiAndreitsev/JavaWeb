package com.servletController;

import com.configuration.Config;
import com.model.ErrorObj;
import com.model.Users;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class RegServletController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegForm() {

        return "reg";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(ModelMap model, HttpSession session,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "passwordConfirmation", required = false) String passwordConfirmation,
                               @RequestParam(value = "location", required = false) String location,
                               @RequestParam(value = "gender", required = false) String gender,
                               @RequestParam(value = "comment", required = false) String comment) {

//		DAOFactory factory = DAOFactory.getFactory(1);
//		UserControllerDAO userControllerDAO = factory.getUserControllerDAO();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = ctx.getBean(UserService.class);
        ErrorObj errors = new ErrorObj();

        if (errors.checkForMistakes(email, password, passwordConfirmation, location, gender)) {
            StringBuilder errorMessage = errors.getErrorText();
            model.addAttribute("errorObj", errorMessage);
            showRegForm();
        } else {
            Users user = new Users(email, password, location, gender, comment);
            userService.addUser(user);
            model.addAttribute("regComplete", "Registration Successful");
        }
        return "reg";
    }
}
