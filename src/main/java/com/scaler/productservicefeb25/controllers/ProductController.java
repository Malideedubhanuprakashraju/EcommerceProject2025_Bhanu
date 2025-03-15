package com.scaler.productservicefeb25.controllers;


import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.FakeStoreProductService;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    // http://loacalhost:8080/Products/1 => GET
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {
        System.out.println("Bhanu Prakash Raju ");
       Product product= productService.getProductById(id);


       return new ResponseEntity<>(
                product, HttpStatus.NOT_FOUND);// OK

    }

    // http://localhost:8080/Products
    // http://localhost:8080/Products/20
    @GetMapping()
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }

}
