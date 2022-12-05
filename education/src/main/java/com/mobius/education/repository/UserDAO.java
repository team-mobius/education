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
    public UserVO login(UserVO userVO){return userMapper.login(userVO);}

    public int idCheck(String userEmail){return userMapper.idCheck(userEmail);}

    public int idCheck2(String userNickname){return userMapper.idCheck2(userNickname);}


}
