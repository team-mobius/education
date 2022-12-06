package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import com.mobius.education.mapper.LectureFileMapper;
import com.mobius.education.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.SplittableRandom;

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

    public List<RequestVO> showAllMyRequest(Long userNumber){
        return requestMapper.selectAllMyRequest(userNumber);
    }

    public List<RequestDTO> findByRequestCategoryPE( Criteria criteria){
        return requestMapper.selectRequestCategoryPE(criteria);
    }

    public int getTotalCategory(String requestCategory){
        return requestMapper.getTotalCategory(requestCategory);
    }

    public List<RequestDTO> findByRequestCategoryMath( Criteria criteria){
        return requestMapper.selectRequestCategoryMath(criteria);
    }

    public List<RequestDTO> findByRequestCategoryLang( Criteria criteria){
        return requestMapper.selectRequestCategoryLang(criteria);
    }

    public List<RequestDTO> findByRequestCategoryIT( Criteria criteria){
        return requestMapper.selectRequestCategoryIT(criteria);
    }

    public List<RequestDTO> findByRequestCategoryScience( Criteria criteria){
        return requestMapper.selectRequestCategoryScience(criteria);
    }

    public List<RequestDTO> findByRequestCategoryElse( Criteria criteria){
        return requestMapper.selectRequestCategoryElse(criteria);
    }
}
