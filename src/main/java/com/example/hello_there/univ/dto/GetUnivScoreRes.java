package com.example.hello_there.univ.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter // 해당 클래스에 대한 접근자 생성
@Setter // 해당 클래스에 대한 설정자 생성
@AllArgsConstructor
public class GetUnivScoreRes {
    private Long univId;
    private String univName;
    private int totalScore;
    private int userCount;
    private double partRate;
}
