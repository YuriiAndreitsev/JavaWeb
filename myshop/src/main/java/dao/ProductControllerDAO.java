package dao;

import model.Product;

import java.util.List;

public interface ProductControllerDAO {

    public List<Product> getProducts();
    public  List<Product> getProductsByCategory(String category);
    public  Product getProductById(int id);

}
