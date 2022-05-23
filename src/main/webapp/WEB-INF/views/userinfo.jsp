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
		<table class="table table-striped" style="margin-bottom: 8%">
			<caption align="top" style="text-align: center; margin-top: 5%">가입유저 정보</caption>
		    <thead>
			    <tr>
			      <th scope="col">회원번호</th>
			      <th scope="col">아이디</th>
			      <th scope="col">회원권한</th>
			      <th scope="col">이름</th>
			      <th scope="col">생년월일</th>
			      <th scope="col">휴대폰번호</th>
			      <th scope="col">성별</th>
			      <th scope="col">주소</th>
			      <th scope="col">상태</th>
			    </tr>
		  </thead>
		  <tbody>
		  	<s:forEach items="${usertable}" var="user">
			    <tr>
			      <td>${user.num}</td>
			      <td>${user.id}</td>
			      <td>${user.job}</td>
			      <td>${user.name}</td>
			      <td>${user.age}</td>
			      <td>${user.phone}</td>
			      <td>${user.gender}</td>
			      <td>${user.address}</td>
			      <s:choose>
					<s:when test="${user.state == 1}">
				        <td>
				        	<button type="button" class="btn btn-primary"
				        	onclick = "location.href = 'able?num=${user.num}&state=${user.state}'">승인완료</button>
				      	</td>
		        	</s:when>
		        	<s:when test="${user.state == 0}">
				        <td>
				       	 	<button type="button" class="btn btn-secondary"
				       	 	onclick = "location.href = 'able?num=${user.num}&state=${user.state}'">승인대기</button>
				        </td>
		        	</s:when>
		        </s:choose>
			    </tr>
		    </s:forEach>
		  </tbody>
		</table>
	</body>
</html>