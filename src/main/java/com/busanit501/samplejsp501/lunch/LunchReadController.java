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

@Log4j2
@WebServlet(name = "lunchRead", urlPatterns = "/lunch/read")
public class LunchReadController extends HttpServlet {
  //주입 , 서비스 인스턴스 , 포함.
  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Long menuNo = Long.valueOf(req.getParameter("menuNo"));
      MenuDTO sample = menuService.getSelectOne(menuNo);
      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/lunch/lunchRead.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}