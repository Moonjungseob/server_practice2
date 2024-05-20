package com.busanit501.samplejsp501.todo.dao;

import com.busanit501.samplejsp501.todo.domain.MenuVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
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
    public MenuVO selectOne(long menuNo)throws Exception{
        String sql = "select * from lunchmenu where menuNo = ?";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, menuNo);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();
        //임시로 담을 인스턴스 builder
        //데이터 베이스에서 조회한 1개의 행을 넣기
        MenuVO menuVO = MenuVO.builder()
                .MenuNo(resultSet.getLong("menuNo"))
                .MenuTitle(resultSet.getNString("menuTitle"))
                .MenuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
                .build();
        return menuVO;
    }
    public void insert(MenuVO vo)throws Exception{
        String sql = "insert into lunchmenu (menuTitle, menuRegDate) values (?,?)";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,vo.getMenuTitle());
        //vo.getDueDate() : LocalDate
        //Date.valueOf 메서드의 결과 타입 Date로 변환함.
        pstmt.setDate(2, Date.valueOf(vo.getMenuRegDate()));
        pstmt.executeUpdate();

    }
    public void update(MenuVO menuVO)throws Exception{
        String sql = "update lunchmenu set menuTitle = ?, menuRegDate = ? where menuNo = ?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 임시 모델에 담겨진 변경할 데이터의 내용을 가져와서, 디비에 전달 할 예정.

        pstmt.setString(1,menuVO.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(menuVO.getMenuRegDate()));
        pstmt.setLong(3,menuVO.getMenuNo());
        pstmt.executeUpdate();
    }

    public void delete(long menuNo)throws Exception{
        String sql = "delete from lunchmenu where menuNo = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, menuNo);
        pstmt.executeUpdate();
    }

}
