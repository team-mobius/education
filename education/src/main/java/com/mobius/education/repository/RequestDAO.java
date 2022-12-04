package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.mapper.LectureFileMapper;
import com.mobius.education.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestDAO {
    private final RequestMapper requestMapper;

//    추가
    public void save(RequestVO requestVO) {
        requestMapper.insert(requestVO);
    }

//    수정
    public void setRequestVO(RequestVO requestVO) {
        requestMapper.update(requestVO);
    }

//    삭제
    public void remove(Long requestNumber){
        requestMapper.delete(requestNumber);
    }

//    조회
    public RequestVO findById(Long requestNumber) {
        return requestMapper.select(requestNumber);
    }

//    전체조회
    public List<RequestVO> findAll(){
        return requestMapper.selectAll();
    }

//    나의 요청 수 조회
    public int showMyRequestCount(Long userNumber){
        return requestMapper.selectUserRequestCount(userNumber);
    }

//    나의 모든 요청 조회
    public List<RequestVO> showMyRequestAll(Long userNumber){
        return requestMapper.selectUserRequestAll(userNumber);
    }

//    마이페이지에서 보여지는 요청 3개
    public List<RequestVO> showMyRequestThree(Long userNumber){
        return requestMapper.selectUserRequestThree(userNumber);
    }

//    요청 페이징 처리
    public List<RequestDTO> showRequestAll(Criteria criteria){
        return requestMapper.selectAllRequest(criteria);
    }

    public int getTotal(){
        return requestMapper.getTotal();
    }

    public RequestDTO showReviewDetail(Long requestNumber){
        return requestMapper.selectRequestAndNickname(requestNumber);
    }
}
