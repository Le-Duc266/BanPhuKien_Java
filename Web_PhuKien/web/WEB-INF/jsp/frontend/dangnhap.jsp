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

                                    <h3 class="font-weight-light"><b>Đăng Nhập</b></h3>
                                    <form class="pt-3" action="/Web_PhuKien/danh-nhap-nguoi-dung" onsubmit="return validate()" method="POST">
                                        <label class="block clearfix">
                                            <div class="message">
                                            ${message}
                                        </div>
                                    </label>
                                    <label class="block clearfix">
                                        <div class="success">
                                            ${success}
                                        </div>
                                    </label>
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-lg" id="exampleInputEmail1" name="email" placeholder="Username">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-lg" id="exampleInputPassword1" name="password" placeholder="Password">
                                    </div>
                                    <div class="mt-3">
                                        <button type="submit" class="btn btn-primary mr-2">Đăng Nhập</button>
                                    </div>
                                    <div class="text-center mt-4 font-weight-light">
                                        Bạn Chưa Có Tài Khoản? <a href="/Web_PhuKien/dang-ky" class="text-primary">Đăng Ký</a>
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
        <script>
            function validate() {
                var check = true;


                var tenDangNhap = $('#email').val();
                var matKhau = $('#password').val();


                if (tenDangNhap === '') {
                    $('#email').parent().next().html('Email không được để trống!');
                    check = false;
                } else {
                    $('#email').parent().next().html('');

                    check = true;
                }
                if (matKhau === '') {
                    $('#password').parent().next().html('mật khẩu không được để trống!');
                    check = false;
                } else {
                    $('#password').parent().next().html('');
                    check = true;
                }
                if (tenDangNhap === '') {
                    $('#email').parent().next().html('Email không được để trống!');
                    check = false;
                }
                return check;

            }


        </script>
    </body>

</html>
