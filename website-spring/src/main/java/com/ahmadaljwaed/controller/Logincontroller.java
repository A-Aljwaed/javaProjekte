package com.ahmadaljwaed.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Logincontroller {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String loginPage(){

        return "ahmad aljwaed";


    }

}
