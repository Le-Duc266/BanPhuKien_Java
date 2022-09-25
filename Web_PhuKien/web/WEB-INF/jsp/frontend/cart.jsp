<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>EShopper - Bootstrap Shop Template</title>
        <jsp:include page="linkstyle.jsp"></jsp:include>
            <!-- Favicon -->

        </head>

        <body>
            <!-- Topbar Start -->

            <!-- Topbar End -->


            <!-- Navbar Start -->
        <jsp:include page="head.jsp"></jsp:include>
            <!-- Navbar End -->


            <!-- Page Header Start -->
            <div class="container-fluid bg-secondary mb-5">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Shopping Cart</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Cart Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="col-lg-8 table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Sản Phẩm</th>
                                    <th>Giá</th>
                                    <th>Số Lượng</th>
                                    <th>Thành Tiền</th>
                                    <th>Chức Năng</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:forEach var="sp" items="${giohang}">
                                <tr>
                                    <td class="align-middle masp" hidden="true" id="masp" data-maSanPham="${sp.maSanPham}"></td>
                                    <td class="align-middle tensp"><img src="/Web_PhuKien/resources/images/product/${sp.anh}" alt="" style="width: 50px;"> ${sp.tenSanPham}</td>
                                    <td class="align-middle gia" data-value="${sp.gia}"><fmt:formatNumber value = "${sp.gia}" type = "currency"/></td>
                                    <td class="align-middle tanggiamsl">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">

                                            </div>
                                            <input type="number" class="form-control form-control-sm bg-secondary text-center soluong-giohang" min="1" value="${sp.soluong}">
                                            <div class="input-group-btn">

                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle thanhtien"  data-thanhtien="${sp.tinhTongtien}">${sp.tinhTongtien}</td>
                                    <td class="align-middle "><button class="btn btn-sm btn-primary xoa-giohang" data-value="${sp.maSanPham}"><i class="fa fa-times"></i></button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">

                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Thanh Toán</h4>
                        </div>

                        <div class="card-footer border-secondary bg-transparent">
                            <div class="d-flex justify-content-between mt-2">
                                <h5 class="font-weight-bold">Tổng Tiền</h5>
                                <h5 class="font-weight-bold tongtien" id="tongtien"><fmt:formatNumber value = "${tongtien}" type = "currency"/></h5>
                            </div>
                            <a href="/Web_PhuKien/hoa-don" class="btn btn-block btn-primary my-3 py-3">Đặt Hàng</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->


        <!-- Footer Start -->
        <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
            <div class="row px-xl-5 pt-5">
                <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                    <a href="" class="text-decoration-none">
                        <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <p>Dolore erat dolor sit lorem vero amet. Sed sit lorem magna, ipsum no sit erat lorem et magna ipsum dolore amet erat.</p>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
                    <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
                </div>
                <div class="col-lg-8 col-md-12">
                    <div class="row">
                        <div class="col-md-4 mb-5">
                            <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                                <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                                <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                                <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                                <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                                <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                            </div>
                        </div>
                        <div class="col-md-4 mb-5">
                            <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                                <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                                <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                                <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                                <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                                <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                            </div>
                        </div>
                        <div class="col-md-4 mb-5">
                            <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                            <form action="">
                                <div class="form-group">
                                    <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                           required="required" />
                                </div>
                                <div>
                                    <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row border-top border-light mx-xl-5 py-4">
                <div class="col-md-6 px-xl-0">
                    <p class="mb-md-0 text-center text-md-left text-dark">
                        &copy; <a class="text-dark font-weight-semi-bold" href="#">Your Site Name</a>. All Rights Reserved. Designed
                        by
                        <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">HTML Codex</a><br>
                        Distributed By <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
                    </p>
                </div>
                <div class="col-md-6 px-xl-0 text-center text-md-right">
                    <img class="img-fluid" src="img/payments.png" alt="">
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script type="text/javascript">
            $(".btn-plus").click(function () {
                var tang = $(this).closest("tr").find(".tanggiamsl .soluong").val();
                var tangsoluong = parseInt(tang) + 1;

                $(this).closest("tr").find(".tanggiamsl .soluong").val(tangsoluong);
            })
            $(".btn-minus").click(function () {
                var giam = $(this).closest("tr").find(".tanggiamsl .soluong").val();
                var giamsoluong = parseInt(giam) - 1;
                $(this).closest("tr").find(".tanggiamsl .soluong").val(giamsoluong);
            });



            GanTongTienGioHang();
            function GanTongTienGioHang(isEventChange) {
                var tongtien = 0;
                $(".thanhtien").each(function () {
                    var thanhtien = $(this).text();
                    var gia1 = thanhtien.replaceAll(".", "");
                    var gia2 = gia1.replaceAll("đ", "");
                    var gia = gia2.replaceAll(" ", "");
                    tongtien = tongtien + parseFloat(gia);
                    if (!isEventChange) {
                    $(this).html(thanhtien);
                    }
                    const config = { style: 'currency', maximumFractionDigits: 9}
                    const formated = new Intl.NumberFormat(config).format(tongtien);
                            $(".tongtien").html(formated + " đ");
                })
            }

            $(".soluong-giohang").change(function () {
                var maSanPham = $(this).closest("tr").find(".masp").attr("data-maSanPham");
                var soluong = $(this).val();
                var gia = $(this).closest("tr").find(".gia").attr("data-value");
                var thanhtien = soluong * parseInt(gia);
                        const config = { style: 'currency', maximumFractionDigits: 9}
                const formated = new Intl.NumberFormat(config).format(thanhtien);
                        $(this).closest("tr").find(".thanhtien").html(formated + " đ");
                GanTongTienGioHang(true);
                $.ajax({
                    url: "/Web_PhuKien/cap-nhap-gio-hang",
                    type: "GET",
                    data: {
                        maSanPham: maSanPham,
                        soLuong: soluong
                    },
                    success: function (value) {
                        
                    }
                })

            })
            
            $(".xoa-giohang").click(function () {
                var sef = $(this).data("value");
                var masp = $(this).parent().parent();
                fetch("/Web_PhuKien/xoa-gio-hang?maSanPham=" + sef)
                        .then(function () {
                            masp.remove();
                        });
            })

        </script>
    </body>

</html>
