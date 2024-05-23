package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.lunch.dto.LunchMemberDTO;
import com.busanit501.samplejsp501.lunch.service.LunchMemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lunchsignUpController", urlPatterns = "/lunchlogin/signup")
public class LunchSignUpController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 signup 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunch/lunchsignup.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 세션의 정보를 설정, setter
    // 화면에서, 아이디, 패스워드를 먼저 받기.
    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");
    String mname = req.getParameter("mname");
    //화면에서 입력받은 아이디, 패스워드 이름, 어디담죠? MemberDTO -> 서비스
    //임시모델 DTO
    LunchMemberDTO lunchmemberDTO = LunchMemberDTO.builder()
            .mid(mid)
            .mpw(mpw)
            .mname(mname)
            .build();
      try {
          LunchMemberService.INSTANCE.insertMember(lunchmemberDTO);
        resp.sendRedirect("/lunchlogin");
      } catch (Exception e) {
          throw new RuntimeException(e);
      }

  }// doPost 닫는 부분
} // class 닫는 부분








