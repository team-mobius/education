package com.mobius.education.service;

import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.mapper.UserMapper;
import com.mobius.education.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Qualifier("sign") @Primary
public class SignUserService {
    private final UserDAO userDAO;

    //회원가입
    public void register(UserVO userVO){
        userDAO.save(userVO);
    }

    // 로그인
    public UserVO login(UserVO userVO){return userDAO.login(userVO);}

    // 이메일중복검사
    public int idCheck(String userEmail){return userDAO.idCheck(userEmail);}

    // 닉네임 중복검사
    public int idCheck2(String userNickname){return userDAO.idCheck2(userNickname);}

}
