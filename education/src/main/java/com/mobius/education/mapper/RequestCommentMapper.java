package com.mobius.education.mapper;

import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestCommentMapper {

    public int countComment(Long requestNumber);

    public List<RequestCommentVO> select(Long requestNumber);

    public List<RequestCommentDTO> selectAndNickname(Long requestNumber);

}
