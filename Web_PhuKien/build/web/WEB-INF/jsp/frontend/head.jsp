<%-- 
    Document   : head
    Created on : Sep 23, 2022, 10:34:43 AM
    Author     : Admin
head
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="container-fluid">
                <div class="row bg-secondary py-2 px-xl-5">
                    <div class="col-lg-6 d-none d-lg-block">
                        <div class="d-inline-flex align-items-center">
                            <a class="text-dark" href="">FAQs</a>
                            <span class="text-muted px-2">|</span>
                            <a class="text-dark" href="">Help</a>
                            <span class="text-muted px-2">|</span>
                            <a class="text-dark" href="">Support</a>
                        </div>
                    </div>
                    <div class="col-lg-6 text-center text-lg-right">
                        <div class="d-inline-flex align-items-center">
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-instagram"></i>
                            </a>
                            <a class="text-dark pl-2" href="">
                                <i class="fab fa-youtube"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row align-items-center py-3 px-xl-5">
                    <div class="col-lg-3 d-none d-lg-block">
                        <a href="" class="text-decoration-none">
                            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                        </a>
                    </div>
                    <div class="col-lg-6 col-6 text-left">
                        <form action="/Web_PhuKien/tim-kiem" method="POST">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Tìm kiếm sản phẩm....."  name="ten">
                                <button type="submit" name="searchName" value="search" class="btn btn-primary px-3"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-3 col-6 text-right">
                        <a href="" class="btn border">
                            <i class="fas fa-heart text-primary"></i>
                            <span class="badge">0</span>
                        </a>
                        <a href="gio-hang" class="btn border">
                            <i class="fas fa-shopping-cart text-primary"></i>
                            <span class="badge">0</span>
                        </a>
                    </div>
                </div>
            </div>

 <div class="container-fluid">
                <div class="row border-top px-xl-5">
                    <div class="col-lg-3 d-none d-lg-block">
                         <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                            <h6 class="m-0">Danh Mục</h6>
                            <i class="fa fa-angle-down text-dark"></i>
                        </a>
                        <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                            <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                            <c:forEach var="dm" items="${danhmuc}">
                                <a href="" class="nav-item nav-link">${dm.tenDanhMuc}</a>
                            </c:forEach>
                        </div>
                    </nav>

                </div>
                <div class="col-lg-9">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="/Web_PhuKien/" class="nav-item nav-link active">Trang Chủ</a>
                                <a href="/Web_PhuKien/san-pham" class="nav-item nav-link">Sản Phẩm</a>
                                <a href="/Web_PhuKien/lien-he" class="nav-item nav-link">Liên Hệ</a>
                            </div>
                            <div class="navbar-nav ml-auto py-0">
                                <c:if test="${currentUser==null}">
                                    <a href="/Web_PhuKien/dang-nhap" class="nav-item nav-link">Đăng Nhập</a>
                                    <a href="/Web_PhuKien/dang-ky" class="nav-item nav-link">Đăng Ký</a>
                                </c:if>
                                <c:if test="${currentUser!=null}">
                                    <div class="btn-group ps-dropdown"><a  href="/Web_PhuKien/dang-xuat">${currentUser}</a></div>
                                        </c:if>
                            </div>
                        </div>
                </div>
                </nav>
            </div>
        </div>
