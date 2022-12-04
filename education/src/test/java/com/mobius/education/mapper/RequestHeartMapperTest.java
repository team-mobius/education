package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RequestHeartMapperTest {
    @Autowired
    private RequestHeartMapper requestHeartMapper;

    @Test
    public void HeartCountTest(){
        log.info("하트 수" + requestHeartMapper.selectHeartCount(1L));
    }




}
