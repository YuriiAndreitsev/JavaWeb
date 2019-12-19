package controllers;

import dao.DAOFactory;
import dao.ProductControllerDAO;
import dao.UserControllerDAO;
import model.Product;
import model.User;

import java.util.List;

public class TestDB {

    public static void main(String[] args) {

//User u = new User(17, "user1", "1234","kiev", "male", "nice site");

        DAOFactory factory = DAOFactory.getFactory(1);
        UserControllerDAO userControllerDAO = factory.getUserControllerDAO();
        ProductControllerDAO productControllerDAO = factory.getProductControllerDAO();

//		User user = userControllerDAO.getUserByEmail("user1");
//        List<Product> productList = productControllerDAO.getProducts();
//        List<Product> productList = productControllerDAO.getProductsByCategory("cognac");
        Product product = productControllerDAO.getProductById(1);
        System.out.println(product);
//        for (Product p : productList) {
//            System.out.println(p);
//        }
//		System.out.println(user);

//		User user = uc.getUserByEmail("user1", "1234", db.getConnection());
//		System.out.println(user);

    }

}
