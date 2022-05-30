<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

//아래 코드로 경로(URL)를 찾을수도있다
//var hostIndex = location.href.indexOf( location.host ) + location.host.length;
//var getContextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );

function multidel(){
	  var checkBoxArr = []; 
	  $("input:checkbox[name='options']:checked").each(function() {
	  checkBoxArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
	})
	$.ajax({
	      type  : "POST",
	      url    : "<c:url value='/checkboxdel'/>",
	      data: {
	      checkBoxArr : checkBoxArr        // folder seq 값을 가지고 있음.
	      } ,
	      success: function(result){
	        	location.reload();
	        },
	        error: function(xhr, status, error) {
	        	alert(error);
	        }  
	   });
}

$(document).ready(function(){
   //툴팁 활성화
   $('[data-toggle="tooltip"]').tooltip();
   
   //체크박스 전체 선택 / 해제
   var checkbox = $('table tbody input[type="checkbox"]');
   $("#selectAll").click(function(){
      if(this.checked){
         checkbox.each(function(){
            this.checked = true;                        
         });
      } else{
         checkbox.each(function(){
            this.checked = false;                        
         });
      } 
   });
   checkbox.click(function(){
      if(!this.checked){
         $("#selectAll").prop("checked", false);
      }
   });
});

//modal창에 값 전달
$(document).ready(function () {
    $(".edit").click(function () {
        $('#modilinum').val($(this).data('id'));
        $('#modiliname').val($(this).data('name'));
        $('#modilicode').val($(this).data('code'));
    });
});
</script>
</head>
  <body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row" style="margin-top: 3%;">
                  <div class="col-sm-6">
                  <h2>자격증 관리</h2>
              	  </div>
               
               <div class="col-sm-6">
                  <a href="#addEmployeeModal" class="btn btn-success" data-bs-toggle="modal" style="float: right; margin-left: 10px;"><span>자격증 추가</span></a>
                  <button onclick="multidel()" class="btn btn-danger" style="float: right; margin-left: 10px;"><span>선택삭제</span></button>   
                  <!-- <a href="comdel?num=${com.num}" class="btn btn-danger btn-sm" onclick="if(!confirm('정말 삭제하시겠습니까?')) return false">삭제</a> -->
                  <!-- if(!confirm('정말 수정하시겠습니까?')) return false -->               
               </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                  <th>
                     <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                     </span>
                  </th>
                        <th>자격증 이름</th>
                        <th>자격증 코드</th>
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${licenselist }" var="list">
                    <tr>
                  <td>
                     <span class="custom-checkbox">
                        <input type="checkbox" id="checkbox" name="options" value="${list.linum }">
                        <label for="checkbox"></label>
                     </span>
                  </td>
                        <td>${list.liname }</td>
                        <td>${list.licode }</td>
                        <td>
                            <a href="#editEmployeeModal" class="edit" data-bs-toggle="modal" data-id="${list.linum }" data-name="${list.liname }" data-code="${list.licode }">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="licensedel?linum=${list.linum }" onclick="if(!confirm('정말 삭제하시겠습니까?')) return false"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
   
   <div id="addEmployeeModal" class="modal hide fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
            <form action="licensesave" method="post">
               <div class="modal-header">                  
                  <h4 class="modal-title">자격증 추가</h4>
                  <button type="reset" class="close" data-bs-dismiss="modal" aria-hidden="true">&times</button>
               </div>
               <div class="modal-body">               
                  <div class="form-group">
                     <label>이름</label>
                     <input type="text" class="form-control" name="name" required>
                  </div>
                  <div class="form-group">
                     <label>코드</label>
                     <input type="text" class="form-control" name="code" required>
                  </div>            
               </div>
               <div class="modal-footer">
                  <input type="reset" class="btn btn-default" data-bs-dismiss="modal" value="취소">
                  <input type="submit" class="btn btn-success" value="저장">
               </div>
            </form>
         </div>
      </div>
   </div>
   
   
   <div id="editEmployeeModal" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
            <form action="licensemodi" method="post">
               <div class="modal-header">                  
                  <h4 class="modal-title">자격증 수정</h4>
                  <button type="reset" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
               </div>
               <div class="modal-body">               
                  <div class="form-group">
                  <input type="hidden" name="modilinum" id="modilinum" value="">
                     <label>이름</label>
                     <input type="text" value="" class="form-control" name="modiliname" id="modiliname" required>
                  </div>
                  <div class="form-group">
                     <label>코드</label>
                     <input type="text" value="" class="form-control" name="modilicode" id="modilicode" required>
                  </div>               
               </div>
               <div class="modal-footer">
                  <input type="reset" class="btn btn-default" data-bs-dismiss="modal" value="취소">
                  <input type="submit" class="btn btn-info" value="저장">
               </div>
            </form>
         </div>
      </div>
   </div>
   
</body>
</html>