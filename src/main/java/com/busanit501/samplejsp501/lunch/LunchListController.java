package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.lunch.dto.LunchMemberDTO;
import com.busanit501.samplejsp501.lunch.dto.MenuDTO;
import com.busanit501.samplejsp501.lunch.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "lunchList",urlPatterns = "/lunch/list")
public class LunchListController extends HttpServlet {

  //주입 , 서비스 인스턴스 , 포함.
  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // DB 에서 , 전체 목록을 가져오기.

    HttpSession session = req.getSession();
    LunchMemberDTO lunchmemberDTO = (LunchMemberDTO) session.getAttribute("loginInfo");
    log.info("Login info 세션의 정보 get하기.: " + lunchmemberDTO);

    try {
      //todoService.listAll(); -> 디비에서, 전체 목록 가져오기.
      List<MenuDTO> sampleList = menuService.listAll();
//      log.info("TodoListController , 확인2, sampleList : " + sampleList);

      // 컨트롤러에서 (서버)-> 화면(jsp)에 -> 데이터 전달
      req.setAttribute("list1",sampleList);
      req.setAttribute("lunchmemberDTO",lunchmemberDTO);
      req.getRequestDispatcher("/WEB-INF/lunch/lunchList.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}






