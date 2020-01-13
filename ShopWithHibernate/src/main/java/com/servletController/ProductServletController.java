package com.servletController;

import com.configuration.Config;
import com.model.Product;
import com.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductServletController {


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProductsPage(ModelMap model, HttpSession session, @RequestParam(value = "category", required = false) String category) {

//        JSONObject j = new JSONObject();
//        ProductControllerDAO product;
//        factory = DAOFactory.getFactory(1);
//        product = factory.getProductControllerDAO();

//        DAOFactory factory = DAOFactory.getFactory(1);
//        ProductControllerDAO product = factory.getProductControllerDAO();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ProductService productService = ctx.getBean(ProductService.class);

        List<Product> productList;
        if (category == null) {
            productList = productService.getAllProducts();
        } else {
            productList = productService.getProductsByCategories(category);
        }

        int cartSize = 0;
        if (session.getAttribute("cart") != null) {
            @SuppressWarnings("unchecked")
            Map<Product, Integer> m = (Map<Product, Integer>) session.getAttribute("cart");
            cartSize = m.keySet().size();
        }

        model.addAttribute("productList", productList);
        model.addAttribute("cartSize", String.valueOf(cartSize));

        return "productview";
    }
}
