package hibtest;

import hibtest.configuration.Config;
import hibtest.model.Category;
import hibtest.model.Product;
import hibtest.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {



        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        System.out.println(ctx);

        ProductService productService = ctx.getBean(ProductService.class);
        Product p1 = new Product("testProduct2", "decs2", 0);
        Category cat1 = new Category();
        cat1.setName("testCategory");

        productService.addProduct(p1, cat1);



    }
}
