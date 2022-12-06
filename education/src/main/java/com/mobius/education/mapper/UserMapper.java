package com.mobius.education.mapper;

import com.mobius.education.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void insert(UserVO userVO);

    public UserVO login(UserVO userVO);

    public int idCheck(String userEmail);

    public int idCheck2(String userNickname);

    public UserVO selectUserNicknameAndDate(Long userNumber);

}
