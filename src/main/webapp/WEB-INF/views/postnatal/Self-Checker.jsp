<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	
	                <form action="newsign" method="post">

	                  <div align="center" class="h6 fw-bold mb-0">문진표</div>
	                  
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">작성번호</label>
	                    <input name="" class="form-control form-control-sm" />   
	                  </div>
	
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모번호</label>
	                    <input name="" class="form-control form-control-sm" />
	                  </div>	              
	                  
	                  <div class="form-outline mb-1">
	                   <label class="form-label">작성일자</label>
	                   <input type="date" name="age" class="form-control form-control-sm" />
	                  </div>
	                  
	                  <div class="form-outline mb-1">
	                    <label class="form-label">작성내용</label>
	                    <textarea rows="10" cols="20" name="content" class="form-control form-control-sm">
	                    </textarea>
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
</body>
</html>