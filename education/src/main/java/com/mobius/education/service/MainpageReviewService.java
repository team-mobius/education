
package com.mobius.education.service;

import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.repository.ReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("mainpage") @Primary
public class MainpageReviewService implements ReviewService {
    private final ReviewDAO reviewDAO;

    public List<ReviewVO> showAll() {
        return reviewDAO.findAll();
    }

}

