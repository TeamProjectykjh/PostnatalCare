<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/summernote.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="sanhumodifysave" method="post" enctype="multipart/form-data">
<div class="mb-3">
  <label class="form-label" style="margin-top: 3%; font-size: 40px; font-weight: bold;">산후 관리사 - ${usernum}</label>
  <input type="hidden" name="usernum" value="${usernum}">
</div>
<div class="mb-3">
<label for="sanhurecord" class="form-label" style=" font-size: 20px; font-weight: bold;">경력</label>
<textarea class="form-control" id="sanhurecord" name="sanhurecord"></textarea>  
    <script>
      $('#sanhurecord').summernote({
    	  toolbar: [
  		    // 글꼴 설정
  		    ['fontname', ['fontname']],
  		    // 글자 크기 설정
  		    ['fontsize', ['fontsize']],
  		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
  		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
  		    // 글자색
  		    ['color', ['forecolor','color']],
  		    // 표만들기
  		    ['table', ['table']],
  		    // 글머리 기호, 번호매기기, 문단정렬
  		    ['para', ['ul', 'ol', 'paragraph']],
  		    // 줄간격
  		    ['height', ['height']],
  		    // 그림첨부, 링크만들기, 동영상첨부
  		    ['insert',['link']]
  		  ],
  		  // 추가한 글꼴
  		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
  		 // 추가한 폰트사이즈
  		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
        placeholder: '경력을 입력해주세요.',
        tabsize: 15,
        minHeight: 500,             // set minimum height of editor
        maxHeight: 500,
        height: 500,
        lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
      });
    </script>
</div>
<br>
<div class="mb-3">
  <label for="content" class="form-label" style=" font-size: 20px; font-weight: bold;">자기소개</label>
  <textarea class="form-control" id="content" name="content"></textarea>  
    <script>
      $('#content').summernote({
    	  toolbar: [
    		    // 글꼴 설정
    		    ['fontname', ['fontname']],
    		    // 글자 크기 설정
    		    ['fontsize', ['fontsize']],
    		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
    		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
    		    // 글자색
    		    ['color', ['forecolor','color']],
    		    // 표만들기
    		    ['table', ['table']],
    		    // 글머리 기호, 번호매기기, 문단정렬
    		    ['para', ['ul', 'ol', 'paragraph']],
    		    // 줄간격
    		    ['height', ['height']],
    		    // 그림첨부, 링크만들기, 동영상첨부
    		    ['insert',['link']]
    		  ],
    		  // 추가한 글꼴
    		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
    		 // 추가한 폰트사이즈
    		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
	        placeholder: '자기소개 입력해주세요.',
	        tabsize: 15,
	        minHeight: 500,             // set minimum height of editor
	        maxHeight: 500,
	        height: 500,
	        lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
      });
    </script>
</div>
<div class="mb-3">
  <label for="imgfile" class="form-label" style=" font-size: 20px; font-weight: bold;">산후관리사 사진</label>
  <input class="form-control" type="file" id="imgfile" name="imgfile">
</div>
<input style="margin-bottom: 8%" type="submit" value="전송" class="btn btn-success">
<input style="margin-bottom: 8%" type="button" value="취소" onclick="location.href='sanhugg'" class="btn btn-warning">
</form>
</body>
</html>