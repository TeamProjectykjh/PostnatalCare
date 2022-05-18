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
			    <div class="mb-3">
			        <label class="form-label" >사진</label>
			        <input type="file"  name="nurpath" class="form-control" placeholder="nurpath">
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >전화번호</label>
			        <input type="text"  name="phone" class="form-control" 
			        placeholder="pos_user 테이블에서 가져와야 하는 값(join)">
			    </div>
			    <div class="mb-3">
			        <label class="form-label" >이름</label>
			        <input type="text"  name="name" class="form-control" 
			        placeholder="pos_user 테이블에서 가져와야 하는 값(join)">
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
			        <label class="form-label" >경력</label>
			        	<textarea name="nurrecord" id="nurrecord" class="summernote"></textarea>			    		
			    </div>	
			    	<script> $(document).ready(function(){ 
			    		$('.summernote').summernote({ 
			    			height: 300, 
			    			minHeight: null, 
			    			maxHeight: null, 
			    			lang : 'ko-KR', 
			    			onImageUpload: function(files, editor, welEditable) 
			    			{ sendFile(files[0], editor, welEditable); 
			    			} 			    		
			    		});			    	
			    	}); 
			    	</script>

			    <input type="submit" class="btn btn-primary" value="완료"></input>
			</form>		
	</body>
</html>