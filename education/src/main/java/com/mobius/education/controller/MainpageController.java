package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.mapper.MainpageRequestService;
import com.mobius.education.service.*;
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
    private final LectureNoticeService lectureNoticeService;
    private final RequestBoardService requestBoardService;
    private final MainpageRequestService mainpageRequestService;
    private final MainpageLectureListService mainpageLectureListService;


   /* @GetMapping("/index")
    public String index(){return "/mainpage/index";}*/

   @GetMapping("/index")
    public void lectureList(Model model, Criteria criteria) {
        model.addAttribute("lectures", mainpageLectureListService.lectureShowAll());
        model.addAttribute("requests",requestBoardService.showAll());
        /*model.addAttribute("requests",mainpageRequestService.show(requestNumber));*/
    }


    @GetMapping("/lectureList")
    public void detail(Model model, Long lectureNumber, Criteria criteria) {
        model.addAttribute("lectures", lectureService.showAll(criteria));
    }






}
