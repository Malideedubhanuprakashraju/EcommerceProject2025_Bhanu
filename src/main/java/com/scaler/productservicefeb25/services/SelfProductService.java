package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService
{

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException
    {
        // Make a DB call to get the product with given ID.
        // Select * from products where id=?
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
