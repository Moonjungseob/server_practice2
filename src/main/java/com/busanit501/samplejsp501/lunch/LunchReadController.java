package com.busanit501.samplejsp501.lunch;

import com.busanit501.samplejsp501.lunch.dto.MenuDTO;
import com.busanit501.samplejsp501.lunch.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
  private Cookie findCookie(Cookie[] cookies, String cookieName){
    //찾은 쿠키를 담을 임시 쿠키
    Cookie targetCookie = null;

    if(cookies !=null && cookies.length >0){
      for(Cookie cookie : cookies){
        if(cookie.getName().equals(cookieName)){
          targetCookie = cookie;
          break;
        }
      }//if 조건문
    }
    if(targetCookie == null){
      targetCookie = new Cookie(cookieName, "");
      targetCookie.setPath("/");
      targetCookie.setMaxAge(60*60*24);

    }
    return targetCookie;
  }//find Cookie 닫는 부분
}