package com.scaler.productservicefeb25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// This class will be Hosting set of HTTP API's

@RestController
@RequestMapping("/say")
public class SampleController
{
//    @GetMapping("/hello")
//    public String sayHello()
//    {
//        return "Hello Everyone Bhanu Prakash Raju";
//    }
//
//    @GetMapping("/bye")
//    public String sayBye()
//    {
//        return "Bye Everyone toooo Bhanu";
//    }
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String n)
    {
        return "Hello Everyone Bhanu Prakash Raju"+n;
    }

    @GetMapping("/bye/{name}/{times}")
    public String sayBye(@PathVariable("name") String n,@PathVariable("times") int t)
    {
        String op="";
        for(int i=0;i<t;i++)
        {
            System.out.println(" ");
            op=op+"Hello Bhanu Raju    "+n;

        }
        return op;
    }


}

// http://locslhost:8080/say/hello