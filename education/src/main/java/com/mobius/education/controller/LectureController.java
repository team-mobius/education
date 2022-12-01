package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.service.LectureNoticeService;
import com.mobius.education.service.LectureService;
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
@RequestMapping("lecture/*")
public class LectureController {
    private final LectureService lectureService;
    private final LectureNoticeService lectureNoticeService;

    @GetMapping("/list")
    public void list(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 16);
        }
        model.addAttribute("lists", lectureService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureService.countAll()));
    }

    @GetMapping("/detail")
    public void detail(Model model, Long lectureNumber, Criteria criteria) {
        model.addAttribute("lecture", lectureService.show(lectureNumber));
    }

    @GetMapping("/board")
    public void board(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 16);
        }
        model.addAttribute("notices", lectureNoticeService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureNoticeService.countAll()));
    }

    @GetMapping("/boardDetail")
    public void boardDetail(Model model, Long lectureNoticeNumber, Criteria criteria) {
        model.addAttribute("notice", lectureNoticeService.show(lectureNoticeNumber));
    }

    @GetMapping("/boardWrite")
    public void boardWrite(Model model) {
        model.addAttribute("notice", new LectureNoticeVO());
    }

    @PostMapping("/boardWrite")
    public RedirectView boardWrite(LectureNoticeVO lectureNoticeVO, RedirectAttributes redirectAttributes) {
        lectureNoticeVO.setLectureNumber(9L);
        lectureNoticeService.save(lectureNoticeVO);

        return new RedirectView("/lecture/board");
    }

}
