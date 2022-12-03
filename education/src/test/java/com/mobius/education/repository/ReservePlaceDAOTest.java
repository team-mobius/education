package com.mobius.education.repository;

import com.mobius.education.domain.vo.ReservePlaceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReservePlaceDAOTest {
    @Autowired
    private ReservePlaceDAO reservePlaceDAO;

    @Test
    public void insertTest() {
        ReservePlaceVO reservePlaceVO = new ReservePlaceVO();
        reservePlaceVO.create("2022-10-11", false, true, false, 1L);
        reservePlaceDAO.save(reservePlaceVO);
        log.info("reserve: " + reservePlaceVO.getReservePlaceDate());
    }
}