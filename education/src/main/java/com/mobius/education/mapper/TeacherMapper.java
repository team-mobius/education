package com.mobius.education.mapper;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    public void insert(TeacherVO teacherVO);

    public TeacherVO login(TeacherVO teacherVO);

}
