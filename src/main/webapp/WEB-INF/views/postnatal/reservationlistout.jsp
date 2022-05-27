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
	
	                   <div align="center" class="h6 fw-bold mb-0">산모개인정보</div>                  
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모이름</label>
	                  	<c:forEach items="${list}" var="sanmo">
	                    <input class="form-control form-control-sm" value="${sanmo.name }" readonly="readonly" style="text-align: center; background-color: white" />  
	                     </c:forEach>
	                  </div>	              
	                  
	                  <div class="form-outline mb-1">
	                   <label class="form-label">담당의사</label>
	                   <c:forEach items="${dlist}" var="dlist">
	                   <input class="form-control form-control-sm" value="${dlist.name }" readonly="readonly" style="text-align: center; background-color: white" />
	                   </c:forEach>
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                   <label class="form-label">담당간호사</label>
	                   <c:forEach items="${nlist}" var="nlist">
	                   <input class="form-control form-control-sm" value="${nlist.name }" readonly="readonly" style="text-align: center; background-color: white" />
	                   </c:forEach>
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                   <c:forEach items="${clist}" var="dto">
	                   <label class="form-label">입실일자</label>
	                   <input class="form-control form-control-sm" value="${dto.startday }"readonly="readonly" style="text-align: center; background-color: white" />
	                   <label class="form-label">퇴실일자</label>
	                   <input class="form-control form-control-sm" value="${dto.endday }" readonly="readonly" style="text-align: center; background-color: white" />
	                   <label class="form-label">태명</label>
	                   <input class="form-control form-control-sm" value="${dto.baby }" readonly="readonly" style="text-align: center; background-color: white" />
	                   <label class="form-label">보호자명</label>
	                   <input class="form-control form-control-sm" value="${dto.protect }" readonly="readonly" style="text-align: center; background-color: white" />
	                   <label class="form-label">비상연락망</label>
	                   <input class="form-control form-control-sm" value="${dto.emergencyphone }" readonly="readonly" style="text-align: center; background-color: white" />
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