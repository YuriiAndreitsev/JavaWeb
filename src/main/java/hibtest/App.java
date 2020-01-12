package hibtest;

import hibtest.configuration.Config;
import hibtest.model.Category;
import hibtest.model.Product;
import hibtest.service.ProductService;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class App {
    public static void main(String[] args) {



        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        System.out.println(ctx);

        ProductService productService = ctx.getBean(ProductService.class);
//        Product p1 = new Product("testProduct2", "decs2", 0);
//        Category cat1 = new Category();
//        cat1.setName("testCategory");
//
//        productService.addProduct(p1, cat1);

//        Optional<Product> p2 = productService.getProductById(1);
//        System.out.println(p2.get().getName());
//
//        System.out.println(p2.get().getCategories().iterator().next());
//
//        System.out.println(p2);
//        System.out.println(ctx);

        List<Product> productList = productService.getAllProducts();

        for (Product p: productList
             ) {
            System.out.println(p.getName() + " : "+ p.getCategories().iterator().next().getName());

        }
    }
}
