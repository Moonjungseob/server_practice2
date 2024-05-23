package com.busanit501.samplejsp501.lunch.dao;

import com.busanit501.samplejsp501.lunch.doamin.LunchMemberVO;
import com.busanit501.samplejsp501.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LunchMemberDAO {

    // mid,mpw 를 이용해서, 한명의 정보를 가져오기.
    public LunchMemberVO getWithPasswordMember(String mid, String mpw) throws Exception {
        String sql = "select * from lunch_member where mid = ? and mpw = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        LunchMemberVO lunchmemberVO = LunchMemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return lunchmemberVO;
    }
//
//    //uuid 업데이트 하는 메서드.
    public void updateUUID(String mid, String uuid) throws Exception {
        String sql = "update lunch_member set uuid = ? where mid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setString(2, mid);
        pstmt.executeUpdate();

    }
//
//    //하나의 uuid 가져오는 메서드.
    public LunchMemberVO selectUUID(String uuid) throws Exception {
        String sql = "select * from lunch_member where uuid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        LunchMemberVO lunchmemberVO = LunchMemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return lunchmemberVO;

    }
//    //회원가입하는 메서드
    public void insertMember(LunchMemberVO lunchmemberVO) throws Exception {
        String sql = "insert into lunch_member (mid, mpw, mname) values (?,?,?);";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, lunchmemberVO.getMid());
        pstmt.setString(2, lunchmemberVO.getMpw());
        pstmt.setString(3, lunchmemberVO.getMname());
        pstmt.executeUpdate();

    }


}






