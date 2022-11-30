package com.mobius.education.repository;

import com.mobius.education.mapper.ApplyLectureMapper;
import com.mobius.education.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final NoticeMapper noticeMapper;

}
