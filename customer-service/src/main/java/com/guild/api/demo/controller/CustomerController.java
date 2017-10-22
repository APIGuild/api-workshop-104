package com.guild.api.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCustomer() {
        return "Id: ID1234, Name: James";
    }

}
