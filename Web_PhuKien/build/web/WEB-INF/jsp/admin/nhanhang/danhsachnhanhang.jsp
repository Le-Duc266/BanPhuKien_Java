<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                <div class="col-md-6 grid-margin ">
                                    <div class="card grid-margin" style="height: 70px;text-align: center;padding:  20px">
                                        <h2>Quản Lý Danh Mục</h2>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Thêm Mới Nhãn Hàng</h4>
                                            <form class="forms-sample" action="/Web_PhuKien/admin/nhanhang/luuNhanhang" method="POST" onsubmit="return validate()" >
                                            <input hidden name="maNhanHang" id="maNhanHang" value="0"/>
                                            <div class="form-group">
                                                <label for="exampleInputUsername1">Tên Danh Mục</label>
                                                <input type="text" class="form-control" placeholder="Tên Danh Mục ..." id="tenNhanHang" name="tenNhanHang"/>
                                                
                                            </div>
                                             <div class="invalid-feedback" style="display: block;font-size: 15px;color: red"> </div>
                                            <button type="submit" class="btn btn-success btn-rounded btn-fw" id="save" value="Insert">Lưu</button>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Danh Sách Danh Mục</h4>
                                        <div class="table-responsive">
                                            <div class="form-group">
                                            </div>
                                            <table id="catalog" class="table table-striped table-bordered" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Mã Danh Mục</th>
                                                        <th>Tên Danh Mục</th>
                                                        <th>Lựa Chọn</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="s" items="${nh}">
                                                        <tr>
                                                            <td>${s.maNhanHang}</td>
                                                            <td>${s.tenNhanHang}</td>
                                                            <td>
                                                                <button type="button" class="btn btn-info btn-rounded btn-fw edit" data-ma="${s.maNhanHang}" data-name="${s.tenNhanHang}">Sửa</button>
                                                                <a href="xoaNhanhang.htm?id=${s.maNhanHang}" onclick="return confirm('Bạn Có Chắc Muốn Xóa?')"><button type="button" class="btn btn-danger btn-rounded btn-fw" >Xóa</button></a>
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
        <script>
            $(".edit").on("click", function () {
                var ma = $(this).data("ma");
                var ten = $(this).data("name");
                $("#maNhanHang").val(ma);
                $("#tenNhanHang").val(ten);
            });
            
              function validate(){
              var check = true;
              var name = $('#tenNhanHang').val();
              if(name == ''){
                  $('#tenNhanHang').parent().next().html('Nhãn hàng không được để trống');
                  return false;
              }else{
                    $('#tenNhanHang').parent().next().html('');
                  return true;
              }
              return check;
            };
            
        </script>
         <script type="text/javascript">
            $(document).ready(function () {
                $('#catalog').dataTable({
                    "pagingType": "full_numbers",
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                });
            });
        </script>
    </body>
</html>