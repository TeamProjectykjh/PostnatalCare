<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<table border="2"  style="width: 800px; padding-bottom: 30px;" align="center" >			
			<c:forEach items="${lista}" var="ko">
				<tr>	
								
					<td><img src="nurseimg/${ko.nurpath}" style="width: 400px; height: 300px;"></td>					
					
					<td>
						<table border="2" style="width: 400px; text-align: center; height: 300px;">
							<tr>
								<th>이름</th>
								<td>${ko.name }</td>
							</tr>							
							<tr>
								<th>전화번호</th>
								<td>${ko.phone }</td>
							</tr>							
							<tr>
								<th>자격증 이름</th>
								<td>${ko.nurlicensename }</td>
							</tr>							
							<tr>
								<th>자격증 번호</th>
								<td>${ko.nurserial }</td>
							</tr>							
							<tr>
								<th>경력사항</th>
								<td>${ko.nurrecord }</td>
							</tr>							
							<tr>
								<th>소개</th>
								<td>${ko.nurcontent }</td>
							</tr>	
							<tr>
								<th>수정/삭제</th>
								<td>
									<a href="modifyshh?nurnum=${ko.nurnum }">Modify</a> / 
									<a href="deletelist?nurnum=${ko.nurnum }&name=${ko.name}">Delete</a>
								</td>
							</tr>							
						</table>						
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>