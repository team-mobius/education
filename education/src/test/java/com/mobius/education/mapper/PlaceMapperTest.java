package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.PlaceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PlaceMapperTest {
    @Autowired
    private PlaceMapper placeMapper;

    @Test
    public void SelectAllTest(){
        PlaceVO placeVO = new PlaceVO();
        placeMapper.select(placeVO);
        log.info("place:" + placeVO.getPlaceName());
    }
}