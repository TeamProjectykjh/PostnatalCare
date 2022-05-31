<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cdn.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostnatalCare</title>
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
	                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; width: 100%;"/>
	            </div>
	            <div class="col-md-6 col-lg-7 d-flex align-items-center">
	              <div class="card-body p-4 p-lg-5 text-black">
	
	                <form action="userlogin" method="post">
	                  <div class="d-flex align-items-center mb-3 pb-1">
	                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
	                    <span class="h1 fw-bold mb-0">PostnatalCare</span>
	                  </div>
	
	                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">로그인</h5>
	
	                  <div class="form-outline mb-4">
	                  <label class="form-label" for="form2Example17">아이디</label>
	                    <input name="id" class="form-control form-control-lg" required/>
	                    
	                  </div>
	
	                  <div class="form-outline mb-4">
	                  <label class="form-label" for="form2Example27">비밀번호</label>
	                    <input type="password" name="password" class="form-control form-control-lg" required/>
	                  </div>
	
	                  <div class="pt-1 mb-4">
	                    <button style="display: inline;" class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
	  					<p style="display: inline; margin-left: 5em" class="mb-5 pb-lg-2" style="color: #393f81;">회원가입 
	  					<a style="color: #393f81;" href="signin" >클릭</a></p>
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