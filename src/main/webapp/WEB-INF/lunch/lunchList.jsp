<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-lunchList</title>
</head>
<body>
<ul>
  <h1>${lunchmemberDTO.mname}님 환영합니다.</h1>
  <div>
    <form method="post" action="/lunchnoauto">
      <button type="submit">자동로그인해제</button>
    </form>
  </div>
  <div>
    <form method="post" action="/lunchlogout">
      <button type="submit">로그아웃</button>
    </form>
  </div>


  <button><a href="/lunch/register">작성</a></button>
  <%--  서버 컨트롤러에서 전달 받은 박스, 라벨 이름: list, --%>
  <%--  내용물: 디비에서 가져온 10개의 값--%>
  <c:forEach items="${list1}" var="dto">
    <li>
      <span>
        <a href="/lunch/read?menuNo=${dto.menuNo}">${dto.menuNo}</a>
      </span>
      <span>
          ${dto.menuTitle}
      </span>
      <span>
          ${dto.menuRegDate}
      </span>
    </li>
  </c:forEach>
</ul>

</body>
</html>