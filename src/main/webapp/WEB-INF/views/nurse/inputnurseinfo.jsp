<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/summernote.jsp" %>
<!DOCTYPE html>
<html>
<jsp:include page="cdn.jsp"/>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!--회원가입한 정보에서 전화번호,이름을 불러올수 있어야 하고
		한번 등록한 회원은 두번 중복등록을 못하게끔 설정해야함
		사진, 자격증 번호, 경력(섬머 노트 활용) 입력  -->
	<body>
		<h4 style="text-align: center; padding-top: 20px;">간호사 정보 입력</h4>
			<form action="nurseinfonext" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${usernum }">
			    <div class="mb-3">
			        <label class="form-label" >사진</label>
			        <input type="file"  name="nurpath" class="form-control" placeholder="nurpath">
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >전화번호</label>
			        <input type="text"  name="phone" class="form-control" 
			        value="${userphone }" readonly>
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >이름</label>
			        <input type="text"  name="name" class="form-control" 
			        value="${username }" readonly>
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >자격증 이름</label>
			        <input type="text"  name="nurlicensename" class="form-control" placeholder="nurlicensename">
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >자격증 번호</label>
			        <input type="text"  name="nurserial" class="form-control" placeholder="nurserial">
			    </div>
			    <div class="mb-3">
					<label for="nurrecord" class="form-label" style=" font-size: 20px; font-weight: bold;">경력사항
						입력</label>
					<textarea class="form-control" id="nurrecord" name="nurrecord"></textarea>
					<script>
						$('#nurrecord').summernote({
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
					<label for="nurcontent" class="form-label" style=" font-size: 20px; font-weight: bold;">간호사 소개</label>
					<textarea class="form-control" id="nurcontent" name="nurcontent"></textarea>
					<script>
						$('#nurcontent').summernote({
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

			    <input type="submit" class="btn btn-primary" value="완료" 
			    style="margin-bottom: 8%;"></input>
			    <input type="button" class="btn btn-primary" value="취소" 
			    style="margin-bottom: 8%;" onclick="history.back(); return false;"></input>
			</form>		
	</body>
</html>