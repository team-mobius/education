package com.mobius.education.repository;

import com.mobius.education.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;



    @Test
    void save() {
        UserVO userVO = new UserVO();
        userVO.create(
                "yen022@naver.com",
                "1233",
                "세윤잉");
        userDAO.save(userVO);
    }
}