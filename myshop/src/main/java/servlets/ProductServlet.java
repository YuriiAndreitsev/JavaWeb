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
import java.util.List;
import java.util.Map;

public class ProductServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");

        DAOFactory factory = DAOFactory.getFactory(1);
        ProductControllerDAO product = factory.getProductControllerDAO();

        List<Product> productList;
        if (category == null) {
            productList = product.getProducts();
        } else {
            productList = product.getProductsByCategory(category);
        }
        HttpSession session = request.getSession();
        int cartSize = 0;
        if (session.getAttribute("cart") != null) {
            @SuppressWarnings("unchecked")
			Map<Product, Integer> m = (Map<Product, Integer>) session.getAttribute("cart");
            cartSize = m.keySet().size();
        }
        request.setAttribute("productList", productList);
        request.setAttribute("cartSize", String.valueOf(cartSize));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/productview.jsp");
        rd.forward(request, response);
    }
}
