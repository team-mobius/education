package com.mobius.education.controller;

import com.mobius.education.domain.criteria.ShowUserMypageCountCriteria;
import com.mobius.education.service.UserMypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserMypageController {
    private final UserMypageService userMypageService;



//    사용자 마이페이지 메인
    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("counts",userMypageService.showCounts(0L));
        model.addAttribute("reviews",userMypageService.showMyReviewThree(0L));
        model.addAttribute("requests",userMypageService.showMyRequestThree(0L));

        return "userMypage/mypage";
    }
}
