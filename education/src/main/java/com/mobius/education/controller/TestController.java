package com.mobius.education.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
@Slf4j
public class TestController {

    @GetMapping("/ex01")
    public String ex01(){
        return "/place/placeInformation";
    }

    @GetMapping("/ex02")
    public String ex02(){
        return "/teacherMypage/teacherTemporaryStorage";
    }

}
