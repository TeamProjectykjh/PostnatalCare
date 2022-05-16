<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="sanhumakesave" method="post">
<div class="mb-3">
  <label for="usernum" class="form-label">유저 번호</label>
  <input type="text" readonly class="form-control-plaintext" id="usernum" name="usernum" value="${usernum}">
</div>
<div class="mb-3">
  <label for="sanhurecord" class="form-label">경력</label>
  <textarea class="form-control" id="sanhurecord" name="sanhurecord" name="sanhurecord" rows="5" placeholder="경력을 입력해주세요"></textarea>
</div>
<div class="mb-3">
  <label for="content" class="form-label">자기소개</label>
  <textarea class="form-control" id="sanhurecord" name="content" name="content" rows="5" placeholder="간단한 자기소개를 입력해주세요"></textarea>
</div>
<div class="mb-3">
  <label for="formFile" class="form-label">산후관리사 사진</label>
  <input class="form-control" type="file" id="formFile">
</div>
<input type="submit" value="전송" class="btn btn-success">
<input type="button" value="취소" onclick="location.href='sanhugg'" class="btn btn-warning">
</form>
</body>
</html>