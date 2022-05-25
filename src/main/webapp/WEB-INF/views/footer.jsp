<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
setInterval("nowTime()",500);
function nowTime(){
   var now = new Date();
   	month = now.get
    hours = now.getHours();
    minutes = now.getMinutes();
    seconds = now.getSeconds();
    
    if (hours < 10){
    	hours = "0" + hours;
    }
    if (minutes < 10){
    	minutes = "0" + minutes;
    }
    if (seconds < 10){
    	seconds = "0" + seconds;
    }
document.getElementById("nowTime").innerHTML = hours + "시 " + minutes + "분 " + seconds + "초 ";
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
footer <span style="font-size: large;" id="nowTime"></span>
</body>
</html>