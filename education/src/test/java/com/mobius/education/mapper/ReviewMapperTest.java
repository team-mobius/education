package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReviewMapperTest {
    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void selectUserReviewTest(){
        log.info("나의 리뷰 수: " + reviewMapper.selectUserReviewCount(0L));
    }

    @Test
    public void selectMyAllReviewTest(){
        log.info("asd"+reviewMapper.selectAllMyReview(0L));
    }

    @Test
    public void selectAllTest(){
        log.info("전체 리뷰 조회: " + reviewMapper.selectAll());
    }

    @Test
    public void selectThreeTest(){
        log.info("3개 조회 :" + reviewMapper.selectUserReviewThree(0L));
    }

    @Test
    public void selectReviewAll(){
        reviewMapper.selectReviewAll(new Criteria().create(1,10)).stream().map(ReviewVO::getReviewTitle).forEach(log::info);
    }

    @Test
    public void insertTest(){
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.create("안녕하세요","너무 재미있습니다" , 0L,2L);
        reviewMapper.insert(reviewVO);
        log.info("제목 :" + reviewVO.getReviewTitle());
    }

    @Test
    public void updateTest(){
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.setReviewContent("내용 수정");
        reviewVO.setReviewTitle("제목 수정");
        reviewVO.setReviewNumber(7L);
        reviewMapper.update(reviewVO);
        log.info("new title" + reviewVO.getReviewTitle());
    }

    @Test
    public void deleteTest(){
        reviewMapper.delete(7L);
    }

    @Test
    public void getTotal(){
        log.info("전체 수 :" + reviewMapper.getTotal());
    }

    @Test
    public void selectTest(){
        log.info("제목" + reviewMapper.select(8L));
    }

    @Test
    public void selectReviewAllAndUserNicknameTest(){
        reviewMapper.selectReviewAllAndUserNickname(new Criteria().create(1,10)).stream().map(ReviewDTO::getReviewTitle).forEach(log::info);
    }

    @Test
    public void lectureReviewTest(){
        reviewMapper.selectLectureReview(3L).stream().map(ReviewDTO::getReviewTitle).forEach(log::info);

    }
}
