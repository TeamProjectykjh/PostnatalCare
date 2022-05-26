<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/WEB-INF/views/summernote.jsp" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<script>
			// 이미지 업로드
			function PreviewImage() {
			       // 파일리더 생성 
			       var preview = new FileReader();
			       preview.onload = function (e) {
			       // img id 값 
			       document.getElementById("preview").src = e.target.result;
			   };
			   // input id 값 
			   preview.readAsDataURL(document.getElementById("imgfile").files[0]);
			};
		</script>
		<body>
			<form action="docmodifysave" method="post" enctype="multipart/form-data">
				<c:forEach items="${docinfo}" var="doc">
				<label class="form-label" style="margin-top: 3%; font-size: 25px; font-weight: bold;">${name} 의사님
						프로필 수정</label>
				<div class="mb-3">  
				  <label for="imgfile"><img src="doctorimg/${doc.docpath }" id="preview" height="400px" width="300px" class="img-thumbnail"></label>
				  <input type="file" id="imgfile" name="imgfile" style="display:none" onchange="PreviewImage();">
				</div>
				<div class="mb-3">
					<input type="hidden" name="docnum" value="${doc.docnum}">
 					
				</div>
				<div style="margin-bottom: 3%">
					<div class="input-group flex-nowrap">
						<span class="input-group-text" id="addon-wrapping">면허 이름</span>
						<input name="doclicensename" type="text" class="form-control" placeholder="의사면허 명을 입력해주세요."
							aria-label="Username" aria-describedby="addon-wrapping" value="${doc.doclicensename}">
					</div>
					<div class="input-group flex-nowrap">
						<span class="input-group-text" id="addon-wrapping">면허 번호</span>
						<input name="docserial" type="text" class="form-control" placeholder="면허 시리얼번호를 입력해주세요."
							aria-label="Username" aria-describedby="addon-wrapping" value="${doc.docserial}">
					</div>
				</div>

				<div class="mb-3">
					<label for="docrecord" class="form-label" style=" font-size: 20px; font-weight: bold;">경력사항
						입력</label>
					<textarea class="form-control" id="doctorcareer" name="docrecord">${doc.docrecord}</textarea>
					<script>
						$('#doctorcareer').summernote({
							toolbar: [
								// 글꼴 설정
								['fontname', ['fontname']],
								// 글자 크기 설정
								['fontsize', ['fontsize']],
								// 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
								['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
								// 글자색
								['color', ['forecolor', 'color']],
								// 표만들기
								['table', ['table']],
								// 글머리 기호, 번호매기기, 문단정렬
								['para', ['ul', 'ol', 'paragraph']],
								// 줄간격
								['height', ['height']],
								// 그림첨부, 링크만들기, 동영상첨부
								['insert', ['link']]
							],
							// 추가한 글꼴
							fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋음체', '바탕체'],
							// 추가한 폰트사이즈
							fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
							placeholder: '경력을 입력해주세요.',
							tabsize: 15,
							minHeight: 500,             // set minimum height of editor
							maxHeight: 500,
							height: 500,
							lang: 'ko-KR' // 기본 메뉴언어 US->KR로 변경
						});
					</script>
				</div>
				<br>
				<div class="mb-3">
					<label for="content" class="form-label" style=" font-size: 20px; font-weight: bold;">의사소개</label>
					<textarea class="form-control" id="content" name="doctorcontent">${doc.doctorcontent}</textarea>
					<script>
						$('#content').summernote({
							toolbar: [
								// 글꼴 설정
								['fontname', ['fontname']],
								// 글자 크기 설정
								['fontsize', ['fontsize']],
								// 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
								['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
								// 글자색
								['color', ['forecolor', 'color']],
								// 표만들기
								['table', ['table']],
								// 글머리 기호, 번호매기기, 문단정렬
								['para', ['ul', 'ol', 'paragraph']],
								// 줄간격
								['height', ['height']],
								// 그림첨부, 링크만들기, 동영상첨부
								['insert', ['link']]
							],
							// 추가한 글꼴
							fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋음체', '바탕체'],
							// 추가한 폰트사이즈
							fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
							placeholder: '자기소개 입력해주세요.',
							tabsize: 15,
							minHeight: 500,             // set minimum height of editor
							maxHeight: 500,
							height: 500,
							lang: 'ko-KR' // 기본 메뉴언어 US->KR로 변경ss
						});
					</script>
				</div>
				<input style="margin-bottom: 8%" type="submit" value="수정" class="btn btn-success">
				<input style="margin-bottom: 8%" type="button" value="취소" onclick='history.back(); return false;'
					class="btn btn-warning">
			</c:forEach>
			</form>
		</body>

		</html>