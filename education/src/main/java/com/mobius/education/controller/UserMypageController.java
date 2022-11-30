package com.mobius.education.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usermp/*")
@Slf4j
public class UserMypageController {

    @GetMapping("/ex01")
    public String ex01(){
        return "userMypage/mypage";
    }
}
