package com.scaler.productservicefeb25.inheritancedemo.tableperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructors")

public class Instructor extends User
{
    private String Specilization;
    private Double avgRating;

}
