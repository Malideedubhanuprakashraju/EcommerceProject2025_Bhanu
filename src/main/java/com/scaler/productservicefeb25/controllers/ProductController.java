package com.scaler.productservicefeb25.controllers;


import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.FakeStoreProductService;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ProductController(@Qualifier("selfProductService") ProductService productService) // Dependecy Inject via Constructor
    {
        this.productService = productService;
    }

    // http://loacalhost:8080/Products/1 => GET
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
 //       ResponseEntity<Product> responseEntity = null;
//
//
//        try
//        {
//            Product product= productService.getProductById(id);
//            responseEntity =new ResponseEntity<>(product, HttpStatus.OK);
//        }
////        catch(Exception e)
////        {
////            responseEntity =new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
////        }
//        catch(ProductNotFoundException e)
//        {
//            System.out.println(e.getMessage());
//            responseEntity =new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }

//       return new ResponseEntity<>(
//                product, HttpStatus.NOT_FOUND);// OK
        return productService.getProductById(id);

    }

    // http://localhost:8080/Products
    // http://localhost:8080/Products/20
    @GetMapping()
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }
    // Write exception handle in controller as well
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex)
    {
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

}
