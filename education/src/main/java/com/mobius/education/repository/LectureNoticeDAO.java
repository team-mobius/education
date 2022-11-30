package com.mobius.education.repository;

import com.mobius.education.mapper.LectureNoticeMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureNoticeDAO {
    private final LectureNoticeMapper lectureNoticeMapper;

}
