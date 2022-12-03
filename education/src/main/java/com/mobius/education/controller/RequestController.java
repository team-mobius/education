package com.mobius.education.controller;

import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.service.RequestBoardService;
import com.mobius.education.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;

@Controller
@RequiredArgsConstructor
@RequestMapping("request/*")
public class RequestController {
    private final RequestBoardService requestBoardService;

//    강의 요청 목록
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("requests",requestBoardService.showAll());
        return "/request/list";
    }


//    강의 요청 작성
    /*@GetMapping("/ask")
    public void ask(HttpServletRequest request, Model model) {
        model.addAttribute("userNumber", request.getSession().getAttribute("userNumber"));
    }*/
    @GetMapping("/ask")
    public void ask(Model model) {
        model.addAttribute("request", new RequestVO());
    }

    @PostMapping("/ask")
    public RedirectView ask(RequestVO requestVO, RedirectAttributes redirectAttributes) {
        requestBoardService.register(requestVO);
        redirectAttributes.addFlashAttribute("requestNumber", requestVO.getRequestNumber());
        return new RedirectView(("/request/list"));
    }

    //    강의 상세 정보
    @GetMapping(value = {"/detail","/update"})
    public void detail(Long requestNumber, Model model) {
        model.addAttribute("request",requestBoardService.show(requestNumber));
    }

    //    강의요청 수정완료
    @PostMapping("/update")
    public RedirectView update(RequestVO requestVO, RedirectAttributes redirectAttributes) {
        requestBoardService.modify(requestVO);
        redirectAttributes.addAttribute("requestNumber", requestVO.getRequestNumber());
        return new RedirectView(("request/detail"));
    }

    //    강의요청 삭제
    @PostMapping("delete")
    public RedirectView delete(Long requestNumber) {
        requestBoardService.remove(requestNumber);
        return new RedirectView(("/request/list"));
    }
}
