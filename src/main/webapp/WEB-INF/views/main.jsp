<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="cdn.jsp"></jsp:include>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
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

<div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1" class=""></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2" class=""></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="https://cdn.imweb.me/thumbnail/20190520/5ce25c06cbeef.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h2 text-success">프리미엄 <b>1인실</b></h1>
                                <h3 class="h2">깔끔하고 편안한 분위기</h3>
                                <h3 class="h2">매일 2번 안심방역</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="https://previews.123rf.com/images/slasny/slasny1304/slasny130400662/19208705-%EC%9D%98%EC%82%AC%EA%B0%80-%EC%98%88%ED%9B%84%EB%A5%BC-%EA%B8%B0%EB%A1%9D%ED%95%98%EB%8A%94-%EC%9D%98%EB%A3%8C-%EC%B0%A8%ED%8A%B8.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1">대학병원</h1>
                                <h3 class="h2">산부인과 교수출신</h3>
                                <p><strong>최고의 의료진이</strong> 본 시설에 상주합니다
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="http://www.uclinic.kr/theme/basic/img/img33.png" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1">산후조리사</h1>
                                <h3 class="h2">1대1 맞춤 서비스</h3>
                                <p>첫날 부터 집에 귀가시 까지 내 아이는</p>
                                <p>오직 <strong>한명의 산후조리사</strong>가 돌봐줍니다.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>




	
			<div class="row g-4 mb-5">
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                    <s:forEach items="${userinfo}" var="user">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/doctorlist?name=${user.name}">
                        </s:forEach>
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1s-O8GtdOTLMs5y1LX9Z7k9q1pmCCuUP_5w&usqp=CAU" alt="">
                        <h4 style="color: black" class="mb-0">의사 소개</h4>
                    </a>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/nurselista?name=${user.names}">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://cdn-icons-png.flaticon.com/512/1165/1165602.png" alt="">
                        <h4 style="color: black" class="mb-0">간호사 소개</h4>
                    </a>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://technext.github.io/dgcom/img/service-3.jpg" alt="">
                        <h4 style="color: black" class="mb-0">옵션3</h4>
                    </a>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/info">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="data:image/png;base64,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" alt="">
                        <h4 style="color: black" class="mb-0">산후조리원 소개</h4>
                    </a>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/calendar">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9xqqQ6uCjsvQFaiDtevJssxlZsb4D28Ee3g&usqp=CAU" alt="">
                        <h4 style="color: black" class="mb-0">의료진 휴진일정</h4>
                    </a>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
                    <a style="text-decoration-line: none;" class="service-item d-block rounded text-center h-100 p-4" href="/PostnatalCare/address">
                        <img style="object-fit: cover; height: 70%;" class="img-fluid rounded mb-4" src="https://i.pinimg.com/originals/1c/6e/da/1c6eda8a6ffb92bb7fb141b478814401.png" alt="">
                        <h4 style="color: black;">오시는길</h4>
                    </a>
                </div>
            </div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>

</html>