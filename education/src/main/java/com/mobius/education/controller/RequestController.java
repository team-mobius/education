package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.service.RequestBoardService;
import com.mobius.education.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("request/*")
@Slf4j
public class RequestController {
    private final RequestBoardService requestBoardService;


//    강의 요청 목록
    @GetMapping("/list")
    public String list(Model model, Criteria criteria) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
//        List<Object> requests = requestBoardService.showRequestAll(criteria).stream().map(requestDTO -> requestDTO.create(requestBoardService.showRequestHeartCount(requestDTO.getRequestNumber()))).collect(Collectors.toUnmodifiableList());

        model.addAttribute("requests",requestBoardService.showRequestAll(criteria).stream().map(requestDTO -> requestDTO.create(requestBoardService.showRequestHeartCount(requestDTO.getRequestNumber()),requestBoardService.showCommentCount(requestDTO.getRequestNumber()))).collect(Collectors.toUnmodifiableList()));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria,requestBoardService.getTotal()));
        return "/request/list";
    }


    @GetMapping("/ask")
    public String ask(Model model) {
        model.addAttribute("request", new RequestVO());
        return "/request/ask";
    }

    @PostMapping("/ask")
    public RedirectView ask(RequestVO requestVO, RedirectAttributes redirectAttributes) {
        requestBoardService.register(requestVO);

        return new RedirectView(("/request/list"));
    }

    //    강의 상세 정보
    @GetMapping(value = {"/detail","/update"})
    public String detail(Long requestNumber, Model model, Criteria criteria) {
        model.addAttribute("request",requestBoardService.showReviewDetail(requestNumber));
        model.addAttribute("countHeart",requestBoardService.showRequestHeartCount(requestNumber));
        model.addAttribute("requestComments",requestBoardService.showComment(requestNumber));
        return "/request/detail";
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

    @GetMapping("/test")
    public String test(){
        return "";

    }
}
