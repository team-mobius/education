package com.mobius.education.repository;

import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    //    회원가입
    public void save(UserVO userVO){userMapper.insert(userVO);}

//    로그인
    public long login(String userEmail, String userPassword){return userMapper.login(userEmail,userPassword);}
}
