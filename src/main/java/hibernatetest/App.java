package hibernatetest;

import hibernatetest.configuration.Config;
import hibernatetest.model.*;
import hibernatetest.service.ProdCatService;
import hibernatetest.service.ProductService;
import hibernatetest.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        UserService userService = ctx.getBean(UserService.class);
        ProductService productService = ctx.getBean(ProductService.class);
        ProdCatService prodCatService = ctx.getBean(ProdCatService.class);

//        Product p1 = new Product("testProduct1", "decs1",0);
//        Category cat1 = new Category();
//        cat1.setName("testCategory");
//
//        productService.addProduct(p1, cat1);


//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setImages(new Images("testimage.jpg"));
////        productCategory.setCategory(new Category("testCategory"));
//        productCategory.setProduct(new Product("testProduct1", "decs1",0));
////
////        =========ADDING PRODCAT ============
//        prodCatService.addProdCat(productCategory);

//        ======= DELETING PRODCAT ENTITY=============
//       ProductCategory productCategory = prodCatService.getProdCat(11);
//        prodCatService.deleteProdCat(productCategory);

//        =================ADDING PRODUCT ===========
//        productService.addProduct(new Product("testProduct1", "decs1",0));


//        ============ADDING USER==============
//        Users user = new Users("some@email.com", "anypass", "someLocation", "male", "abubumumulalal");
//        userService.addUser(user);


//        ===============GET USER BY ID ==================
//        Optional<Users> user = userService.getUser(14);
//        System.out.println(user);


//        ============GET ALL USERS ===================
//        List<Users> userList = userService.getAllUser();
//        for (Users u : userList) {
//            System.out.println(u);
//        }
//        ===========================================
        System.out.println(ctx);
    }
}
