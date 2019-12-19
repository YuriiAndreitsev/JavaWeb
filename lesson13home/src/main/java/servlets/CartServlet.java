package servlets;

import dao.DAOFactory;
import dao.ProductControllerDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Integer productQnt = Integer.parseInt(request.getParameter("qnt"));

        System.out.println(productId.toString());
        System.out.println(productQnt.toString());

        if (productId != null) {
            DAOFactory factory = DAOFactory.getFactory(1);
            ProductControllerDAO productController = factory.getProductControllerDAO();
            HttpSession session = request.getSession();

            if (session.getAttribute("cart") == null) {
                Map<Product, Integer> productList = new HashMap<>();
                session.setAttribute("cart", productList);
            }
            Product product = productController.getProductById(productId);
            Map<Product, Integer> productList = (Map<Product, Integer>) session.getAttribute("cart");
            if (productList.get(product) == null) {
                System.out.println("product from the base = " + product.getName());
                productList.put(product, productQnt);
            } else {
                int qnt = productList.get(product);
                productList.put(product, qnt + productQnt);
            }

            int cartSize = 0;
            for (Product p : productList.keySet()) {
                cartSize += productList.get(p);
                System.out.println("Product put in cart = " + p.getName());
            }
//            session.setAttribute("cart", productList);
            session.setAttribute("cartSize", cartSize);
            request.setAttribute("productList", productList);
//            response.sendRedirect("./products");
//            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/productview.jsp");
//            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Product, Integer> productList;
        if (session.getAttribute("cart") != null) {
            productList = (Map<Product, Integer>) session.getAttribute("cartSize");
            request.setAttribute("productList", productList);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cartview.jsp");
        rd.forward(request, response);
    }
}
