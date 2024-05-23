package com.busanit501.connectTest;

import com.busanit501.samplejsp501.lunch.dao.LunchMemberDAO;
import com.busanit501.samplejsp501.lunch.doamin.LunchMemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class LunchMemberDAOTest {
    private LunchMemberDAO lunchmemberDAO;

    @BeforeEach
    public void ready() {
        lunchmemberDAO = new LunchMemberDAO();
    }

    @Test
    public void getSelectOne() throws Exception {
        LunchMemberVO lunchmemberVO = lunchmemberDAO.getWithPasswordMember("mjs", "1234");
        // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + lunchmemberVO);

    }
    @Test
    public void updateUUID() throws Exception {
        lunchmemberDAO.updateUUID("mjs", "testuuid22222222222");
        //디비 콘솔에서 확인해보기
//
    }
    @Test
    public void selectUUID() throws Exception {
       LunchMemberVO lunchmemberVO = lunchmemberDAO.selectUUID("8421715e-886e-4bbb-bff9-78b045404c75");
        log.info("lunchmemberVO : " + lunchmemberVO);
        //디비 콘솔에서 확인해보기

    }
    @Test
    public void insertMember() throws Exception {
        LunchMemberVO lunchmemberVO = LunchMemberVO.builder()
                .mid("mjs2")
                .mpw("1234")
                .mname("문정섭2")
                .build();
                lunchmemberDAO.insertMember(lunchmemberVO);
        //디비 콘솔에서 확인해보기

    }


}






