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
	
                  <div align="center" class="h6 fw-bold mb-0">산모개인정보등록</div>
	                	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모이름</label>
	                  <c:forEach items="${list }" var="sanmo">
	                  	<input name="num" type="hidden" value="${sanmo.num }">
	                    <input  class="form-control form-control-sm" value="${sanmo.name }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach>  
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">담당산후조리사</label><br>
	                  	<select name="docnum" class="form-control form-control-sm" style="text-align: center;" >
	                  		<c:forEach items="${slist }" var="s">
	                  		<input name="num" type="hidden" value="${s.num }">
	                    	<input  class="form-control form-control-sm" value="${s.name }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach> 
	                    </select>
	                  </div>	              
	                  
	                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	                  	  <input class="btn btn-dark mt-3" type="submit" value="작성완료">
		                  <input class="btn btn-danger mt-3" type="reset"  value="취소">
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