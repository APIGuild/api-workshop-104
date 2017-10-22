package com.guild.api.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logistics")
public class LogisticsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLogistics() {
        return "Logistics: sf-express";
    }

}
