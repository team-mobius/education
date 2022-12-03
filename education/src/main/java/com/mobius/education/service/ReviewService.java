
package com.mobius.education.service;

import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.repository.ReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ReviewService {

//    전체조회 닉네임 포함
    public List<ReviewVO> showAll();


}

