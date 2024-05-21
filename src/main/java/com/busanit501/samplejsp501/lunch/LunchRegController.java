package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.todo.dto.MenuDTO;
import com.busanit501.samplejsp501.todo.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "Lunch", urlPatterns = "/lunch")
public class LunchRegController extends HttpServlet {
  // 메뉴 입력을 받는 폼, get
  // 메뉴 로직 처리하는 , post
private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunch/lunchInput.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    MenuDTO menuDTO = MenuDTO.builder()
            .menuTitle(req.getParameter("menuTitle"))
            .menuRegDate(LocalDate.parse(req.getParameter("menuRegDate")))
            .build();
    try {
      menuService.register2(menuDTO);
      // 리다이렉트, 메인: 리스트
      resp.sendRedirect("/lunch/list");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}







