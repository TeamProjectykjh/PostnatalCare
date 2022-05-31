<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"> 
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,800,900');
.pricing:checked + label,
.pricing:not(:checked) + label{
  top: 40px;
  position: relative;
  display: block;
  text-align: center;
  width: 260px;
  height: 44px;
  border-radius: 4px;
  padding: 0;
  margin: 0 auto;
  cursor: pointer;
  font-family: 'Poppins', sans-serif;
  font-weight: 600;
  text-transform: uppercase;
  font-size: 14px;
  letter-spacing: 1px;
  line-height: 44px;
  padding: 0 25px;
  padding-right: 27px;
  overflow: hidden;
  color: #fff;
  text-align: left;
}
.pricing:checked + label:before,
.pricing:not(:checked) + label:before{
  position: absolute;
  content: '';
  z-index: -2;
  background-color: #102770;
  width: 100%;
  height: 100%;
  display: block;
  top: 0;
  left: 0;
}
.pricing:checked + label:after,
.pricing:not(:checked) + label:after{
  position: absolute;
  content: '';
  z-index: -1;
  background-color: #f8f9fa;
  width: 128px;
  height: 40px;
  display: block;
  top: 2px;
  left: 2px;
  border-radius: 2px;
  transition: left 300ms linear;
}
.pricing:checked + label:after {
  left: 130px;
}
.block-diff {
  display: block;
  mix-blend-mode: difference;
}

.card-3d-wrap {
  position: relative;
  width: 340px;
  max-width: calc(100% - 20px);
  height: 510px;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  perspective: 1000px;
  margin-top: 90px;
}
.card-3d-wrapper {
  width: 100%;
  height: 100%;
  position:absolute;    
  top: 0;
  left: 0;  
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  transition: transform 700ms 400ms ease-out; 
}
.card-front, .card-back {
  width: 100%;
  height: 100%;
  background-color: gray;
  position: absolute;
  border-radius: 6px;
  left: 0;
  top: 0;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  -o-backface-visibility: hidden;
  backface-visibility: hidden;
}
.card-back {
  transform: rotateY(180deg);
}
.pricing:checked ~ .card-3d-wrap .card-3d-wrapper {
  transform: rotateY(180deg);
  transition: transform 700ms 400ms ease-out; 
}
.pricing-wrap{
  position: relative;
  padding-top: 60px;
  width: 100%;
  display: block;
}
.link {
  top: 430px;
  left: 130px;
  text-decoration: none;
  position: fixed;
  padding: 10px 20px;
  border-radius: 4px;
  display: inline-block;
  text-align: center;
  color: #ffeba7;
  background-color: #0c1c00;
  transition: all 200ms linear;
  font-family: 'Poppins', sans-serif;
  font-weight: 500;
  font-size: 14px;
  line-height: 1.2;
  transform: translate3d(0, 0, 30px) perspective(100px);
}
.link:hover {
  color: #102770;
  background-color: #ffeba7;
}
.card-back .link{
  background-color: #0c1c00;
}
.card-back .link:hover{
  color: #102770;
  background-color: #ffeba7;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input class="pricing" type="checkbox" id="pricing" name="pricing" style="display: none;"/>
<label for="pricing"><span class="block-diff">관리사정보&emsp;&emsp;&emsp;&emsp;&emsp;<span class="float-right">자격증</span></span></label>
	<div class="card-3d-wrap mx-auto">
		<div class="card-3d-wrapper">	
			<div class="card-front">
			<h2>${name.name}님</h2>
			<img src="sanhuimg/${name.sanhupath }" style="width: 300px; height: 350px;">
				<div class="pricing-wrap">
					<a href="sanhumodify" class="link">수&emsp;정</a>
			    </div>
			</div>
				<div class="card-back">
				<h2>${name.name}님</h2>
					<div class="pricing-wrap">
					<c:choose>
						<c:when test="${!empty licenselist}">
							<h2>자격증</h2>
							<br>
							<c:set var="loop_flag" value="false" />
							<c:forEach items="${licenselist }" var="list" varStatus="status">
								<c:if test="${not loop_flag }">
									<h4><label>º ${list.liname }</label></h4><br>
									<c:if test="${status.count eq 3}">
										<h4>외...</h4>
										<c:set var="loop_flag" value="true" />
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<br><br>
							<h2><label>자격증이 없습니다.</label></h2><br>
						</c:otherwise>
					</c:choose>
					<a href="sanhulicense" class="link">수&emsp;정</a>
			      	</div>
			    </div>
		</div>
</div>
</body>
</html>