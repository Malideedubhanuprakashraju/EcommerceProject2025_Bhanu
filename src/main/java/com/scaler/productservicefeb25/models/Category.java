//package com.scaler.productservicefeb25.models;
//
//
//import jakarta.persistence.*;
//import jdk.jfr.Enabled;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//
//@Entity(name = "categories")
//public class Category extends BaseModel
//{
//
//    private String name;
//
//    //private List<Product> products;
//    //private String description;
//
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public Long getId() {
////        return id;
////    }
//}
package com.scaler.productservicefeb25.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name= "categories")
public class Category extends BaseModel
 {
     @Column(nullable=false ,unique = true)
     private String name;

//     @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE},fetch = FetchType.EAGER)// It can only be present in OneToMany Side.
//   private List<Product> products;

 }
