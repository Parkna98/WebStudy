<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- xeicon -->
<style>
.stayname{
	white-space: nowrap; /* 텍스트가 줄바꿈되지 않도록 함 */ 
	overflow: hidden; /* 초과된 텍스트를 감추기위해 오버플로우를 숨김 */
	text-overflow: ellipsis; /* 말줄임표 만드는 속성 */
}
.stayfont{
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../img/bread.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Hotel With Dogs</h2>
                        <div class="breadcrumb__option">
                            <a href="../main/main.do">Home</a>
                            <span>Hotel</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar staylistside">
                        <div class="sidebar__item" style="margin-top: 110px;border: 1px solid #5a70e9; border-radius: 10px;" >
                        <div style="height: 25px"></div>
                            <h4 style="margin-left: 10px">Department</h4>
                            <ul>
                                <li style="margin-left: 10px"><a href="#">Hotel</a></li>
                                <li style="margin-left: 10px"><a href="#">Camping</a></li>
                                <li style="margin-left: 10px"><a href="#">Pension</a></li>
                                <li style="margin-left: 10px"><a href="#">Motel</a></li>
                            </ul>
                        <div style="height: 30px"></div>
                        </div>
                         <div class="sidebar__item" style="margin-top: 150px">
                            <div class="latest-product__text">
                                <h4>Latest Products</h4>
                                <div class="latest-product__slider owl-carousel">
                                <c:if test="${count==0 }">
                                  <div class="latest-prdouct__slider__item">
                                    <a href="#" class="latest-product__item">
                                     <div class="latest-product__item__pic">
                                     </div>
                                     <div class="latest-product__item__text">
                                        <h6>방문기록이 없습니다</h6>
                                        <span class="stayname"></span>
                                     </div>
                                    </a>
                                  </div>
                                  <div>
                                </c:if>
                                
                                
                                <c:if test="${count!=0 }">
                                
                                <c:forEach var="vo" items="${stcList }" varStatus="status">
                                 <c:choose>
                                  <c:when test="${status.first}">
                                    <div class="latest-prdouct__slider__item">
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${vo.image }" alt="" style="border-radius: 10px;overflow: hidden;">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6 class="stayname">${vo.name }</h6>
                                                <h6 class="stayname stayfont">&#8361;${vo.price }~</h6>
                                            </div>
                                        </a>
                                   </c:when>
                                   <c:when test="${status.index%3 eq 0}">
                                     </div>
                                     <div class="latest-prdouct__slider__item">
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${vo.image }" alt="" style="border-radius: 10px;overflow: hidden;">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6 class="stayname">${vo.name }</h6>
                                                <h6 class="stayname stayfont">&#8361;${vo.price }~</h6>
                                            </div>
                                        </a>
                                   </c:when>
                                   <c:otherwise>
                                     <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${vo.image }" alt="" style="border-radius: 10px;overflow: hidden;">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6 class="stayname">${vo.name }</h6>
                                                <h6 class="stayname stayfont">&#8361;${vo.price }~</h6>
                                            </div>
                                        </a>
                                   </c:otherwise>
                                  </c:choose>
                                 </c:forEach>
                                 
                                 </c:if>
                                 </div>
                                 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>인기 숙소</h2>
                        </div>
                        <div class="row">
                            <div class="product__discount__slider owl-carousel">
                              <c:forEach var="tvo" items="${toplist }">
                                <div class="col-lg-4">
                                    <div class="product__discount__item">
                                        <div class="product__discount__item__pic set-bg"
                                            data-setbg="${tvo.image }" style="border-radius: 10px;overflow: hidden;">
                                            <div class="product__discount__percent">HOT</div>
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__discount__item__text">
                                            <span>${tvo.type }</span>
                                            <h5 class="stayname"><a href="#">${tvo.name }</a></h5>
                                            <div class="product__item__price">&#8361;${tvo.price }~</div>
                                        </div>
                                    </div>
                                </div>
                               </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Sort By</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="0">Default</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span>16</span> Products found</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                                <div class="filter__option">
                                    <span class="icon_grid-2x2"></span>
                                    <span class="icon_ul"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                      <c:forEach var="vo" items="${list }">
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${vo.image }" style="border-radius: 10px;overflow: hidden;">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6 class="stayname"><a href="../stay/detail_before.do?stayno=${vo.stayno }">${vo.name }</a></h6>
                                    <h5>&#8361;${vo.price }~</h5>
                                </div>
                            </div>
                        </div>
                      </c:forEach>
                    </div>
                    <div class="text-center">
                    <div class="product__pagination">
                    <c:if test="${startPage>1 }">
                        <a href="../stay/list.do?page=${startPage-1 }"><i class="fa fa-long-arrow-left"></i></a>
                    </c:if>
                    	<c:forEach var="i" begin="${startPage }" end="${endPage }">
                        <a href="list.do?page=${i}" ${i==curpage?"class=active":"" }>${i}</a>
                        </c:forEach>
                    <c:if test="${endPage<totalpage }">
                        <a href="../stay/list.do?page=${endPage+1 }"><i class="fa fa-long-arrow-right"></i></a>
                    </c:if>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

</body>
</html>