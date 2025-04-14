package com.scaler.productservicefeb25.models;
//Calling  bY 3RD pARTY


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
// Create Table for any class
@Entity(name = "products") //@Entity(name="products") user defined Name To Database table
public class Product extends BaseModel
{

    private String title;
    private String description;
    private  String imageUrl;
    private double price;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})// default eager


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    private Category category;
    //private Category category;



    /*
    1               1
    Product=====category ====> M:1
       M             1
     */
}
