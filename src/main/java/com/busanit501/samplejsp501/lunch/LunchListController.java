package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.todo.dto.MenuDTO;
import com.busanit501.samplejsp501.todo.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    try {
      List<MenuDTO> sampleList = menuService.listAll();


      // 컨트롤러에서 -> 화면에 -> 데이터 전달
      req.setAttribute("list1",sampleList);
      req.getRequestDispatcher("/WEB-INF/lunch/lunchList.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}






