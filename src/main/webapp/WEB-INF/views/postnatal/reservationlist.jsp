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
<form action="reservationlist">
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
	
	                <form action="newsign" method="get">

	                  <div align="center" class="h6 fw-bold mb-0">산모개인정보등록</div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모이름</label>
	                  <c:forEach items="${list }" var="sanmo">
	                    <input type="text" name="name" class="form-control form-control-sm" value="${sanmo.name }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach>  
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">담당의사</label><br>
	                  	<select name="docname" class="form-control form-control-sm" style="text-align: center;" >
	                  		<option value="">담당 의사 선택해 주세요</option>
	                    	<c:forEach items="${dlist }" var="doc">
	                    	<option class="form-control form-control-sm" value="${doc.docname}">${doc.docname}</option>
	                    	</c:forEach>
	                    </select>
	                    
	                  </div>	              
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">담당간호사</label><br>
	                  	<select name="nurname" class="form-control form-control-sm" style="text-align: center;">
	                  		<option value="">담당 간호사 선택해 주세요</option>
	                  		<c:forEach items="${nlist }" var="nur">
	                  		<option class="form-control form-control-sm" value="${nur.nurname}">${nur.nurname}</option>
	                  		</c:forEach>
	                    	
	                    </select>
	                  </div>
	                   
	                  <div class="form-outline mb-1">
	                   <label class="form-label">입실일자</label>
	                   <input type="date" name="startday" class="form-control form-control-sm" />
	                   <label class="form-label">퇴실일자</label>
	                   <input type="date" name="endday" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">태명</label>
	                    <input name="baby" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">보호자명</label>
	                    <input name="protect" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">비상연락망</label>
	                    <input name="emergencyphone" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	                  	  <input class="btn btn-dark mt-3" type="submit" value="작성완료">
		                  <input class="btn btn-danger mt-3" type="reset"  value="취소">
	                  </div>
	                </form>
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