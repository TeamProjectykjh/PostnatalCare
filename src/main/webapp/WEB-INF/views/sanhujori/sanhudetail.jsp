<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/summernote.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  width:60%;
  height: 100px;
  margin: auto;
  text-align: center;
  border-collapse: separate;
  border-spacing: 0;
  min-width: 350px;
}
table tr th,
table tr td {
  border-top: 1px solid #bbb;
  border-right: 1px solid #bbb;
  border-bottom: 1px solid #bbb;
  padding: 5px;
}
table tr th:first-child,
table tr td:first-child {
  border-left: 1px solid #bbb;
}
table tr th {
  background: #eee;
  border-top: 1px solid #bbb;
  text-align: center;
}
.tabs {
	border: 1px;
	display: flex;
	flex-wrap: wrap; // make sure it wraps
}
.tabs label {
	order: 1; 
	display: block;
	padding: 1rem 2rem;
	margin-right: 0.2rem;
	cursor: pointer;
  background: #fff;
  font-weight: bold;
  transition: background ease 0.2s;
}
.tabs .tab {
  order: 99;
  flex-grow: 1;
	width: 100%;
	display: none;
  padding: 1rem;
  background: #fff;
}
.tabs input[type="radio"] {
	display: none;
}
.tabs input[type="radio"]:checked + label {
	background: #90CAF9;
}
.tabs input[type="radio"]:checked + label + .tab {
	display: block;
}

@media (max-width: 45em) {
  .tabs .tab,
  .tabs label {
    order: initial;
  }
  .tabs label {
    width: 100%;
    margin-right: 0;
    margin-top: 0.2rem;
  }
}
</style>
<meta charset="UTF-8">
</head>
<body>
<table style="margin-top: 3%; width:85%; margin-bottom: 5%;">
<tr><td>
<div class="tabs">
  <input type="radio" name="tabs" id="tabone" checked="checked">
  <label for="tabone">경력사항</label>
  <div class="tab">
    ${list.sanhurecord }
  </div>
  
  <input type="radio" name="tabs" id="tabtwo">
  <label for="tabtwo">자기소개</label>
  <div class="tab">
     ${list.content }
  </div>
       <c:choose>
	     <c:when test="${!empty reviewlist}">
	          <input type="radio" name="tabs" id="tabthree">
			  <label for="tabthree">후기</label>
			  <div class="tab">
			  <h3>평점 - ${reviewavg}</h3>
			    <table>
			    <tr>
			        <th>이름</th>
			        <th>후기</th>
			        <th>평점</th>
			    </tr>
			    <c:forEach items="${reviewlist}" var="list">
			    <tr>
			        <td>${list.sanhunum }</td>
			        <td>${list.ment }</td>
			        <td>${list.starpoint }</td>
			    </tr>
			    </c:forEach>
			    </table>
			  </div>
	      </c:when>
	      <c:otherwise>
	         <input type="radio" name="tabs" id="tabthree">
			 <label for="tabthree">후기</label>
			 <div class="tab">
			   <h3>아직 후기가 없습니다.</h3>
			 </div>
	      </c:otherwise>
	</c:choose>
</div>
</td></tr>
<tr><td>
<c:choose>
	<c:when test="${state eq 0}">
		<form action="employment" method="post" style="margin-bottom: 8%">
		<input type="hidden" name="sanhunum" value="${list.sanhunum}">
		<br>
		<c:if test="${empstate eq 1 }">
			<label for="empdate">고용 날짜</label>
			<input type="date" name="empdate" id="empdate" class="form-control form-control-sm" />
			<br>
			<label>고용기간</label><br>
			<input type="radio" name="date" id="7date" value="7">
			<label for="7date">7일</label>&emsp;
			<input type="radio" name="date" id="14date" value="14">
			<label for="14date">14일</label>&emsp;
			<input type="radio" name="date" id="24date" value="21">
			<label for="24date">21일</label>&emsp;
			<br><br>
			<input type="submit" value="고용하기"> &emsp;
		</c:if>
		<button type="button" onclick="location.href='sanhuinfo'">뒤로가기</button>
		</form>
	</c:when>
	<c:otherwise>
	<div style="margin-bottom: 3%">
		<br>
		<h5><label>고용기간</label></h5>
		<br>
		${empdto.empstartday } ~ ${empdto.empendday }
		<br><br>
		<c:set var ="posnum" value="${posnum }"/>
		<c:if test="${empdto.posnum eq posnum}">
		<button type="button" onclick="location.href='jobcancel'">고용취소</button>&emsp;
		</c:if>
		<button type="button" onclick="location.href='sanhuinfo'">뒤로가기</button>
	</div>
	</c:otherwise>
</c:choose>
</td></tr>
</table>
</body>
</html>