<%-- 
    Document   : menu.jsp
    Created on : Jun 14, 2022, 9:55:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="index.html">
                <i class="icon-grid menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/banner/danhsachBanner">
                <i class="icon-columns menu-icon"></i>
                <span class="menu-title">Banner</span>

            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/category/listCate">
                <i class="icon-paper menu-icon"></i>
                <span class="menu-title">Danh Mục</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/nhanhang/danhsachnhanhang">
                <i class="icon-columns menu-icon"></i>
                <span class="menu-title">Nhãn Hàng</span>

            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-command menu-icon"></i>
                <span class="menu-title">Sản Phẩm</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/sanpham/danhsachsanpham">Danh Sách </a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/sanpham/themmoisanpham">Thêm Mới </a></li>
                </ul>
            </div>
        </li>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#HoaDon" aria-expanded="false" aria-controls="tables">
                <i class="icon-command menu-icon"></i>
                <span class="menu-title">Hóa Đơn</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="HoaDon">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/hoadon/danhsachdonhang">Danh Sách Đơn Hàng</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/hoadon/don-hang-da-duyet">Đơn Hàng Đã Duyệt</a></li>
                </ul>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                <i class="icon-contract menu-icon"></i>
                <span class="menu-title">Tài Khoản</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="icons">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/taikhoan/danhsachnguoidung">Người Dùng</a></li>
                </ul>
                 <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/taikhoan/danhsachnhanvien">Nhân Viên</a></li>
                </ul>
                   <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/admin/quyen/danhsachquyen">Quyền</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>

