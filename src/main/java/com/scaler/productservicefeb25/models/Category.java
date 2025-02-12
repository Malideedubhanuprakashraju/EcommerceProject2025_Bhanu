package com.scaler.productservicefeb25.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel
{
    private long id;
    private String name;
    private String description;

}
