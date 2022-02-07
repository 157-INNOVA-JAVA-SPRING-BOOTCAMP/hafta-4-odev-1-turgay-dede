package com.innova.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Log4j2
public class UserServiceController {
    @GetMapping("/client/users/list")
    @ResponseBody
    public String getServiceStringUser(){
        String URL = "http://localhost:8080/getall/responsebody";
        RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject(URL,String.class);
       log.info(data);
       return data;
    }
}
