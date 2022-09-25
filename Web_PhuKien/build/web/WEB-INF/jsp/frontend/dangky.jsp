<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <jsp:include page="../admin/linkcss.jsp"></jsp:include>
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
              
                <h3 class="font-weight-light"><b>Tạo Tài Khoản</b></h3>
              <form class="pt-3" action="luu-tai-khoan.htm" method="POST">
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" id="exampleInputUsername1" name="tenTaiKhoan" placeholder="Họ Và Tên">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="exampleInputEmail1" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="exampleInputEmail1" name="diaChi" placeholder="Địa Chỉ">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="exampleInputPassword1" name="soDienThoai" placeholder="Số Điện Thoại">
                </div>
                  <div class="form-group">
                      <input type="password" class="form-control form-control-lg" id="exampleInputPassword1" name="password" placeholder="Password">
                </div>
                
                <div class="mt-3">
                    <button type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Đăng Ký</button>
                </div>
                <div class="text-center mt-4 font-weight-light">
                  Bạn Đã Có Tài Khoản? <a href="/Web_PhuKien/dang-nhap" class="text-primary">Đăng Nhập</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <!-- endinject -->
</body>

</html>
