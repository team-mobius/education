package com.mobius.education.service;

import com.mobius.education.domain.vo.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MainpageRequestServiceTest {
    @Autowired
    private RequestService requestService;

//    추가
    @Test
    public void registerTest(){
        RequestVO requestVO = new RequestVO();
        requestVO.create("새로 작성한 요청 제목","운동","새로운 운동을 추가하고 싶어요");
        requestService.register(requestVO);
    }

//    수정
    /*@Test
    public void modifyTest(){
        RequestVO requestVO = requestService.show(41L);
        requestVO.setRequestTitle("수정된 제목");
        requestService.modify(requestVO);
    }*/

//    조회
    @Test
    public void showTest(){
        log.info("request: " + requestService.show(41L));
    }

//    전체조회
    @Test
    public void showAllTest(){
        requestService.showAll().stream().map(RequestVO::getRequestTitle).forEach(log::info);
    }
}
