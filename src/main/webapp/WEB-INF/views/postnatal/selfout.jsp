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
<div style="margin: 40px" class="row">
<span class="col-sm-3"></span>
<h3 style="margin-top: 20px" align="center">일일문진표내역</h3>
	  <div style="margin: 40px" class="row">
	          <span class="col-sm-3" style="center;">
		        <span class="input-group">
				  <span class="input-group-text">이름</span>
				  <c:forEach items="${list}" var="sanmo">
				  <input type="text" class="form-control" readonly="readonly" value="${sanmo.name }">
				</c:forEach>
				</span>
	          </span>
	          
	          
	           <span class="col-sm-3" style="center;">
	     	 	<span class="input-group">
				  <span class="input-group-text">담당의사</span>
				  <c:forEach items="${dlist}" var="dl">
				  <input type="text" class="form-control" readonly="readonly" value="${dl.name }" style="text-align: center;">
				</c:forEach>
				</span>
	          </span>
	          
	          
	          <span class="col-sm-3" style="center;">
	     	 	<span class="input-group">
				  <span class="input-group-text">담당간호사</span>
				  <c:forEach items="${nlist}" var="nl">
				  <input type="text" class="form-control" readonly="readonly" value="${nl.name }" style="text-align: center;">
				</c:forEach>
				</span>
	          </span>
		</div>
</div>			         
<div style="margin: 40px" class="row">

	  		<table align="center" style="text-align: center; width: 70%" class="table table-striped table-hover">
				  <tr>
				  		<th>작성일자</th>
				  </tr>
			   <c:forEach items="${qlist}" var="q">
				  <tr>
				  		<td>
				  			<a href="detail?qusnum=${q.qusnum }">
				  				${q.qusday}
				  			</a>
				  		</td>
				  </tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>