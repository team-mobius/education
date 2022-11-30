package com.mobius.education.repository;

import com.mobius.education.domain.vo.PageDTO;
import com.mobius.education.domain.vo.PlaceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PlaceDAOTest {
    @Autowired
    private PlaceDAO placeDAO;

    @Test
    public void findTest(){
        PlaceVO placeVO = new PlaceVO();
        placeDAO.find(placeVO);
        log.info("place:" + placeVO.getPlaceName());
    }
}