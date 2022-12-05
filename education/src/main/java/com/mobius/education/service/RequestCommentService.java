package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestCommentVO;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.repository.RequestCommentDAO;
import com.mobius.education.repository.RequestDAO;
import com.mobius.education.repository.RequestHeartDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestCommentService {

    private final RequestCommentDAO requestCommentDAO;

    public void save(RequestCommentVO requestCommentVO){
        requestCommentDAO.save(requestCommentVO);
    }

    public void modify(RequestCommentVO requestCommentVO){
        requestCommentDAO.modify(requestCommentVO);
    }

    public void remove(Long requestNumber){
        requestCommentDAO.remove(requestNumber);
    }

    public RequestCommentDTO showOne(Long requestNumber){
        return requestCommentDAO.showOne(requestNumber);
    }



}
