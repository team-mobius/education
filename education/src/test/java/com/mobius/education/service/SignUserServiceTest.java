package com.mobius.education.service;

import com.mobius.education.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SignUserServiceTest {

    @Autowired
    private SignUserService signUserService;

    @Test
    void register() {
        UserVO userVO =new UserVO();
        userVO.create("www@naver.com",
                "1010",
                "윤찡");
        signUserService.register(userVO);
    }
}