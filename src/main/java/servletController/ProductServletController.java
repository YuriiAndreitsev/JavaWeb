package servletController;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DAOFactory;
import dao.ProductControllerDAO;
import dao.UserControllerDAO;
import model.Product;

@Controller

public class ProductServletController {

    DAOFactory factory;
    UserControllerDAO userControllerDAO;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProductsPage(ModelMap model, HttpSession session, @RequestParam(value = "category", required = false) String category) {

//        JSONObject j = new JSONObject();
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
            @SuppressWarnings("unchecked")
            Map<Product, Integer> m = (Map<Product, Integer>) session.getAttribute("cart");
            cartSize = m.keySet().size();
        }

//        try {
//            j.put("cartSize", String.valueOf(cartSize));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        model.addAttribute("productList", productList);
        model.addAttribute("cartSize", String.valueOf(cartSize));

        return "productview";
    }
}
