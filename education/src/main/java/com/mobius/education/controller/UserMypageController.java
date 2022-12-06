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
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
@RequestMapping("/mypage/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserMypageController {
    private final UserMypageService userMypageService;



//    , @SessionAttribute(name="userNumber") Long userNumber
//    사용자 마이페이지 메인
    @GetMapping("/main")
    public String main(Model model, @SessionAttribute(name="userNumber") Long userNumber){
        String nickname = userMypageService.showMyNicknameAndDate(userNumber).getUserNickname();

        model.addAttribute("nickname",nickname);
        model.addAttribute("counts",userMypageService.showCounts(userNumber));
        model.addAttribute("reviews",userMypageService.showMyReviewThree(userNumber));
        model.addAttribute("requests",userMypageService.showMyRequestThree(userNumber));
        log.info("현재 세션 :" + userNumber);

        return "/userMypage/mypage";
    }

//  내가 완료한 강의
    @GetMapping("/endLec")
    public String endLec(Model model, @SessionAttribute(name="userNumber") Long userNumber){
        model.addAttribute("counts",userMypageService.showCounts(userNumber));
        model.addAttribute("lectures",userMypageService.showMyEndedLecture(userNumber));
        return "/userMypage/completionlecture";
    }

    @GetMapping("/onGoing")
    public String onGoing(Model model, @SessionAttribute(name="userNumber") Long userNumber){
        model.addAttribute("counts",userMypageService.showCounts(userNumber));
        model.addAttribute("lectures",userMypageService.showMyOnGoingLecture(userNumber));
        return "/userMypage/onGoingLecture";
    }

    @GetMapping("/review")
    public String review(Model model, @SessionAttribute(name="userNumber") Long userNumber){
        model.addAttribute("reviews",userMypageService.showMyAllReview(userNumber));
        model.addAttribute("counts",userMypageService.showCounts(userNumber));
        return "/userMypage/myReview";
    }

    @GetMapping("/request")
    public String request(Model model,@SessionAttribute(name="userNumber") Long userNumber){
        model.addAttribute("counts",userMypageService.showCounts(userNumber));
        model.addAttribute("requests",userMypageService.showAllMyRequest(userNumber));
        return "/userMypage/myRequest";
    }
}
