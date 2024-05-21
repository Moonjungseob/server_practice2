<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-lunchUpdate</title>
</head>
<body>
<h1><%= "임시 lunch 수정폼 화면." %>
</h1>
<form method="post" action="/lunch/update ">
  <div>
    <input type="text" name="menuTitle" placeholder="제목을 입력해주세요." value="${sample.menuTitle}" >
  </div>
  <div>
    <input type="date" name="menuRegDate" value="${sample.menuRegDate}" >
  </div>
  <div>
    <input type="hidden" name="menuNo" value="${sample.menuNo}">
    <button type="submit">수정하기</button>
  </div>
</form>

<%--삭제--%>
<form method="post" action="/lunch/delete">
  <%--  화면에는 안보임. --%>
  <input type="hidden" name="menuNo" value="${sample.menuNo}">
  <button type="submit">삭제하기.</button>
</form>

<form method="get" action="/lunch/list">
  <button type="submit">전체메뉴</button>
</form>
</body>
</html>