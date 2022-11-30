package com.mobius.education.repository;

import com.mobius.education.mapper.LectureMapper;
import com.mobius.education.mapper.RequestCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RequestCommentDAO {
    private final RequestCommentMapper requestCommentMapper;

}
