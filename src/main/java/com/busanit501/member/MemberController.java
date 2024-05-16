package com.busanit501.member;


import com.busanit501.member.dto.MemberDTO;
import com.busanit501.member.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", urlPatterns = "/member/list")
public class MemberController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 임시 더미 메뉴 10개 등록 .
    // 서비스에서 기능 만든것을 재사용.
    // 서버 -> 클라이언트(뷰)
    List<MemberDTO> sampleList = MemberService.INSTANCE.getList();
    req.setAttribute("list",sampleList);
        
    // 기본, 뷰 jsp 파일로 전달하기.
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
    requestDispatcher.forward(req, resp);

  }
}







