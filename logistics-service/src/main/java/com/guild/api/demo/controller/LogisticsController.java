package com.guild.api.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticsController {

    @GetMapping(value = "/logistics/{logisticsId}")
    public String getLogistics(@PathVariable String logisticsId) throws InterruptedException {
        Thread.sleep(2000);
        return "{Id: LT123456, Logistics: sf-express}";
    }

}
