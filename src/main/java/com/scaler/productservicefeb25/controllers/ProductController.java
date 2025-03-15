package com.scaler.productservicefeb25.controllers;


import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.FakeStoreProductService;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Calling 3rd Party APIs Class

@RestController     // Hosting Web Application ,To Host HTTP rest APIs
@RequestMapping("/Products")
public class ProductController
{
    //Interafce
    private ProductService productService;// we can store Any Child Reference Here Dirctly we are using Interafce Ref

    // Dependecy Injection Who Implemented This Interaface....

    public ProductController(ProductService productService) // Dependecy Inject via Constructor
    {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        Product singleProduct = productService.getProductById(id);
        return singleProduct;
    }

    public List<Product> getAllProducts()
    {
        return null;
    }

}
