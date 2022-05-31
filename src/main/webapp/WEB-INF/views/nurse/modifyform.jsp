<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/summernote.jsp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<jsp:include page="cdn.jsp"></jsp:include>
<head>
	<style type="text/css">
	body{background-color:#FFEBEE}
	.card{width:1200px;background-color:#fff;border:none;border-radius: 12px}
	label.radio{cursor: pointer;width: 100%}
	label.radio input{position: absolute;top: 0;left: 0;visibility: hidden;pointer-events: none}
	label.radio span{padding: 7px 14px;border: 2px solid #eee;display: inline-block;
	color: #039be5;border-radius: 10px;width: 100%;height: 48px;line-height: 27px}
	label.radio input:checked+span{border-color: #039BE5;background-color: #81D4FA;
	color: #fff;border-radius: 9px;height: 48px;line-height: 27px}
	.form-control{margin-top: 10px;height: 48px;border: 2px solid #eee;border-radius: 10px}
	.form-control:focus{box-shadow: none;border: 2px solid #039BE5}
	.agree-text{font-size: 12px}.terms{font-size: 12px;text-decoration: none;color: #039BE5}
	.confirm-button{height: 50px;border-radius: 10px}</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
	<script type="text/javascript">
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
		<form action="modifysave" method="post" enctype="multipart/form-data">
		<c:forEach items="${mlist }" var="nur">
		
		<div class="container mt-5 mb-5 d-flex justify-content-center">		
		    <div class="card px-1 py-4">
		        <div class="card-body">
		        	<h4>${name } 간호사님의 정보 수정</h4><br>
		        	
		        	<div class="row">
		        		<div class="col-sm-12">
		        			 <div class="form-group">
    					 <label for="imgfile"><img src="nurseimg/${nur.nurpath }" id="preview" height="400px" width="300px" 
			class="img-responsive img-thumbnail"></label>
				 		<input type="file" id="imgfile" name="imgfile" style="display:none" onchange="PreviewImage();">				 		
							</div>
						</div>
					</div>
					
					 <div class="row">
		                <div class="col-sm-12">
		                    <div class="form-group">
		                    <input type="hidden"  name="nurnum" value="${nur.nurnum }"></div></div></div>
					
		            <div class="row">
		                <div class="col-sm-12">
		                    <div class="form-group">
		                        자격증 이름<input class="form-control" type="text" value="${nur.nurlicensename }" 
		                        style="text-align: center;" name="nurlicensename"> </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-sm-12">
		                    <div class="form-group">자격증 번호
		                        <div class="input-group"> 
		                       <input class="form-control" type="number" value="${nur.nurserial }"
		                       style="text-align: center;" name="nurserial"> </div>
		                    </div>
		                </div>
		            </div>
		           
		            <div class="row">
		                <div class="col-sm-12">
		                    <div class="form-group">경력사항
		                        <label for="nurrecord" class="form-label" style=" font-size: 20px; font-weight: bold;"></label>
								<textarea class="form-control" id="nurrecord" name="nurrecord">${nur.nurrecord }</textarea>
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
										minHeight: 300,             // set minimum height of editor
										maxHeight: 500,
										height: 300,
										lang: 'ko-KR' // 기본 메뉴언어 US->KR로 변경
									});
								</script>
		                    </div>
		                </div>
		            </div>
		            
		             <div class="row">
		                <div class="col-sm-12">
		                    <div class="form-group">간호사 소개
		                        <label for="nurcontent" class="form-label" style=" font-size: 20px; font-weight: bold;"></label>
								<textarea class="form-control" id="nurcontent" name="nurcontent">${nur.nurcontent }</textarea>
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
										placeholder: '경력을 입력해주세요.',
										tabsize: 15,
										minHeight: 300,             // set minimum height of editor
										maxHeight: 500,
										height:300,
										lang: 'ko-KR' // 기본 메뉴언어 US->KR로 변경
									});
								</script>
		                    </div>
		                </div>
		            </div>
		            <div class=" d-flex flex-column text-center px-5 mt-3 mb-3"></div> 
		            <input type="submit" class="btn btn-primary btn-block confirm-button" value="수정완료" style="width: 100px;">
		        </div>
		    </div>
		</div>
			</c:forEach>
		</form>
	</body>
</html>