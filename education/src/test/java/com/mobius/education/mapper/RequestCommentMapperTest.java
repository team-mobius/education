package com.mobius.education.mapper;

import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RequestCommentMapperTest {
    @Autowired
    private RequestCommentMapper requestCommentMapper;

    @Test
    public void HeartCountTest(){
        log.info("comment 수" + requestCommentMapper.countComment(79L));
    }

    @Test
    public void selectTest(){
        requestCommentMapper.selectAndNickname(80L).stream().map(RequestCommentDTO::getRequestCommentContent).forEach(log::info);

    }




}
