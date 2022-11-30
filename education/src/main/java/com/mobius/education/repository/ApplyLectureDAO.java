package com.mobius.education.repository;

import com.mobius.education.mapper.ApplyLectureMapper;
import com.mobius.education.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApplyLectureDAO {
    private final ApplyLectureMapper applyLectureMapper;



}
