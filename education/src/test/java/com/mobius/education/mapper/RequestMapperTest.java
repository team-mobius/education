package com.mobius.education.mapper;

import com.mobius.education.domain.vo.RequestVO;
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
        log.info("request: " + requestMapper.select(41L));

    }

//    전체조회
    @Test
    public void selectAllTest(){
        requestMapper.selectAll().stream().map(RequestVO::getRequestTitle).forEach(log::info);
    }

}
