package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReservePlaceVO {

    private Long reservePlaceNumber;
    private String reservePlaceDate;
    private boolean reservePlaceMorning;
    private boolean reservePlaceAfternoon;
    private boolean reservePlaceDinner;
    private Long placeNumber;

    public void create(String reservePlaceDate, boolean reservePlaceMorning, boolean reservePlaceAfternoon, boolean reservePlaceDinner, Long placeNumber) {
        this.reservePlaceDate = reservePlaceDate;
        this.reservePlaceMorning = reservePlaceMorning;
        this.reservePlaceAfternoon = reservePlaceAfternoon;
        this.reservePlaceDinner = reservePlaceDinner;
        this.placeNumber = placeNumber;
    }
}
