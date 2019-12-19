package servletController;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DAOFactory;
import dao.ProductControllerDAO;
import dao.UserControllerDAO;
import model.Product;
import model.User;

@Controller
@RequestMapping("/myshop")
public class ServletController {
	DAOFactory factory;
	UserControllerDAO userControllerDAO;
		
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProductsPage(ModelMap model, HttpSession session, @RequestParam(value = "category" , required = false) String category) {
		
		
		ProductControllerDAO product;
		    factory = DAOFactory.getFactory(1);
	         product = factory.getProductControllerDAO();
		
//        DAOFactory factory = DAOFactory.getFactory(1);
//        ProductControllerDAO product = factory.getProductControllerDAO();

        List<Product> productList;
        if (category == null) {
            productList = product.getProducts();
        } else {
            productList = product.getProductsByCategory(category);
        }
       
        int cartSize = 0;
        if (session.getAttribute("cart") != null) {
           	Map<Product, Integer> m = (Map<Product, Integer>) session.getAttribute("cart");
            cartSize = m.keySet().size();
        }
        model.addAttribute("productList", productList);
        model.addAttribute("cartSize", String.valueOf(cartSize));

		return "productview";
	}
/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginFrom(ModelMap model, HttpSession session, @RequestParam(value = "email" , required = false) String email, @RequestParam(value = "email" , required = false) String password, @RequestParam(value = "logout" , required = false) String logout  ) {
		
		return "log";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLoginPage(ModelMap model, HttpSession session, @RequestParam(value = "email" , required = false) String email, @RequestParam(value = "email" , required = false) String password, @RequestParam(value = "logout" , required = false) String logout  ) {
		
        String accessMessage;

        factory = DAOFactory.getFactory(1);
        userControllerDAO = factory.getUserControllerDAO();

        if (email != null && password != null) {

			User user = userControllerDAO.getUserByEmail(email);
			if (user!=null) {
				String message = "denied";
				String color = "red";


				if (user.getPassword().equals(userControllerDAO.getHash(password))) {
					message = "granted";
					color = "green";
					//form = false;
					accessMessage = "</br></br><center><font color='" + color + "'>Access " + message + "</font></center>";
					model.addAttribute("access", accessMessage);

					
					session.setAttribute("user", user);

					return "log";

				} else {
					accessMessage = "</br></br><center><font color='" + color + "'>Access " + message + "</font></center>";
					model.addAttribute("access", accessMessage);
//					accessCount++;
//					doGet(request, response);
					showLoginFrom(model, session, email, password, logout);
				}
			}else{
				model.addAttribute("errorMessage", "Wrong Email or Password");
			}
        }
        
        if (logout != null) {
            
            session.invalidate();
           
        }
        return "log";
	}*/
}
