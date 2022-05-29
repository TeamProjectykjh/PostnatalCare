<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1{
  font-family:'Roboto';
}
.container {
  margin-top:40px;
}
.container .row h3,h4{
  font-family:'Roboto';
}
.team-image {
  box-shadow:4px 4px 4px lightgrey;
}
.team-image:hover {
  box-shadow:1px 1px 1px lightgrey;
  transition:box-shadow 3s;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>산후관리사</h1>
<div class="container">
  <div class="row">
	 <c:forEach items="${list}" var="my" varStatus="status">
	 	<div class="col-lg-4 col-md-4 col-xl-4">
	    	<div class="col"><a href="sanhudetail?num=${my.num }"><img src="sanhuimg/${my.sanhupath }" style="height=400px; width=300px;" class="img-thumbnail"></a></div>
	    	<label>${status.count}번</label><br>
	    	<label>${my.name }</label>
	    </div>
	  </c:forEach>
  </div>
</div>
<button onclick="location.href='index'" style="margin-bottom: 8%">메인으로</button>
</body>
</html>