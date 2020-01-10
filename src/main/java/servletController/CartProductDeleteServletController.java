package servletController;

import dao.DAOFactory;
import dao.ProductControllerDAO;

import model.Product;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CartProductDeleteServletController {
    @RequestMapping(value = "/cartdelete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteProductFromCart(ModelMap model, HttpSession session,
                                        @RequestParam(value = "deleteId", required = false) String deleteId,
                                        @RequestParam(value = "deleteQnt", required = false) String deleteQnt) {
        JSONObject j = new JSONObject();

        DAOFactory factory = DAOFactory.getFactory(1);
        ProductControllerDAO productController = factory.getProductControllerDAO();

        Map<Product, Integer> productList = (Map<Product, Integer>) session.getAttribute("cart");

//        Removing product from cart
        if (deleteId != null) {
            Integer delId = Integer.parseInt(deleteId);
            Integer delQnt = Integer.valueOf(deleteQnt);
            Product productToDelete = productController.getProductById(delId);
            int qntleft = productList.get(productToDelete);
            int prodQnt = productList.get(productToDelete) - delQnt;

            int totalPrice = 0;


            if (qntleft <= delQnt) {
                productList.remove(productToDelete);
            } else {
                productList.put(productToDelete, prodQnt);
                totalPrice = productToDelete.getPrice()* prodQnt;
            }
            int cartSize = 0;
            for (Product p : productList.keySet()) {
                cartSize += productList.get(p);
            }
            try {
                j.put("productqntleft", String.valueOf(prodQnt));
                j.put("cartSize", String.valueOf(cartSize));
                j.put("totalPrice", String.valueOf(totalPrice));
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("cart", productList);
            session.setAttribute("cartSize", cartSize);
            model.addAttribute("productList", productList);
        }
        return j.toString();
    }
}