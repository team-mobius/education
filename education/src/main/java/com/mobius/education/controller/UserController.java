package com.mobius.education.controller;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.service.SignTeacherService;
import com.mobius.education.service.SignUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpClient;

@Controller
@RequestMapping("/join/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final SignUserService signUserService;
    private final SignTeacherService signTeacherService;

    @GetMapping("/userJoin")
    public void userinsert(Model model){
        model.addAttribute("user",new UserVO());
    }

    @PostMapping("/userJoin")
    public RedirectView signUp(UserVO userVO, RedirectAttributes redirectAttributes){
            signUserService.register(userVO);
            return new RedirectView("/mainpage/index");
    }

    @GetMapping("/login")
    public void loginForm(Model model){ model.addAttribute("user", new UserVO());}

    @PostMapping("/login")
    public RedirectView loginForm(HttpServletRequest request, UserVO userVO){
        HttpSession session = request.getSession();

//        log.info("email " + userVO.getUserEmail());
//        log.info(userVO.getUserPassword());
        UserVO userNumber = null;
        try{
//            userNumber = signUserService.login(userVO);
            userNumber = signUserService.login(userVO);
            session.setAttribute("userNumber", userNumber.getUserNumber());
//            log.info(session.getAttribute("userNumber") + " ====== sesssion");
            return new RedirectView("/mainpage/index");
        }catch (Exception e){
            log.info("TEST= " + e.getMessage());

            return new RedirectView("/join/userJoin");

        }

    }
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/mainpage/index";
    }



}
