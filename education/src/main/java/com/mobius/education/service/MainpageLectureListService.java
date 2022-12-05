package com.mobius.education.service;

import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.repository.LectureDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("mainpage") @Primary
public class MainpageLectureListService implements MainpageLectureService{
    private final LectureDAO lectureDAO;

    public List<LectureVO> lectureShowAll() {
        return lectureDAO.lectureFindAll();
    }
}
