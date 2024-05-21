<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - lunchInput.jsp</title>
</head>
<body>
<form action="/lunch" method="post">
  <div>
  <input type="text" name="menuTitle" placeholder="메뉴를 입력해주세요.">
  </div>
  <div>
    <input type="date" name="menuRegDate">
  </div>
  <div>
  <button type="reset">초기화</button>
  <button type="submit">메뉴입력</button>
  </div>
</form>
</body>
</html>
