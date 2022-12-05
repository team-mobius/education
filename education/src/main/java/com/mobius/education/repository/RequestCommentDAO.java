package com.mobius.education.repository;

import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestCommentVO;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.mapper.LectureMapper;
import com.mobius.education.mapper.RequestCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestCommentDAO {
    private final RequestCommentMapper requestCommentMapper;

    public int showCommentCount(Long requestNumber){
        return requestCommentMapper.countComment(requestNumber);
    }

    public List<RequestCommentDTO> showComment(Long requestNumber){
        System.out.println("7");
        return requestCommentMapper.selectAndNickname(requestNumber);
    }

    public void save(RequestCommentVO requestCommentVO){
        requestCommentMapper.insert(requestCommentVO);
    }

    public void modify(RequestCommentVO requestCommentVO){
        requestCommentMapper.update(requestCommentVO);
    }

    public void remove(Long requestNumber){
        requestCommentMapper.delete(requestNumber);
    }

    public RequestCommentDTO showOne(Long requestNumber){
        return requestCommentMapper.selectOneAndNickname(requestNumber);
    }

}
