package controllers;

import dao.ProductControllerDAO;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ProductController implements ProductControllerDAO {

    private Connection conn;
    private PreparedStatement ps = null;

    final static String SELECT_PRODUCTS="select * from prodcat join products on products.id=prodcat.product_id join category on category.id=prodcat.category_id join productimage on productimage.product_id=prodcat.product_id join images on productimage.image_id=images.id";
    final static String SELECT_PRODUCTS_BY_CATEGORY="select * from prodcat join products on products.id=prodcat.product_id join category on category.id=prodcat.category_id join productimage on productimage.product_id=prodcat.product_id join images on productimage.image_id=images.id where category=?";
    final static String SELECT_PRODUCT_BY_ID="select * from products join productimage on productimage.product_id=products.id join images on images.id=productimage.image_id WHERE products.id=?";

    public ProductController(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList=new ArrayList<>();
        try {
            ps=conn.prepareStatement(SELECT_PRODUCTS);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                product.setCategory(rs.getString("category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productList=new ArrayList<>();
        try {
            ps=conn.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);
            ps.setString(1, category);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                product.setCategory(rs.getString("category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        Product product=null;
        try {
            ps=conn.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                product.setCategory(rs.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
        	if( conn != null) {
        		conn.close();
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return product;

    }
}
