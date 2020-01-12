package hibtest.service;

import hibtest.model.Category;
import hibtest.model.Product;
import hibtest.repository.CategoryRepository;
import hibtest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Product addProduct(Product product, Category category) {
        category.addProduct(product);
        product.addCategories(category);
        categoryRepository.save(category);
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
