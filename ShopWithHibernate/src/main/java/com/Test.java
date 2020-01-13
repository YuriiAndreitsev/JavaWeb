package com;

import com.configuration.Config;
import com.model.ErrorObj;
import com.model.Product;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = ctx.getBean(UserService.class);
        ProductService productService = ctx.getBean(ProductService.class);

        System.out.println(productService.getProductById(2).getName());
//        List<Product> productList = productService.getProductsByCategories("cigars");

//        for (Product p : productList) {
//            System.out.println(p.getName());
//        }
//        ErrorObj error = new ErrorObj();
//
//        System.out.println(userService.checkEmail("user3"));
    }
}
