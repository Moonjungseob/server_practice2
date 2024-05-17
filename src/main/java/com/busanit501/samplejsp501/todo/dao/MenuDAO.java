package com.busanit501.samplejsp501.todo.dao;

import com.busanit501.samplejsp501.todo.domain.MenuVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    public List<MenuVO> selectAll() throws Exception {
        //예외 처리 여부를, throws 진행하기
        //디비 연결 하는 순서
        //1) 연결하는 도구 Connection 타입의 인스턴스 필요
        //2) sql 전달하는 도구 : PreparedStatement
        //3) select 할 때는, 조회 결과를 받기 위한 ResultSet 타입의 인스턴스 필요
        //작업 후 반납. -> @Cleanup 사용할 예정

        String sql = "select * from lunchmenu";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        //디비에서 조회한 데이터 내용들을 담을 임시 List가 필요함. 여기에 담을 예정
        List<MenuVO> samples = new ArrayList<MenuVO>();

        while (resultSet.next()) {
            MenuVO menuVOBuilder = MenuVO.builder()
                    .MenuNo(resultSet.getLong("menuNo"))
                    .MenuTitle(resultSet.getString("menuTitle"))
                    .MenuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
                    .build();
            //리스트에 담기
            samples.add(menuVOBuilder);

        }
        return samples;
    }
}
