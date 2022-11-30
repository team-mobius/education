package com.mobius.education.mapper;

import com.mobius.education.domain.vo.ReservePlaceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReservePlaceMapperTest {
    @Autowired
    private ReservePlaceMapper reservePlaceMapper;

    @Test
    public void insertTest() {
        ReservePlaceVO reservePlaceVO = new ReservePlaceVO();
        reservePlaceVO.create("2022-11-28", false, false, true, 21L);
        reservePlaceMapper.insert(reservePlaceVO);
        log.info("reserve: " + reservePlaceVO.getReservePlaceDate());
    }
}