<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   // Activate tooltip
   $('[data-toggle="tooltip"]').tooltip();
   
   // Select/Deselect checkboxes
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

$('#modal').modal("hide");

//https://truecode-95.tistory.com/70
/*
function DelClick(){
     var checkBoxArr = []; 
     $("input:checkbox[name='options']:checked").each(function() {
     checkBoxArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
     console.log(checkBoxArr);
   })
   $.ajax({
         type  : "POST",
         url    : "checkboxdel",
         data: {
         checkBoxArr : checkBoxArr        // folder seq 값을 가지고 있음.
         },
         success: function(result){
            console.log(result);
         },
         error: function(xhr, status, error) {
            alert(error);
         }  
      });
   }
*/
//**참고
//form 안에 동일한 name의 파라미터가 있다면 form태그가 자동으로 배열로 만들어버립니다 
//자바 서버에서 문자열로 받아보면 name의 개수만큼 [ , ] 로 값이 이어진 것을 받아볼 수 있습니다
//https://okky.kr/article/686721

//https://blog.naver.com/lanslot5/221228750513

//String[] brdID = request.getParameterValues("chklst"); 배열로 받기
// for(int i =0 ; i < chk.length ; i++)
//           {
//            String sqlString = "delete from student where sno="+chk[i];
//            stmt.executeUpdate(sqlString);
//            out.println("<h2>"+sqlString+"</h2>");
//          }

</script>
</head>
  <body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                  <h2>자격증 관리</h2>
               </div>
               
               <div class="col-sm-6">
                  <a href="#addEmployeeModal" class="btn btn-success" data-bs-toggle="modal" style="float: right; margin-left: 10px;"><span>자격증 추가</span></a>
                  <a onclick="DelClick()" class="btn btn-danger" data-toggle="modal" style="float: right; margin-left: 10px;"><span>선택삭제</span></a>   
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
                <c:forEach>
                    <tr>
                  <td>
                     <span class="custom-checkbox">
                        <input type="checkbox" id="checkbox" name="options" value="">
                        <label for="checkbox"></label>
                     </span>
                  </td>
                        <td>Thomas Hardy</td>
                        <td>thomashardy@mail.com</td>
                        <td>
                            <a href="#editEmployeeModal" class="edit" data-bs-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="licensedel" class="delete" data-bs-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
                  <h4 class="modal-title">수정</h4>
                  <button type="reset" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
               </div>
               <div class="modal-body">               
                  <div class="form-group">
                     <label>이름</label>
                     <input type="text" value="" class="form-control" name="name" required>
                  </div>
                  <div class="form-group">
                     <label>코드</label>
                     <input type="text" value="" class="form-control" name="code" required>
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