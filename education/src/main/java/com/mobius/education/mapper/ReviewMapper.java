package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReviewMapper {
//    내가 쓴 리뷰 수 확인
    public Integer selectUserReviewCount(Long userNumber);

//    내가 작성한 리뷰 전체
    public List<ReviewVO> selectAllMyReview(Long userNumber);

//    마이페이지에 보여지는 3 개 조회
    public List<ReviewVO> selectUserReviewThree(Long userNumber);

//    전체조회
    List<ReviewVO> selectAll();

//    리뷰 추가
    public void insert(ReviewVO reviewVO);

//    리뷰 업데이트
    public void update(ReviewVO reviewVO);

//    리뷰 하나 선택
    public ReviewVO select(Long reviewNumber);

//    리뷰 전체 수 조회
    public Integer getTotal();

//    PAGENATION 을 위한
    public List<ReviewVO> selectReviewAll(Criteria criteria);

//    삭제
    public void delete(Long reviewNumber);


    public List<ReviewDTO> selectReviewAllAndUserNickname(Criteria criteria);

//    강의 별 리뷰 조회
    public List<ReviewDTO> selectLectureReview(Long lectureNumber);

}
