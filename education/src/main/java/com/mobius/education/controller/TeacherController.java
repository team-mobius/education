package com.mobius.education.controller;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.repository.TeacherDAO;
import com.mobius.education.service.SignTeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/join/*")
public class TeacherController {
    private final SignTeacherService signTeacherService;

    @GetMapping("/teacherJoin")
    public void insert(Model model){
        model.addAttribute("teacher",new TeacherVO());
    }

    @PostMapping("/teacherJoin")
    public RedirectView signUp(TeacherVO teacherVO, RedirectAttributes redirectAttributes){
        signTeacherService.register(teacherVO);
        return new RedirectView("/mainpage/index");
    }

    @GetMapping("/teacherlogin")
    public void teacherForm(Model model){ model.addAttribute("teacher", new TeacherVO());}

    @PostMapping("/teacherlogin")
    public RedirectView teacherForm(HttpServletRequest request, TeacherVO teacherVO){
        HttpSession session = request.getSession();
        TeacherVO teacherNumber = null;
        try{
            teacherNumber = signTeacherService.login(teacherVO);
            session.setAttribute("teacherNumber", teacherNumber.getTeacherNumber());
            log.info(session.getAttribute("teacherNumber") + " ====== sesssion");
            return new RedirectView("/mainpage/index");
        }catch (Exception e){
            log.info("TEST= " + e.getMessage());

            return new RedirectView("/mainpage/index?check=false");

        }

    }
//    @GetMapping("/teachermypage")
//    public RedirectView teacher(HttpServletRequest request, TeacherVO teacherVO){
//        HttpSession session = request.getSession();
//
//        session.setAttribute("teacherNumber", teacherVO.getTeacherNumber());
//
//        session 
//
//
//        return new RedirectView( "/teacherMypage/mypage");
//    }


    @PostMapping("/idCheck3")
    @ResponseBody
    public int idCheck3(@RequestParam("teacherEmail") String teacherEmail) {
        int cnt3 = signTeacherService.idCheck3(teacherEmail);
        return cnt3;
    }

}
