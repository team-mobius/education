package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.domain.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RequestMapperTest {
    @Autowired
    private RequestMapper requestMapper;

//    추가
    @Test
    public void insertTest(){
        RequestVO requestVO = new RequestVO();
        requestVO.create("요청합니다","수학","기초수학에 관한 강의를 요청합니다");
        requestMapper.insert(requestVO);
    }

//    수정
    /*@Test
    public void updateTest(){
        RequestVO requestVO = requestMapper.select();
        requestVO.setRequestTitle("수정요청");
        requestMapper.update(requestVO);
    }*/

//    조회
    @Test
    public void selectTest(){
        log.info("request: " + requestMapper.select(0L));

    }

//    전체조회
    @Test
    public void selectAllTest(){
        requestMapper.selectAll().stream().map(RequestVO::getRequestTitle).forEach(log::info);
    }

//    요청 수 조회
    @Test
    public void selectCountTest(){
        log.info("요청 수 : " + requestMapper.selectUserRequestCount(0L));
    }

//    내가 용청한 것 전부
    @Test
    public void selectUserAllTest(){
        log.info("내가 요청한 것 : " + requestMapper.selectUserRequestAll(0L));
    }

//    마이페이지에서 보여지는 3개의 리뷰
    @Test
    public void selectUserTree(){
        log.info("요청 3개 :" +requestMapper.selectUserRequestThree(0L));
    }

//    request 페이징 처리
    @Test
    public void selectRequestAllTest(){
        requestMapper.selectAllRequest(new Criteria().create(1,10)).stream().map(RequestDTO::getRequestTitle).forEach(log::info);
    }

    @Test
    public void getTotalTest(){
        log.info("전체수 : " + requestMapper.getTotal());
    }

    @Test
    public void getNicknameTest(){
        log.info("닉네임 :" + requestMapper.selectRequestAndNickname(1L));
    }



}
