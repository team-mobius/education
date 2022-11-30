package com.mobius.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("place/*")
public class PlaceController {

//    강의장
    @GetMapping("/placeInfo")
    public void placeInformation() {

    }

}
