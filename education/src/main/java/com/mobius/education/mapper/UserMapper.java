package com.mobius.education.mapper;

import com.mobius.education.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void insert(UserVO userVO);

    public long login(String userEmail, String userPassword);


}
