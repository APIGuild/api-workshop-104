package com.guild.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.guild.api.demo.service.CustomerService;
import com.guild.api.demo.service.LogisticsService;

@RestController
@RequestMapping(value = "/orders", produces = "application/json")
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LogisticsService logisticsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrder() {
        return "V2: order id: XXX" + customerService.getCustomer() + ", " + logisticsService.getLogistics();
    }
}
