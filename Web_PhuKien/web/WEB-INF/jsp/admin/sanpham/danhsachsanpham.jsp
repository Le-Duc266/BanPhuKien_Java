<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>

        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>

        </head>
        <body>

            <div class="container-scroller">
                <!-- partial:partials/_navbar.html -->
            <jsp:include page="../header.jsp"></jsp:include>
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <!-- partial:partials/_settings-panel.html -->
                <jsp:include page="../head.jsp"></jsp:include>
                    <!-- partial -->
                    <!-- partial:partials/_sidebar.html -->
                <jsp:include page="../menu.jsp"></jsp:include>

                    <!-- partial -->
                    <div class="main-panel">

                        <div class="content-wrapper">

                            <div class="row">
                                <div class="col-lg-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Danh Sách Sản Phẩm</h4>

                                            <div class="table-responsive">
                                                <table id="sanpham" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                Mã Sản Phẩm
                                                            </th>
                                                            <th>
                                                                Tên Sản Phẩm
                                                            </th>
                                                            <th>
                                                                Danh mục
                                                            </th>
                                                            <th>
                                                                Nhà Sản Xuất
                                                            </th>
                                                            <th>
                                                                Giá
                                                            </th>
                                                            <th>
                                                                Ảnh
                                                            </th>
                                                            <th>
                                                                Số lượng
                                                            </th>
                                                            <th>
                                                                Ngày Tạo
                                                            </th>
                                                            <th>
                                                                Mô tả
                                                            </th>
                                                            <th>
                                                                Lựa Chọn
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    <c:forEach var="c" items="${sp}">
                                                        <tr>
                                                            <td>${c.maSanPham}</td>
                                                            <td>${c.tenSanPham}</td>
                                                            <td>${c.maDanhMuc.tenDanhMuc}</td>
                                                            <td> ${c.maNhanHang.tenNhanHang} </td>
                                                            <td><fmt:formatNumber value = "${c.gia}" type = "currency"/></td>
                                                            <td class="font-weight-bold"><img class="product-img" src="<i:url value='/resources/images/product/${c.anh}'/>" /></td>
                                                            <td>${c.soLuong}</td>
                                                            <td>${c.ngayTao}</td>
                                                            <td class="content">${c.moTa}</td>
                                                            <td>
                                                                <a href="initSanPham?maSanPham=${c.maSanPham}"><button type="button" class="btn btn-warning btn-rounded btn-fw" >Sửa</button></a>
                                                                <a href="xoasanpham.htm?id=${c.maSanPham}" onclick="return confirm('Bạn có chắc muốn xóa?')"><button type="button" class="btn btn-danger btn-rounded btn-fw" >Xóa</button></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:../../partials/_footer.html -->
                    <footer class="footer">
                        <div class="d-sm-flex justify-content-center justify-content-sm-between">

                            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted &amp; made with <i class="ti-heart text-danger ml-1"></i></span>
                        </div>
                    </footer>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>   
            <!-- page-body-wrapper ends -->
        </div>
        <jsp:include page="../footer.jsp"></jsp:include>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sanpham').dataTable({
                    "n": "full_numbers",
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                });
            });
            function trimText(str, wordCount) {
                var strArray = str.split(' ');
                var subArray = strArray.slice(0, wordCount);
                var result = subArray.join(" ");
                return result + '.....';
            }

            var str = $('tbody .content').text();
            var result = trimText(str, 8);
            $('tbody .content').text(result);
        </script>
    </body>
</html>
