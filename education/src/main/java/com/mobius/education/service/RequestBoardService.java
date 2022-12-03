package com.mobius.education.service;

import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.repository.RequestDAO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestBoardService {
    private final RequestDAO requestDAO;

    //    추가
    public void register(RequestVO requestVO){
        requestDAO.save(requestVO);
    }

    //    수정
    public void modify(RequestVO requestVO){
        requestDAO.setRequestVO(requestVO);
    }

    //    삭제
    public void remove(Long requestNumber){
        requestDAO.remove(requestNumber);
    }

    //    조회
    public RequestVO show(Long requestNumber){
        return requestDAO.findById(requestNumber);
    }

    //    전체조회
    public List<RequestVO> showAll(){
        return requestDAO.findAll();
    }
}
