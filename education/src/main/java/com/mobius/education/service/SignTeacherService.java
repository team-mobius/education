package com.mobius.education.service;

import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.repository.TeacherDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Qualifier("sign") @Primary
public class SignTeacherService {
    private final TeacherDAO teacherDAO;

    //강사 회원가입
    public void register(TeacherVO teacherVO){
        teacherDAO.save(teacherVO);
    }

    // 강사 로그인
    public TeacherVO login(TeacherVO teacherVO){return teacherDAO.login(teacherVO);}

    //이메일 중복검사
    public int idCheck3(String teacherEmail){return teacherDAO.idCheck3(teacherEmail);}

}
