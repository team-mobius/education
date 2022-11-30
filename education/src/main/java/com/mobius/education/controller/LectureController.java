package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("lecture/*")
public class LectureController {
    private final LectureService lectureService;

    @GetMapping("/list")
    public void list(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 20);
        }
        model.addAttribute("lists", lectureService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureService.countAll()));
    }

    @GetMapping("/detail")
    public void detail(Model model, Long lectureNumber, Criteria criteria) {
        model.addAttribute("lectures", lectureService.show(lectureNumber));
    }

    @GetMapping("/board")
    public void board() {

    }

}
