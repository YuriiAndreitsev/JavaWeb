package hibtest.service;

import hibtest.model.Category;
import hibtest.model.Product;
import hibtest.repository.CategoryRepository;
import hibtest.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
//    public Product addProduct (Product product) {
//        Category categoryTest = new Category();
//        categoryTest.setName("testCategory");
//
//        categoryTest.setProducts((Collection<Product>) product);
//        product.setCategories((Collection<Category>) categoryTest);
//
//        return productRepository.save(product);
//    }

    public Product addProduct(Product product, Category category) {

        category.addProduct(product);
        product.addCategories(category);
        categoryRepository.save(category);
        return productRepository.save(product);
    }
}
