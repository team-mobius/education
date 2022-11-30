package com.mobius.education.repository;

import com.mobius.education.mapper.TeacherMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeacherDAO {
    private final TeacherMapper teacherMapper;

}
