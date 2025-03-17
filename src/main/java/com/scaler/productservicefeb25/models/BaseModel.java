package com.scaler.productservicefeb25.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@MappedSuperclass // No Table for BaseModel,but all the attributes will be present in all the child class tables.
public class BaseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long  id;
//    private Date createdAt;
//    private Date updatedAt;
}
