package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.service.LectureService;
import com.mobius.education.service.ReviewBoardSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("review/*")
public class ReviewController {
    private final ReviewBoardSevice reviewBoardSevice;
    private final LectureService lectureService;

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
    public String myReview(Model model, Long lectureNumber, Criteria criteria) {
        model.addAttribute("reviews",reviewBoardSevice.showLectureReview(lectureNumber));
        model.addAttribute("lecture",reviewBoardSevice.showSomething(lectureNumber));

        return "/review/classReview";
    }

    @GetMapping("/write")
    public String classReview(Long lectureNumber, Model model) {
        model.addAttribute("lecture",reviewBoardSevice.showSomething(lectureNumber));
        model.addAttribute("review",new ReviewVO());
        return "/review/myReview";

    }

//    @PostMapping("/write")
//    public RedirectView write(ReviewVO reviewVO, RedirectAttributes redirectAttributes){
//        reviewBoardSevice.save(reviewVO);
//        return new RedirectView("/review/list");
//    }
}
