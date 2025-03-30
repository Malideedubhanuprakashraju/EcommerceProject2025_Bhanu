package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.repositories.CategoryRepository;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary

public class SelfProductService implements ProductService
{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException
    {
        // Make a DB call to get the product with given ID.
        // Select * from products where id=?
//        Optional<Product> productOptional = productRepository.findById(productId);
//
//        if(productOptional.isEmpty())
//        {
//            throw new ProductNotFoundException("Product with id : " + productId + " not found");
//        }
//
//        Product product = productOptional.get();
//
//        return productOptional.get();
        Optional<Product> optionalProduct = productRepository.findById(productId);
        // To avoid Null Pointer exception use Optional-- To cheeck prodct is not eqaul to null

        if(optionalProduct.isEmpty())
        {
            throw new ProductNotFoundException("Product with id : " + productId + " doesn't exist");
        }

        Product product = optionalProduct.get();

        return product;



    }

    @Override
    public List<Product> getAllProducts()
    {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product)
    {
        Category category = product.getCategory();
        // Before Saving The Product in DB, we should first check if category is
        // present in the DB or not, if Yes then good else we'll have to save the category
        // first in the DB.

        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        if(optionalCategory.isEmpty())
        {
            // Save The Category
           category= categoryRepository.save(category);
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
        {
            throw  new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        Product productFromDb = optionalProduct.get();


        productFromDb.setTitle(product.getTitle());
        productFromDb.setImageUrl(product.getImageUrl());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setPrice(product.getPrice());

        Category category = product.getCategory();
        if(category.getId()==null)
        {
            // Save The Category first in the DB
            category=categoryRepository.save(category);
        }
        productFromDb.setCategory(category);// may be transit exception



        return productRepository.save(productFromDb);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException
    {
        productRepository.deleteById(id);

    }


    // Complete Update








}
