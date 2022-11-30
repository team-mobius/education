package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
import com.mobius.education.mapper.LectureThumbnailMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureThumbnailDAO {
    private final LectureThumbnailMapper lectureThumbnailMapper;

}
