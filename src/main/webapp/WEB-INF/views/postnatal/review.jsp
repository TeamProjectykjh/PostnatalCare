<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

fieldset, label { margin: 0; padding: 0; }

.rating { 
  border: none;
  float: left;
}

.rating > input { display: none; } 
.rating > label:before { 
  margin: 3px;
  font-size: 1.25em;
  font-family: FontAwesome;
  display: inline-block;
  content: "\f005";
}

.rating > .half:before { 
  content: "\f089";
  position: absolute;
}

.rating > label { 
  color: #ddd; 
 float: right; 
}

.rating > input:checked ~ label, /* show gold star when clicked */
.rating:not(:checked) > label:hover, /* hover current star */
.rating:not(:checked) > label:hover ~ label { color: #FFD700;  } /* hover previous stars in list */

.rating > input:checked + label:hover, /* hover current star when changing rating */
.rating > input:checked ~ label:hover,
.rating > label:hover ~ input:checked ~ label, /* lighten current selection */
.rating > input:checked ~ label:hover ~ label { color: #FFED85;  } 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reviewsave">
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
	
                  <div align="center" class="h6 fw-bold mb-0">후기작성</div>
                	      
                	  <!-- 고용번호,산모번호,산후조리사번호-->
	                   <div class="form-outline mb-1">
	                  <c:forEach items="${elist }" var="el">
	                  	<input name="employnum" type="hidden" value="${el.employnum }"/>
	                    <input name="posnum" type="hidden" value="${el.posnum }"/> 
	                    <input name="sanhunum" type="hidden" value="${el.sanhunum }"/>
	                    </c:forEach>  
	                  </div>
             
	                  <div class="form-outline mb-1">
	                  	<label class="form-label">산모이름</label>
	                  <c:forEach items="${list }" var="sanmo">
	                    <input  class="form-control form-control-sm" value="${sanmo.name }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach>  
	                  </div>
	                  	
					<div class="form-outline mb-1">
	                  	<label class="form-label">고용시작일</label>
	                  <c:forEach items="${elist }" var="el">
	                    <input  class="form-control form-control-sm" value="${el.empstartday }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach>  
	                    <label class="form-label">고용종료일</label>
	                  <c:forEach items="${elist }" var="el">
	                    <input  class="form-control form-control-sm" value="${el.empendday }" readonly="readonly" style="text-align: center;"/> 
	                    </c:forEach>  
	                  </div>	
						

					<fieldset style="margin-left: 37%" class="rating">
						    <input type="radio" id="star5" name="rating" value="5" />
						    <label class = "full" for="star5"></label>
						    
						    <input type="radio" id="star4half" name="rating" value="4.5" />
						    <label class="half" for="star4half"></label>
						    
						    <input type="radio" id="star4" name="rating" value="4" />
						    <label class = "full" for="star4"></label>
						    
						    <input type="radio" id="star3half" name="rating" value="3.5" />
						    <label class="half" for="star3half"></label>
						    
						    <input type="radio" id="star3" name="rating" value="3" />
						    <label class = "full" for="star3"></label>
						    
						    <input type="radio" id="star2half" name="rating" value="2.5" />
						    <label class="half" for="star2half"></label>
						    
						    <input type="radio" id="star2" name="rating" value="2" />
						    <label class = "full" for="star2"></label>
						    
						    <input type="radio" id="star1half" name="rating" value="1.5" />
						    <label class="half" for="star1half"></label>
						    
						    <input type="radio" id="star1" name="rating" value="1" />
						    <label class = "full" for="star1"></label>
						    
						    <input type="radio" id="starhalf" name="rating" value="0.5" />
						    <label class="half" for="starhalf"></label>
						</fieldset><br><br>
							
					<div class="form-outline mb-1">
	                   <label class="form-label">후기작성</label><br>
	                   <textarea name="ment" rows="10" cols="20" class="form-control form-control-sm"></textarea>
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