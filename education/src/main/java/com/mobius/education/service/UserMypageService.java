package com.mobius.education.service;

import com.mobius.education.domain.criteria.ShowUserMypageCountCriteria;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.repository.ApplyLectureDAO;
import com.mobius.education.repository.RequestDAO;
import com.mobius.education.repository.ReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMypageService {
    private final ShowUserMypageCountCriteria showUserMypageCountCriteria;
    private final ReviewDAO reviewDAO;
    private final RequestDAO requestDAO;
    private final ApplyLectureDAO applyLectureDAO;

//    마이페이지 내에서 보여질 유저 관련 정보 수
    public ShowUserMypageCountCriteria showCounts(Long userNumber){
        showUserMypageCountCriteria.setUserReviewCount(reviewDAO.showMyReviewCount(userNumber));
        showUserMypageCountCriteria.setUserRequestCount(requestDAO.showMyRequestCount(userNumber));
        showUserMypageCountCriteria.setUserExpectedLectureCount(applyLectureDAO.showMyExpectedLectureCount(userNumber));
        showUserMypageCountCriteria.setUserEndLectureCount(applyLectureDAO.showMyEndLectureCount(userNumber));

        return showUserMypageCountCriteria;
    }

//    마이페이지 내의 나의 리뷰 목록(3개)
    public List<ReviewVO> showMyReviewThree(Long userNumber){

        return reviewDAO.findMyReviewThree(userNumber);
    }

//    마의 페이지 내에서 나의 요청 목록
    public List<RequestVO> showMyRequestThree(Long userNumber){
        return requestDAO.showMyRequestThree(userNumber);
    }

//    내가 완료한 강의 리스트
    public List<LectureVO> showMyEndedLecture(Long userNumber){
        return applyLectureDAO.showMyEndedLecture(userNumber);
    }

    //    내가 완료한 강의 리스트
    public List<LectureVO> showMyOnGoingLecture(Long userNumber){
        return applyLectureDAO.showMyOnGoingLecture(userNumber);
    }

//    나의 리뷰 전체
    public List<ReviewVO> showMyAllReview(Long userNumber){
        return reviewDAO.findMyReviewAll(userNumber);
    }
}


