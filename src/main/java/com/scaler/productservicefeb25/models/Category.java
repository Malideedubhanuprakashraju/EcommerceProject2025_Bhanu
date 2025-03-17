package com.scaler.productservicefeb25.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name = "categories")
public class Category extends BaseModel
{
    @Id
    private long id;
    private String name;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
