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
<form action="">
	<section class="vh-100">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col col-xl-10">
	        <div class="card" style="border-radius: 1rem;">
	          <div class="row g-0">
	            <div class="col-md-6 col-lg-5 d-none d-md-block">
	              <img src="http://www.ange.co.kr/storage/cms/medium/59f02077d221f"
	                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; width: 100%; height: 100% "/>
	            </div>
	            <div class="col-md-6 col-lg-7 d-flex align-items-center">
	              <div class="card-body p-2 p-lg-2 text-black">
	
	                   <div align="center" class="h6 fw-bold mb-0">일일문진표상세보기</div>                  	              
	                    
	                  <div class="form-outline mb-1">
		                  <c:forEach items="${qlist}" var="ql">
		                  	<label class="form-label">작성일자</label>
		                    	<input  class="form-control form-control-sm"  value="${ql.qusday }" style="text-align: center; background-color: white;" readonly="readonly"/>
		                    <label class="form-label">1. 현재 컨디션은 어떠십니까?</label><br>
		                    	<input class="form-control form-control-sm" value="${ql.quscondition }" style="text-align: center; background-color: white;" readonly="readonly">
		                    <label class="form-label">2. 현재 통증이 있다면 통증의 정도가 어느정도입니까?</label><br>
		                  		<input class="form-control form-control-sm" name="quspain" value="${ql.quspain }" style="text-align: center; background-color: white;" readonly="readonly">
		                  	<label class="form-label">3. 현재 불편사항이 있으십니까?</label><br>
		                  		<input class="form-control form-control-sm" value="${ql.qusdiscomfort }" style="text-align: center; background-color: white;" readonly="readonly"><br>
		                  		<input class="form-control form-control-sm" value="${ql.qustext }"  style="height: 200px; background-color: white;" readonly="readonly">
		                  </c:forEach>
	                  </div>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</form>	
</body>
</html>