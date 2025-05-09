package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
//import org.hibernate.query.Page;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ProductService
{
    Product getProductById(Long productId) throws ProductNotFoundException;
    // Second Service
    //List<Product> getAllProducts();

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;

}
