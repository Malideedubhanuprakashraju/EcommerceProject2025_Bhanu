package com.scaler.productservicefeb25.models;
//Calling  bY 3RD pARTY


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel
{
    private  long id;
    private String title;
    private String description;
    private  String imageUrl;
    private double price;
    private Category category;

}
