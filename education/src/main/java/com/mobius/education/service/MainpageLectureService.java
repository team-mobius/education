package com.mobius.education.service;

import com.mobius.education.domain.vo.LectureVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainpageLectureService {

    public List<LectureVO> lectureShowAll() ;
}
