<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://technext.github.io/zay-shop/assets/css/fontawesome.min.css" rel="stylesheet">
<link href="https://technext.github.io/zay-shop/assets/css/templatemo.css" rel="stylesheet">

<style type="text/css">
/*** Service ***/
.service-item {
    box-shadow: 0 0 45px rgba(0, 0, 0, .07);
    border: 1px solid transparent;
    transition: .5s;
}

.service-item:hover {
    margin-top: -10px;
    box-shadow: none;
    border: 1px solid #DEE2E6;
}
</style>
</head>
<body>
			<h1 align="center">현재 담당산모님</h1>
			<div class="row g-4 mb-5">
			<c:forEach items="${myposlist}" var="list">
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/selfout?num=${list.num}">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh1_zF2hUecAEuRKlVqdvxzRK1sL8Cf01INg&usqp=CAU" alt="">
                        <h4 style="color: black" class="mb-0">${list.name} 산모님</h4>
                    </a>
                </div>
                 </c:forEach>
            </div>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>