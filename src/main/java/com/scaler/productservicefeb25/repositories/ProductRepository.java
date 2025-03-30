package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository //Refrenece to call methods of this Interface
public interface ProductRepository extends JpaRepository<Product,Long>
{
    @Override
    Optional<Product> findById(Long productId);
    // select * from products  where id=productId


    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String str);
    // select * from products where title like '%str%'

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);

    Product save(Product product);

    @Override
    void deleteById(Long aLong);

    // select title,price from products where id=10;
    // HQL--> Hibernate Query languaage
    // Based on Models

    // Custom Query
    //Projections
    //@Query("select p.title,p.price from Productp where p.title= :title  and p.price= :price")


    // projection came
    // SQL--> native Query
    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(String title, Double price);

}


