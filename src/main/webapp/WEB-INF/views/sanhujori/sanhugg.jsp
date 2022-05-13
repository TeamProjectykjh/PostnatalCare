<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>산후관리사</h1>
<div class="container">
  <div class="row row-cols-2">
  	<c:forEach items="${list}" var="my">
    	<div class="col"><a href="sanhujoriinput?num=${my.num }"><img src="sanhuimg/sanhuA.png" height="300px" width="300px" class="img-thumbnail"></a></div>
    </c:forEach>
  </div>
</div>
<button onclick="location.href='index'">메인으로</button>
</body>
</html>