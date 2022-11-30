package com.mobius.education.mapper;

import com.mobius.education.domain.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReviewMapper {
//    내가 쓴 리뷰 수 확인
    public Integer selectUserReviewCount(Long userNumber);

//    내가 작성한 리뷰 전체
    public List<ReviewVO> selectAllMyReview(Long userNumber);

//    전체조회
    List<ReviewVO> selectAll();

}
