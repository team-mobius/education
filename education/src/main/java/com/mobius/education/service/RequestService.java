package com.mobius.education.service;

import com.mobius.education.domain.vo.RequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
//    추가
    public void register(RequestVO requestVO);

//    수정
    public void modify(RequestVO requestVO);

//    삭제
    public void remove(Long requestNumber);

//    조회
    public RequestVO show(Long requestNumber);

//    전체조회
    public List<RequestVO> showAll();
}
