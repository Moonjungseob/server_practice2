package com.busanit501.samplejsp501.todo.dao;

import com.busanit501.samplejsp501.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    //기능 구현만 만들고, 단위 테스트 진행 중이고, 나중에 화면 붙여서 작업할 예정.
    //조회 Select
    //데이터베이스 직접적인 데이터 연동할 때 사용하는 모델 클래스 : VO


    public List<TodoVO> selectAll()throws Exception{
        //예외 처리 여부를, throws 진행하기
        //디비 연결 하는 순서
        //1) 연결하는 도구 Connection 타입의 인스턴스 필요
        //2) sql 전달하는 도구 : PreparedStatement
        //3) select 할 때는, 조회 결과를 받기 위한 ResultSet 타입의 인스턴스 필요
        //작업 후 반납. -> @Cleanup 사용할 예정

        String sql = "select * from tbl_todo";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        //디비에서 조회한 데이터 내용들을 담을 임시 List가 필요함. 여기에 담을 예정
        List<TodoVO> samples = new ArrayList<TodoVO>();

        while (resultSet.next()) {
            //기존에는 set를 이용해서 담는 방법
            //임시 TodoVO에 담기 -> 다시 임시 목록에 담기
//            TodoVO todoVO = new TodoVO();
            //resultSet.getLong("tno") 디비에서 조회한 내용
//            todoVO.setTno(resultSet.getLong("tno"));
//            todoVO.setTitle(resultSet.getNString("title"));
//            todoVO.setDueDate(resultSet.getDate("dueDate").toLocalDate());
//            todoVO.setFinished(resultSet.getBoolean("finished"));
            //리스트에 담기
//            samples.add(todoVO);


            //builder 방법
            TodoVO todoVBuilder = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            //리스트에 담기
            samples.add(todoVBuilder);
        }

        return samples;
    }

    //하나의 todo 조회하기. 상세보기.
    public TodoVO selectOne(long tno)throws Exception{
        String sql = "select * from tbl_todo where tno = ?";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        //화면상에서 특정 게시글 선택하면,
        // get : URL: http://localhost:8080/todo/read?tno=3
        pstmt.setLong(1, tno);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();
        //임시로 담을 인스턴스 builder
        //데이터 베이스에서 조회한 1개의 행을 넣기
        TodoVO todoVO = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getNString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return todoVO;
    }

    //쓰기
    //화면에서 받았다 치고, 현재는 더미로 넣기 연습.
    //임시로 저장할 모델 DTO -> VO 변환 -> VO를 해당 데이터베이스 입력.
    //현재 단계에서는 DAO는 직접적인 DB에 넣는 타입은 VO로 진행함
    public void insert(TodoVO vo)throws Exception{
        String sql = "insert into tbl_todo (title, dueDate, finished) values (?,?,?)";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,vo.getTitle());
        //vo.getDueDate() : LocalDate
        //Date.valueOf 메서드의 결과 타입 Date로 변환함.
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3, vo.isFinished());
        //select 조회 할대, pstmt.executeQuery();
        //inset, update, delete 할때는  pstmt.executeUpdate();
//        int result = pstmt.executeUpdate();
        pstmt.executeUpdate();

    }

    //수정
    //수정 폼에서 수장하고 싶은 데이터 임시 모델에 담기 -> TodoVO todoVO
    public void update(TodoVO todoVO)throws Exception{
        String sql = "update tbl_todo set finished = ?, title = ?, dueDate = ? where tno = ?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 임시 모델에 담겨진 변경할 데이터의 내용을 가져와서, 디비에 전달 할 예정.
        pstmt.setBoolean(1,todoVO.isFinished());
        pstmt.setString(2,todoVO.getTitle());
        pstmt.setDate(3, Date.valueOf(todoVO.getDueDate()));
        pstmt.setLong(4,todoVO.getTno());
        pstmt.executeUpdate();
    }

    //삭제
    public void delete(long tno)throws Exception{
        String sql = "delete from tbl_todo where tno = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);
        pstmt.executeUpdate();
    }
















    // 데이터베이스 직접적인 비지니스 로직 처리하는 기능을 만들기.
    // 샘플
    // 현재 시간을 가져오는 기능.
    public String getTime() {
        // HikariCP 이용해서, 디비 연결하는 도구 Connection  타입의 인스턴스 만들기.
        // 사용법.
//    Connection conn = ConnectionUtil.INSTANCE.getConnection();
        // 디비에 접근 하려면, 반드시 예외 처리를 해야함.
        // 3가지 방법. 1) try catch finally 2) throws 3) try resources with (자동 close)
        // 결론, 롬복의 @cleanup , 자동으로 반납함.

        // 예시 try resources with (자동 close)
        String now = null;
        // 디비 연결해서, 시각 가져오는 코드.
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            // sql 전달하는 도구.
            // String sql = "select now()"
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            // 조회한 결과 테이블을 담기위한 임시 테이블
            // 0 행부터 대기중.
            ResultSet rs = pstmt.executeQuery();
        ){
            // 1행 만 있어서, while 문 없음.
            rs.next();
            // 1행의 결과를 가져오기. 문자열
            now = rs.getString(1);
        } catch (Exception exception) {
            exception.printStackTrace();
        } //원래는 finally 구문으로 close 해야하지만,
        // try resource , 자동 close 가 포함되어 있다.
        return now;
    }
   public String getTime2() throws Exception{
        //자원반납 자동으로 처리 롬북의 @Cleanup 기능
      @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
      @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now() ");
      @Cleanup ResultSet rs = pstmt.executeQuery();
      rs.next();
      String now = rs.getString(1);
      return now;
   }


    }

