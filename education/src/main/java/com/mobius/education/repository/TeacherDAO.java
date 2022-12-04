package com.mobius.education.repository;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.domain.vo.UserVO;
import com.mobius.education.mapper.TeacherMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeacherDAO {
    private final TeacherMapper teacherMapper;

    //    회원가입
    public void save(TeacherVO teacherVO){teacherMapper.insert(teacherVO);}

    //    로그인
    public TeacherVO login(TeacherVO teacherVO){return teacherMapper.login(teacherVO);}

}
