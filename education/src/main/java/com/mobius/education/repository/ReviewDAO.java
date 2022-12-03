package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.mapper.PlaceMapper;
import com.mobius.education.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    private final ReviewMapper reviewMapper;

//    전체조회
    public List<ReviewVO> findAll(){
        return reviewMapper.selectAll();
}

//  내가 작성한 리뷰 수 조회
    public int showMyReviewCount(Long userNumber){
        return reviewMapper.selectUserReviewCount(userNumber);
    }

//    내가 작성한 리뷰 전체
    public List<ReviewVO> findMyReviewAll(Long userNumber){
        return reviewMapper.selectAllMyReview(userNumber);
    }

//    마이페이지에 보여지는 3개 리뷰
    public List<ReviewVO> findMyReviewThree(Long userNumber){
        return reviewMapper.selectUserReviewThree(userNumber);
    }

//    페이지네이션을 위한
    public List<ReviewVO> findReviewAll(Criteria criteria){
        return reviewMapper.selectReviewAll(criteria);
    }

//    리뷰 추가
    public void save(ReviewVO reviewVO){
        reviewMapper.insert(reviewVO);
    }

//    리뷰 업데이트
    public void modify(ReviewVO reviewVO){
        reviewMapper.update(reviewVO);
    }

//    리뷰 하나 선택
    public ReviewVO show(Long reviewNumber){
        return reviewMapper.select(reviewNumber);
    }

//    리뷰 삭제
    public void remove(Long reviewNumber){
        reviewMapper.delete(reviewNumber);
    }

//    리뷰 전체 수
    public int showCount(){
        return reviewMapper.getTotal();
    }

//    유저의 닉네임을 가져오기 위한 슈퍼 조인 로넘 가져오는 미친 쿼리문
    public List<ReviewDTO> showReviewAllAndUserNickname(Criteria criteria){
        return reviewMapper.selectReviewAllAndUserNickname(criteria);
    }

//    강의 별 리뷰 조회
    public List<ReviewDTO> showLectureReview(Long lectureNumber){
        return reviewMapper.selectLectureReview(lectureNumber);
    }

}
