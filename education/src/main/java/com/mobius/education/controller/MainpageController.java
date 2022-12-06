package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.mapper.MainpageRequestService;
import com.mobius.education.service.LectureService;
import com.mobius.education.service.RequestService;
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
    private final LectureService lectureService;
    private final MainpageRequestService mainpageRequestService;
    private final RequestService requestService;

    /*@GetMapping("/detail")
    public String index(){return "/mainpage/mainDetail";}*/

    //   메인페이지
    @GetMapping("index")
    public void list(Model model) {
        model.addAttribute("lectures",lectureService.mainLectureShowAll());
        model.addAttribute("requests",mainpageRequestService.showAll());
    }

    //    강의 상세보기
   @GetMapping("mainDetail")
    public String read(Long lectureNumber, Model model) {
        model.addAttribute("lecture", lectureService.show(lectureNumber));
        return "/lecture/detail";
    }

//    요청상세보기
@GetMapping("requestDetail")
public String requestList(Long requestNumber, Model model) {
    model.addAttribute("lectureNotice",requestService.show(requestNumber));
    return "/lectureBoard/read";
}

   /*@GetMapping("mainDetail")
    public String read(Long lectureNumber, Model model) {
        model.addAttribute("lecture", lectureService.mainDetailSelect(lectureNumber));
        return "/mainpage/mainDetail";
    }*/

    //    강의 상세보기
   /* @GetMapping("detail")
    public String read(Long lectureNoticeNumber, Model model) {
        model.addAttribute("lectureNotice", lectureService.show(lectureNoticeNumber));
        return "/lecture/detail";
    }*/











}
