<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row row-cols-1 row-cols-md-3 g-4">
 <c:forEach items="${slist }" var="sl" >
  <div class="col" style="margin-top: 150px;">
    <div class="card h-100">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxDMmAlbcv0Z0jL2V6HS6Kn26pyQDJY2V8spe_eIPK6Q&s" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title">
       
        	${sl.name }
        	
        </h5> 
        <p class="card-text">별점해야함! 짧은 경력사항</p>
      </div>
      <div class="card-footer">
         <a href="#" class="btn btn-primary">경력사항보기</a>
      </div>
    </div>
  </div>
  </c:forEach>
  

</div>
</body>
</html>