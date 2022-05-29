<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="cdn.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="vh-100" style="background-color: #666;">
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
	<c:forEach items="${myinfo}" var="my">
	                <form action="modifymyinfo" method="post">

	                  <div align="center"  class="h6 fw-bold mb-0">회원정보 수정</div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">아이디</label>
	                    <input name="id" class="form-control form-control-sm" value="${my.id}" readonly="readonly"/>   
	                  </div>
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">비밀번호</label>
	                    <input type="password" name="password" class="form-control form-control-sm" value="${my.password}"/>
	                  </div>
	                  <!-- state default values ==1 -->
	                  <div>
	                  	<input name="state" hidden="hidden" value="1">
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                    <label class="form-label">이름</label>
	                    <input  name="name" class="form-control form-control-sm" value="${my.name}"/>
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">사용 권한</label>
	                    <select  name="job" class="form-control form-control-sm" >
	                    	<option value="${my.job}">${my.job}입니다</option>
	                    </select>
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                   <label class="form-label">생년월일</label>
	                   <input type="date" name="age" class="form-control form-control-sm" value="${my.age}"/>
	                  </div>
	                    
	                    <div class="form-outline mb-1">
		                 
		                   <span>성별 :</span><input style="display: inline; border: none;" class="form-control-sm" name="gender"  value="${my.gender}" readonly="readonly">
	                	 </div>
	                	 
	                    <div class="form-outline mb-1">
		                   <label class="form-label">전화번호</label>
		                   <input type="tel" name="phone" class="form-control form-control-sm" value="${my.phone}"/>
	                	 </div>
	                	 
	                	  <div class="form-outline mb-1">
		                   <label class="form-label">주소</label>
		                   <input name="address" class="form-control form-control-sm" value="${my.address}"/>
	                	 </div>
	                
	                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		                  <input class="btn btn-danger mt-3" type="button" onclick="history.back()" value="취소">
		                  <input class="btn btn-dark mt-3" type="submit" value="수정완료">
	                  </div>
	                </form>
	</c:forEach>
	              </div>
	            </div> 
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</body>
</html>