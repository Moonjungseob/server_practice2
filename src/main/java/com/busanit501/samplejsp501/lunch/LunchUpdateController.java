package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.lunch.dto.MenuDTO;
import com.busanit501.samplejsp501.lunch.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "LunchUpdate",urlPatterns = "/lunch/update")
public class LunchUpdateController extends HttpServlet {
  private MenuService menuService = MenuService.INSTANCE;
  // 폼, 처리도

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      //수정폼, 해당 게시글 번호에 대해서 수정폼을 열기
      Long menuNo = Long.valueOf(req.getParameter("menuNo"));
      //tno 벊에 대한 해당 게시글 가져오기
      MenuDTO sample = menuService.getSelectOne(menuNo);
      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/lunch/lunchUpd.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //처리
    //수정, 변경할 데이터 먼저 가져오기. 콘솔에 찍어보기.
    Long menuNo = Long.valueOf(req.getParameter("menuNo"));
    String menuTitle = req.getParameter("menuTitle");
    LocalDate menuRegDate = LocalDate.parse(req.getParameter("menuRegDate"));

    //박스에 담기. DTO 담고 -> VO 변환
    MenuDTO menuDTO =MenuDTO.builder()
            .menuTitle(menuTitle)
            .menuRegDate(menuRegDate)
            .menuNo(menuNo)
            .build();

    //서비스에 전달하기.
    try {
        menuService.updateTodo(menuDTO);
        resp.sendRedirect("/lunch/list");
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}






