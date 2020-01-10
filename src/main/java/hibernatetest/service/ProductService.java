package hibernatetest.service;

import hibernatetest.model.Category;
import hibernatetest.model.Product;
import hibernatetest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addProduct (Product product) {
//        Category categoryTest = new Category();
//        categoryTest.setName("testCategory");
//
//        categoryTest.setProducts((Collection<Product>) product);
//        product.setCategories((Collection<Category>) categoryTest);

        return productRepository.save(product);
    }

    public Product addProduct (Product product, Category category) {
//        category.setProducts((Collection<Product>) product);
//        product.setCategories((Collection<Category>) category);

        return productRepository.save(product);
    }
}
