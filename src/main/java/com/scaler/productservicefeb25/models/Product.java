package com.scaler.productservicefeb25.models;
//Calling  bY 3RD pARTY


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
// Create Table for any class
@Entity(name = "products") //@Entity(name="products") user defined Name To Database table
public class Product extends BaseModel
{
   // private  long id;
    private String title;
    private String description;
    private  String imageUrl;
    private double price;

    @ManyToOne
    private Category category;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /*
    1               1
    Product=====category ====> M:1
       M             1
     */
}
