<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
    <jsp:include page="cdn.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/company/index">PostnatalCare</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarColor01">
      
        <s:forEach items="${userinfo}" var="job">
		<s:choose>
			<s:when test="${job.job eq '산모'}">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="reservation">산모개인정보</a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="Self-Checker">일일문진표</a>
		          </li>
		        </ul>
        	</s:when>
        	<s:when test="${job.job eq '의사'}">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="doctor">doctortest</a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="#">의사옵션2</a>
		          </li>
		        </ul>
        	</s:when>
        	<s:when test="${job.job eq '간호사'}">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="#">간호사옵션1</a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="#">간호사옵션2</a>
		          </li>
		        </ul>
        	</s:when>
        	<s:when test="${job.job eq '산후조리사'}">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="sanhugg">산후조리사조회</a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="sanhulicense?num=${user.num}">산후조리사관리</a>
		          </li>
		        </ul>
        	</s:when>
        	<s:when test="${job.job eq 'admin'}">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="userinfo">유저관리</a>
		          </li>
		        </ul>
        	</s:when>
        </s:choose>
      </s:forEach>
        <span class="d-flex">
          
          <s:forEach items="${userinfo}" var="user">
         		 <span style="color: white;" class="me-2">
          				${user.name}&nbsp;<span>${user.job}님 환영합니다.</span>
          	         </span>
          
 
          <button class="btn btn-outline-light" onclick="location.href='myinfo?id=${user.id}'" >내정보 수정</button>
       		
       		<button class="btn btn-outline-light"  onclick="location.href='login'" >로그아웃</button>
        </s:forEach>
        </span>
      </div>
    </div>
  </nav>
</body>
</html>