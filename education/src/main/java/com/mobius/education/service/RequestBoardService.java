package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.criteria.RequestDetailCounts;
import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.repository.RequestCommentDAO;
import com.mobius.education.repository.RequestDAO;
import com.mobius.education.repository.RequestHeartDAO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestBoardService {
    private final RequestDAO requestDAO;
    private final RequestHeartDAO requestHeartDAO;
    private final RequestCommentDAO requestCommentDAO;

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

//    요청 페이징 처리 메인 화면
    public List<RequestDTO> showRequestAll(Criteria criteria){
        return requestDAO.showRequestAll(criteria);
    }

//    요청 게시글별 하트 수 표현
    public int showRequestHeartCount(Long requestNumber){
        return requestHeartDAO.showHeartCount(requestNumber);
    }

    public int getTotal(){
        return requestDAO.getTotal();
    }

    public RequestDTO showReviewDetail(Long requestNumber){
        return requestDAO.showReviewDetail(requestNumber);
    }

    public int showCommentCount(Long requestNumber){
        return requestCommentDAO.showCommentCount(requestNumber);
    }

    public List<RequestCommentDTO> showComment(Long requestNumber){
        System.out.println("6");
        return requestCommentDAO.showComment(requestNumber);
    }

}
