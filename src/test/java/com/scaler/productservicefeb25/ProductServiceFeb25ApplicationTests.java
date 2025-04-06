package com.scaler.productservicefeb25;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import com.scaler.productservicefeb25.repositories.CategoryRepository;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceFeb25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
//        List<ProductWithTitleAndPrice> products =
//                productRepository.getProductTitleAndPriceSQL("iphone 15 pro", 100000.0);
//
//        for (ProductWithTitleAndPrice product : products) {
//            System.out.println(product.getTitle() + " -> " + product.getPrice());
//        }
        // Eager Fetch
        Optional<Product> optionalProduct = productRepository.findById(10L);
       // System.out.println(optionalProduct.get());

        // Lazy Fetch
     //   Optional<Category> optionalCategory = categoryRepository.findById(10L);
        //System.out.println(optionalCategory.get());
//        Category category = optionalCategory.get();
//        List<Product> products=optionalCategory.get().getProducts();
//
//        for(Product product:products)
//        {
//            System.out.println(product.getTitle());
//
//        }




    }
}
// if u installed java in system
// java -jar file.jar(External Jar File)