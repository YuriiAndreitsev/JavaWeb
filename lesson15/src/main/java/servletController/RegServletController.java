package servletController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DAOFactory;
import dao.UserControllerDAO;
import model.ErrorObj;
import model.User;

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

		DAOFactory factory = DAOFactory.getFactory(1);
		UserControllerDAO userControllerDAO = factory.getUserControllerDAO();
		ErrorObj errors = new ErrorObj();

		if (errors.checkForMistakes(email, password, passwordConfirmation, location, gender)) {
			StringBuilder errorMessage = errors.getErrorText();
			model.addAttribute("errorObj", errorMessage);
			showRegForm();
		} else {
			User user = new User(email, password, location, gender, comment);

			userControllerDAO.addUser(user);
			model.addAttribute("regComplete", "Registration Successful");

		}
		return "reg";
	}
}
