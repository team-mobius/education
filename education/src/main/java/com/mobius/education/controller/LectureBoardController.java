package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.service.LectureNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lectureBoard/*")
public class LectureBoardController {
    private final LectureNoticeService lectureNoticeService;

    //   공지사항 목록
    @GetMapping("board")
    public void list(Model model) {
        model.addAttribute("lectureNotices",lectureNoticeService.noticeSelectAll());
    }

    //    공지사항 상세보기
    @GetMapping("read")
    public String read(Long lectureNoticeNumber, Model model) {
        model.addAttribute("lectureNotice", lectureNoticeService.show(lectureNoticeNumber));
        return "/lectureBoard/read";
    }

}
