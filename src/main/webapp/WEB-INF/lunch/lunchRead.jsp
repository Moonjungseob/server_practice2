<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-lunchRead</title>
</head>
<body>
<h1><%= "임시 lunchRead 화면." %>
</h1>

<div>
  <input type="text" name="menuTitle" placeholder="제목을 입력해주세요." value="${sample.menuTitle}" readonly>
</div>
<div>
  <input type="date" name="menuRegDate" value="${sample.menuRegDate}" readonly>
</div>
<%--방법1--%>
<form method="get" action="/lunch/update ">
  <input type="text" name="menuNo" value="${sample.menuNo}">
  <div>
    <h3>방법1, 수정폼 이동</h3>
    <button type="submit">수정폼이동</button>
  </div>
</form>
<%--방법2 링크로 해당 수정폼 이동하기.--%>
<div>
  <h3>방법2, 수정폼 이동</h3>
  <a href="/lunch/update?menuNo=${sample.menuNo}">수정폼이동</a>
</div>
<%--방법3--%>
<%--자바스크립트의 코드 이용해서. 처리하기. --%>
<div>
  <h3>방법3, 수정폼 이동</h3>
  <input type="button" value="수정폼이동" id="updateBtn1">
</div>

<form method="get" action="/lunch/update">
  <button type="submit">전체메뉴</button>
</form>
<script>
  document.querySelector("#updateBtn1").addEventListener("click",function(e){
    self.location = "/lunch/update?menuNo=${sample.menuNo}"
  },false);

</script>
</body>
</html>