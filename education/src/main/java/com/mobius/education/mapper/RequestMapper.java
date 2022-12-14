package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.domain.vo.RequestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RequestMapper {

//    요청추가
    public void insert(RequestVO requestVO);

//    수정
    public void update(RequestVO requestVO);

//    삭제
    public void delete(Long requestNumber);

//    조회
    public RequestVO select(Long requestNumber);

//    전체조회
    public List<RequestVO> selectAll();

//    나의 요청 수 조회
    public int selectUserRequestCount(Long userNumber);

//    나의 요청 전체 조회
    public List<RequestVO> selectUserRequestAll(Long userNumber);

    public List<RequestVO> selectUserRequestThree(Long userNumber);

    public List<RequestDTO> selectAllRequest(Criteria criteria);

    public int getTotal();

    public RequestDTO selectRequestAndNickname(Long requestNumber);

    public List<RequestVO> selectAllMyRequest(Long userNumber);

    public List<RequestDTO> selectRequestCategoryPE(Criteria criteria);

    public int getTotalCategory(String requestCategory);

    public List<RequestDTO> selectRequestCategoryMath(Criteria criteria);

    public List<RequestDTO> selectRequestCategoryLang(Criteria criteria);

    public List<RequestDTO> selectRequestCategoryIT(Criteria criteria);

    public List<RequestDTO> selectRequestCategoryScience(Criteria criteria);

    public List<RequestDTO> selectRequestCategoryElse(Criteria criteria);


}
