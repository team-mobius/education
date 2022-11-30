
package com.mobius.education.service;

import com.mobius.education.domain.vo.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

//    전체조회
    public List<ReviewVO> showAll();
}

