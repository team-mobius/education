package com.mobius.education.controller;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.*;
import com.mobius.education.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("teacherMypage/*")
public class TeacherMypageController {
    private final LectureService lectureService;

//    마이페이지
    @GetMapping("/mypage")
    public void mypage(Model model) {
        model.addAttribute("countExpected", lectureService.expectedGetTotal());
        model.addAttribute("countFinished", lectureService.finishedGetTotal());
        model.addAttribute("countOngoing", lectureService.ongoingGetTotal());
    }

//    작성 중인 지원서
    @GetMapping("/temporary")
    public void temporary(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("lectures", lectureService.showTemporaryAll(criteria));
        model.addAttribute("countTemporary", lectureService.temporaryGetTotal());

    }
    
    @PostMapping("/temporary")
    public RedirectView temporaryLecture(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO, RedirectAttributes redirectAttributes){

        lectureDTO.setLectureStatus("임시저장");
        lectureDTO.setLectureDate(LocalDate.now().toString());
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());

        if(lectureDTO.getLectureTime().equals("Time A (9:00~12:00)")) {
            reservePlaceVO.setReservePlaceMorning(true);
        } else if(lectureDTO.getLectureTime().equals("Time B (13:00~17:00)")) {
            reservePlaceVO.setReservePlaceAfternoon(true);
        } else if(lectureDTO.getLectureTime().equals("Time C (19:00~22:00)")) {
            reservePlaceVO.setReservePlaceDinner(true);
        }

        if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F A강연장")) {
            lectureDTO.setPlaceNumber(1L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F B강연장")) {
            lectureDTO.setPlaceNumber(2L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F C강연장")) {
            lectureDTO.setPlaceNumber(21L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F D강연장")) {
            lectureDTO.setPlaceNumber(24L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F E강연장")) {
            lectureDTO.setPlaceNumber(22L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F F강연장")) {
            lectureDTO.setPlaceNumber(23L);
        }

        lectureService.apply(lectureDTO, reservePlaceVO);
        return new RedirectView("/teacherMypage/temporary");
    }

//    나의 강의 현황
    @GetMapping("/myLecture")
    public void myLecture(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("lectures", lectureService.showFinishedAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureService.finishedGetTotal()));

        model.addAttribute("countExpected", lectureService.expectedGetTotal());
        model.addAttribute("countFinished", lectureService.finishedGetTotal());
        model.addAttribute("countOngoing", lectureService.ongoingGetTotal());
    }

//    진헹 중인 강의
    @GetMapping("/ongoing")
    public void ongoingLecture(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("lectures", lectureService.showOngoingAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureService.ongoingGetTotal()));

        model.addAttribute("countExpected", lectureService.expectedGetTotal());
        model.addAttribute("countFinished", lectureService.finishedGetTotal());
        model.addAttribute("countOngoing", lectureService.ongoingGetTotal());
    }

//    진헹 예정 강의
    @GetMapping("/expected")
    public void expectedLecture(Criteria criteria, Model model) {
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("lectures", lectureService.showExpectedAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lectureService.expectedGetTotal()));

        model.addAttribute("countExpected", lectureService.expectedGetTotal());
        model.addAttribute("countFinished", lectureService.finishedGetTotal());
        model.addAttribute("countOngoing", lectureService.ongoingGetTotal());
    }

//    강의 신청
    @GetMapping("/apply")
    public void applyLecture(Model model, PlaceVO placeVO) {
        model.addAttribute("apply", new LectureVO());
        model.addAttribute("places", lectureService.showPlace(placeVO));
    }


    @PostMapping("/apply")
    public RedirectView applyLecture(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO, RedirectAttributes redirectAttributes){
        lectureDTO.setLectureStatus("진행예정");
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());

        if(lectureDTO.getLectureTime().equals("Time A (9:00~12:00)")) {
            reservePlaceVO.setReservePlaceMorning(true);
        } else if(lectureDTO.getLectureTime().equals("Time B (13:00~17:00)")) {
            reservePlaceVO.setReservePlaceAfternoon(true);
        } else if(lectureDTO.getLectureTime().equals("Time C (19:00~22:00)")) {
            reservePlaceVO.setReservePlaceDinner(true);
        }

