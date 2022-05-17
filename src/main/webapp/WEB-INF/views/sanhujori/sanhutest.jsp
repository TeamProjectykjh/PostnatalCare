<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/summernote.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<h2>게시글 목록</h2>
	<table border="1" width="500">
		<tr>
			<th>내용</th>
		</tr>
			<tr>
				<td name="content" id="summernote">${list.content}</td>
			</tr>
	
	</table>
	    <script>
//         $(document).ready(function() {
//           $("#summernote").summernote({
//               height:350
//           });
//         });
        $("#summernote").summernote("destroy");
    </script>
</body>
</html>