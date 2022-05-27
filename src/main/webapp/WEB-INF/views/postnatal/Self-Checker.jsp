<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <script>
function setDisplay(){
    if($('input:radio[id=aaa]').is(':checked')){
        $('#divId').hide();
    }else{
        $('#divId').show();
    }
}

  </script>
<body>
<form action="selfsave">
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
	
	                   <div align="center" class="h6 fw-bold mb-0">문진표</div>                  
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모이름</label>
	                  	<c:forEach items="${list}" var="sanmo">
	                    <input class="form-control form-control-sm" value="${sanmo.name }" readonly="readonly" style="text-align: center;"/>  
	                     </c:forEach>
	                  </div>	              
	                 
	                 <div class="form-outline mb-1">
	                 	<c:forEach items="${plist}" var="pl">
	                 	<input name="posnum" type="hidden" value="${pl.posnum }" >
	                 	</c:forEach>
	                 </div>
	                 
	                  <div class="form-outline mb-1">
	                   <label class="form-label">작성일자</label>
	                   <input type="date" name="qusday" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                    <label class="form-label">1. 현재 컨디션은 어떠십니까?</label><br>
	                    상<input type="radio" name="quscondition" value="상">
	                    중<input type="radio" name="quscondition" value="중">
	                    하<input type="radio" name="quscondition" value="하">
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                    <label class="form-label">2. 현재 통증이 있다면 통증의 정도가 어느정도입니까?</label><br>
	                    상<input type="radio" name="quspain" value="상">
	                    중<input type="radio" name="quspain" value="중">
	                    하<input type="radio" name="quspain" value="하">
	                  </div>
	                  
	                 
	                  <div class="form-outline mb-1">
	                    <label class="form-label">3. 현재 불편사항이 있으십니까?</label><br>
	                    예<input type="radio" id="bbb" name="qusdiscomfort" value="예" onchange="setDisplay()">
						아니오<input type="radio" id="aaa" name="qusdiscomfort" value="아니오" onchange="setDisplay()"><br>
 						<input type="text" name="qustext" id="divId" class="form-control form-control-sm" style="height: 200px;">
	                  </div>
	                  
	                  
	                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	                  	  <input class="btn btn-dark mt-3" type="submit" value="저장">
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