        if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F A강연장")) {
            lectureDTO.setPlaceNumber(1L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F B강연장")) {
            lectureDTO.setPlaceNumber(2L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F C강연장")) {
            lectureDTO.setPlaceNumber(21L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F D강연장")) {
            lectureDTO.setPlaceNumber(24L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F E강연장")) {
            lectureDTO.setPlaceNumber(22L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F F강연장")) {
            lectureDTO.setPlaceNumber(23L);
        }

        lectureService.apply(lectureDTO, reservePlaceVO);
        return new RedirectView("/teacherMypage/expected");
    }

    @GetMapping("/modify")
    public void modify(Long lectureNumber, Criteria criteria, Model model) {
        model.addAttribute("lecture", lectureService.show(lectureNumber));
    }

    @PostMapping("/modify")
    public RedirectView modifyLecture(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO, RedirectAttributes redirectAttributes) {
        lectureDTO.setLectureStatus("진행예정");
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());

        if(lectureDTO.getLectureTime().equals("Time A (9:00~12:00)")) {
            reservePlaceVO.setReservePlaceMorning(true);
        } else if(lectureDTO.getLectureTime().equals("Time B (13:00~17:00)")) {
            reservePlaceVO.setReservePlaceAfternoon(true);
        } else if(lectureDTO.getLectureTime().equals("Time C (19:00~22:00)")) {
            reservePlaceVO.setReservePlaceDinner(true);
        }

        if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F A강연장")) {
            lectureDTO.setPlaceNumber(1L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F B강연장")) {
            lectureDTO.setPlaceNumber(2L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F C강연장")) {
            lectureDTO.setPlaceNumber(21L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F D강연장")) {
            lectureDTO.setPlaceNumber(24L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F E강연장")) {
            lectureDTO.setPlaceNumber(22L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F F강연장")) {
            lectureDTO.setPlaceNumber(23L);
        }

        lectureService.modify(lectureDTO, reservePlaceVO);
        return new RedirectView("/teacherMypage/expected");
    }

//    임시저장으로 다시 저장
    @PostMapping("/update")
    public RedirectView updateLecture(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO, RedirectAttributes redirectAttributes) {
        lectureDTO.setLectureStatus("임시저장");
        lectureDTO.setLectureDate(LocalDate.now().toString());
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());

        if(lectureDTO.getLectureTime().equals("Time A (9:00~12:00)")) {
            reservePlaceVO.setReservePlaceMorning(true);
        } else if(lectureDTO.getLectureTime().equals("Time B (13:00~17:00)")) {
            reservePlaceVO.setReservePlaceAfternoon(true);
        } else if(lectureDTO.getLectureTime().equals("Time C (19:00~22:00)")) {
            reservePlaceVO.setReservePlaceDinner(true);
        }

        if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F A강연장")) {
            lectureDTO.setPlaceNumber(1L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F B강연장")) {
            lectureDTO.setPlaceNumber(2L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F C강연장")) {
            lectureDTO.setPlaceNumber(21L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F D강연장")) {
            lectureDTO.setPlaceNumber(24L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F E강연장")) {
            lectureDTO.setPlaceNumber(22L);
        } else if(lectureDTO.getLecturePlace().equals("뫼비우스문화센터 5F F강연장")) {
            lectureDTO.setPlaceNumber(23L);
        }

        lectureService.modify(lectureDTO, reservePlaceVO);
        return new RedirectView("/teacherMypage/temporary");
    }

//    강의 삭제
    @GetMapping("/delete")
    public RedirectView delete(Long lectureNumber) {
        lectureService.remove(lectureNumber);
        return new RedirectView("/teacherMypage/mypage");
    }

//    나의 리뷰
    @GetMapping("/myReview")
    public void myReview() {

    }

//    나의 정보
    @GetMapping("/myInfo")
    public void myInformation() {

    }
}
