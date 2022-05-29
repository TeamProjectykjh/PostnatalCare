<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/summernote.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.tabs {
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
<div class="tabs">
  <input type="radio" name="tabs" id="tabone" checked="checked">
  <label for="tabone">Tab One</label>
  <div class="tab">
    ${list.sanhurecord }
  </div>
  
  <input type="radio" name="tabs" id="tabtwo">
  <label for="tabtwo">Tab Two</label>
  <div class="tab">
     ${list.content }
  </div>
</div>
	<form action="employment" method="post">
	<input type="hidden" name="sanhunum" value="${list.sanhunum}">
	<br>
	<c:if test="${empstate eq 1 }">
		<label for="empdate">고용 날짜</label>
		<input type="date" name="empdate" id="empdate" class="form-control form-control-sm" />
		<br>
		<label>고용기간</label><br>
		<input type="radio" name="date" value="7">7일 &emsp;
		<input type="radio" name="date" value="14">14일 &emsp;
		<input type="radio" name="date" value="21">21일 &emsp;<br><br>
		<input type="submit" value="고용하기"> &emsp;
	</c:if>
	<button type="button" onclick="location.href='sanhuinfo'">뒤로가기</button>
	</form>
</body>
</html>