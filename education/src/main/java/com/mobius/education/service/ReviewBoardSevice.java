package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.repository.LectureDAO;
import com.mobius.education.repository.ReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewBoardSevice {
    private final ReviewDAO reviewDAO;
    private final LectureDAO lectureDAO;

    public List<ReviewDTO> showAllReviewAndNicknames(Criteria criteria){
        return reviewDAO.showReviewAllAndUserNickname(criteria);
    }

    public int getTotal(){
        return reviewDAO.showCount();
    }

//    강의별 리뷰 상세 보기
    public List<ReviewDTO> showLectureReview(Long lectureNumber){
        return reviewDAO.showLectureReview(lectureNumber);
    }

//    리뷰 추가
    public void save(ReviewVO reviewVO){
        reviewDAO.save(reviewVO);
    }

    public LectureVO showSomething(Long teacherNumber){
        return lectureDAO.selectLecDetailSomething(teacherNumber);
    }
}
