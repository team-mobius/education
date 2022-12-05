package com.mobius.education.controller;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.service.SignTeacherService;
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
import javax.servlet.http.HttpSession;

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

    @PostMapping("teachermypage")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("teacherNumber");
        return "redirect:/teacherMypage/mypage";
    }


}
