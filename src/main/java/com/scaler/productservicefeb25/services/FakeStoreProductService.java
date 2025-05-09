package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.dto.FakeStoreProductDto;
import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



//I need Object in Controller
// How to Create Instance Objects ask Spring


@Service ("fakeStoreProductService")  //Make It Special Class -------------------- Hey Spring pls create object of This class while implementig project
public class FakeStoreProductService implements ProductService
{
    // This service Implementation uses FakeStore to Fetch Products from FakeStore

    private  RestTemplate restTemplate; //we can use any name for reff
    private RedisTemplate<String,Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate,RedisTemplate<String,Object> redisTemplate)
    {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        // One Way
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        // 2nd way
//        Category category = new Category();
//        category.setName(fakeStoreProductDto.getCategory());
        return product;

    }


    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        // Make a API call to fake store and get the product with the given id;
        // web call make
        // http call
        // Rest Template Frame work --spring web dependecy (for web call)More widely used

       // RestTemplate restTemplate = new RestTemplate();

       // throw new RuntimeException("Something Went Wrong By Bhanu");

        // First Check in The Redis if the product with the given id is present or not.

        Product product=(Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+productId);

       // Cache HIT
       if(product!=null)
       {
           return product;
       }

       //Cache MISS
       FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/" +productId,
               FakeStoreProductDto.class);// output converst into or object
        // Convert FakeStoreProdcutDto  object into a Product Object.

        // Custom Exceptions creating
        if(fakeStoreProductDto==null)
        {
            throw  new ProductNotFoundException("Product with id :"+productId+" doesn't exit");
        }

        product=convertFakeStoreDtoToProduct(fakeStoreProductDto);


        // Store this product in the Cache.
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+productId,product);

        return product;
    }

//    @Override
//    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
//        return null;
//    }

    @Override
    public Page<Product> getAllProducts(int pageNumber,int pageSize)
    {                                                                                                                                 // Generics=> Came----> At Run Time =No List only Object
        FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);

        // array is data Type itself
        // List is a Collection of objects
        // Convert Array into List of Fake Store products DTOs
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos)
        {
            products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }

        return new PageImpl<>(products);
    }



    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {

    }


}
