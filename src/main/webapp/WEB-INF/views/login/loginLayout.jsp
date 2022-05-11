<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles2" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#container{	border: 0px solid #bcbcbc;	}
#header{background-color: lightgreen;position: fixed;
top:0px;height:90px;line-height: 90px }
#body{	width:70%;text-align:center;
top:90px;height:80%;
margin-left:150px;
padding-left: 150px;	}
#footer{
clear:both;
width:100%;
height:40px;
line-height:30px;
font-size:15px;
color:#000000;
border : 0px solid  #bcbcbc;
background-color: #212529;
position: fixed;
bottom : 0;
text-align: center;
color: white;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
			<div id="logintop">
				<tiles2:insertAttribute name="logintop" /> 
			</div>
			<div id="loginbody">
				<tiles2:insertAttribute name="loginbody" /> 
			</div>
			<div id="loginfooter">
				<tiles2:insertAttribute name="loginfooter" /> 
			</div>

	</div>
</body>
</html>