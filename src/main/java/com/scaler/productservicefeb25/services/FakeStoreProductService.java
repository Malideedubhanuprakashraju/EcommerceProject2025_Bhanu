package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.dto.FakeStoreProductDto;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;



//I need Object in Controller
// How to Create Instance Objects ask Spring


@Service   //Make It Special Class -------------------- Hey Spring pls create object of This class while implementig project
public class FakeStoreProductService implements ProductService
{
    // This service Implementation uses FakeStore to Fetch Products from FakeStore

    private  RestTemplate restTemplate; //we can use any name for reff

    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
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
    public Product getProductById(Long productId)
    {
        // Make a API call to fake store and get the product with the given id;
        // web call make
        // http call
        // Rest Template Frame work --spring web dependecy (for web call)More widely used

       // RestTemplate restTemplate = new RestTemplate();

       FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/" +productId,
               FakeStoreProductDto.class);// output converst into or object
        // Convert FakeStoreProdcutDto  object into a Product Object.

        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }
}
