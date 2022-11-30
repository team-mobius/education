package com.mobius.education.controller;

import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mainpage/*")
public class MainpageController {
    private final ReviewService reviewService;

    @GetMapping("/index")
    public String index(){return "/mainpage/index";}

   /* @GetMapping("/review")
    public String review(){return "/review/review";}*/



    @GetMapping("/review")
    public void review(Model model) {
        model.addAttribute("reviews",reviewService.showAll());
    }
    @GetMapping("/ask")
    public String ask(){return "/request/ask";}

    @GetMapping("/detail")
    public String detail(){return "/request/detail";}

    @GetMapping("/list")
    public String list(){return "/request/list";}





}
