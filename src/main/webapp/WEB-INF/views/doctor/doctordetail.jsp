<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${docinfo}" var="info">
	<div class="card border-dark mt-5" style="min-height: 300px">
	  <div class="row g-0">
	    <div class="col-md-4">
	      <img src="doctorimg/${info.docpath}" class="img-fluid rounded-start" alt="...">
	    </div>
	    <div class="col-md-8">
	      <div class="card-body">
	    	  <c:forEach items="${name}" var="name">
	        <h5 class="card-title">${name}원장님</h5>
	          </c:forEach>
	        <p class="card-text">${info.doctorcontent}</p>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="card border-dark mb-3">
  <div class="card-header">경력사항</div>
  <div class="card-body text-dark">
    <h5 class="card-title">${info.docrecord}</h5>
   </div>
</div>
</c:forEach>
</body>
</html>