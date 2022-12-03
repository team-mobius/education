package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.service.ReviewBoardSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("review/*")
public class ReviewController {
    private final ReviewBoardSevice reviewBoardSevice;

    @GetMapping("/list")
    public String review(Model model, Criteria criteria) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("reviews",reviewBoardSevice.showAllReviewAndNicknames(criteria));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, reviewBoardSevice.getTotal()));

        return "/review/review";
    }

    @GetMapping("/detail")
    public String myReview(Model model) {
        model.addAttribute("reviews",reviewBoardSevice.showLectureReview(3L));

        return "/review/classReview";
    }

    @GetMapping("/classReview")
    public void classReview() {

    }
}
