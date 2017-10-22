package com.guild.api.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping(value = "/customers/{customerId}")
    public String getCustomer(@PathVariable String customerId) {
        return "Id: ID1234, Name: James";
    }

}
