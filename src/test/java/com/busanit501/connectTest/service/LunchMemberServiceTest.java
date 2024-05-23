package com.busanit501.connectTest.service;

import com.busanit501.samplejsp501.lunch.dto.LunchMemberDTO;
import com.busanit501.samplejsp501.lunch.service.LunchMemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2

public class LunchMemberServiceTest {
    //다른 클래스의 인스턴스가 필요해요 -> 주입, 포함
    private LunchMemberService lunchmemberService;

    //아래에 다른 메서드들이 실행되기전에, 먼저 실행이 됨(역할, todoService 초기화 해주는 역할)
    @BeforeEach
    public void ready(){
        lunchmemberService = LunchMemberService.INSTANCE;
    }

    @Test
    public  void getOneMemberTest() throws Exception {

        // 인자 값으로 TodoDTO 를 사용해야함.
        LunchMemberDTO lunchmemberDTO = lunchmemberService.getOneMember("mjs","1234");
        log.info("lunchmemberDTO : "+ lunchmemberDTO);
    }
    @Test
    public  void updateUUID() throws Exception {
        lunchmemberService.updateUUID("mjs", "testuuid33333333333333333");
    }
    @Test
    public  void selectUUID() throws Exception {
        LunchMemberDTO lunchmemberDTO = lunchmemberService.selectUUID("8421715e-886e-4bbb-bff9-78b045404c75");
        log.info("memberDTO : "+ lunchmemberDTO);
    }
    @Test
    public  void insertMember() throws Exception {
        LunchMemberDTO lunchmemberDTO = LunchMemberDTO.builder()
                .mid("mjs3")
                .mpw("1234")
                .mname("문정섭3")
                .build();
        lunchmemberService.insertMember(lunchmemberDTO);
    }
}