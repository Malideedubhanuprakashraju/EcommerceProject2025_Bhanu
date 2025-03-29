package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary

public class SelfProductService implements ProductService
{
    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException
    {
        // Make a DB call to get the product with given ID.
        // Select * from products where id=?
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with id : " + productId + " not found");
        }

        Product product = productOptional.get();

        return productOptional.get();



    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
