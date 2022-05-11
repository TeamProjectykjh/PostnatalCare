<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	                <form action="newsign" method="post">

	                  <div align="center"  class="h6 fw-bold mb-0">회원가입</div>
	                  
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">아이디</label>
	                    <input name="id" class="form-control form-control-sm" />   
	                  </div>
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">비밀번호</label>
	                    <input type="password" name="password" class="form-control form-control-sm" />
	                  </div>
	                  <!-- state default values ==1 -->
	                  <div>
	                  	<input name="state" hidden="hidden" value="1">
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                    <label class="form-label">이름</label>
	                    <input  name="name" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">가입 하시는분</label>
	                    <select  name="job" class="form-control form-control-sm" >
	                    	<option value="">선택해 주세요</option>
						    <option value="산모">산모</option>
						    <option value="의사">의사</option>
						    <option value="간호사">간호사</option>
						    <option value="산후조리사">산후조리사</option>
	                    </select>
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                   <label class="form-label">생년월일</label>
	                   <input type="date" name="age" class="form-control form-control-sm" />
	                  </div>
	                    
	                    <div class="form-outline mb-1">
		                   <label class="form-label">성별</label>
		                   <input type="radio" name="gender" value="남자">남자 
		                   <input type="radio" name="gender" value="여자">여자
	                	 </div>
	                	 
	                    <div class="form-outline mb-1">
		                   <label class="form-label">전화번호</label>
		                   <input type="tel" name="phone" class="form-control form-control-sm" />
	                	 </div>
	                	 
	                	  <div class="form-outline mb-1">
		                   <label class="form-label">주소</label>
		                   <input name="address" class="form-control form-control-sm" />
	                	 </div>
	                
	                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		                  <input class="btn btn-danger mt-3" type="button" onclick="location.href='login'" value="취소">
		                  <input class="btn btn-dark mt-3" type="submit" value="가입">
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
</body>
</html>