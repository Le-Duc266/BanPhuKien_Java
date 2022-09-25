<%-- 
    Document   : insertSanPham
    Created on : Aug 10, 2022, 5:34:42 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
            <style>.span-color{width:25px;
                        height:25px;
                        margin-right: 20px;
                        display:inline-block;
                        color:black;
                        cursor:pointer;
                        position:relative;}

                .file-upload{display:block;text-align:center;font-family: Helvetica, Arial, sans-serif;font-size: 12px;}
                .file-upload .file-select{display:block;border: 2px solid #dce4ec;color: #34495e;cursor:pointer;height:40px;line-height:40px;text-align:left;background:#FFFFFF;overflow:hidden;position:relative;}
                .file-upload .file-select .file-select-button{background:#dce4ec;padding:0 10px;display:inline-block;height:40px;line-height:40px;}
                .file-upload .file-select .file-select-name{line-height:40px;display:inline-block;padding:0 10px;}
                .file-upload .file-select:hover{border-color:#34495e;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload .file-select:hover .file-select-button{background:#34495e;color:#FFFFFF;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload.active .file-select{border-color:#3fa46a;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload.active .file-select .file-select-button{background:#3fa46a;color:#FFFFFF;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload .file-select input[type=file]{z-index:100;cursor:pointer;position:absolute;height:100%;width:100%;top:0;left:0;opacity:0;filter:alpha(opacity=0);}
                .file-upload .file-select.file-select-disabled{opacity:0.65;}
                .file-upload .file-select.file-select-disabled:hover{cursor:default;display:block;border: 2px solid #dce4ec;color: #34495e;cursor:pointer;height:40px;line-height:40px;margin-top:5px;text-align:left;background:#FFFFFF;overflow:hidden;position:relative;}
                .file-upload .file-select.file-select-disabled:hover .file-select-button{background:#dce4ec;color:#666666;padding:0 10px;display:inline-block;height:40px;line-height:40px;}
                .file-upload .file-select.file-select-disabled:hover .file-select-name{line-height:40px;display:inline-block;padding:0 10px;}
                .update{display: none;}
                #image{
                    display: none;
                }
            </style>

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
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Thêm mới sản phẩm</h4>
                                            <form  class="form-sample" action="/Web_PhuKien/admin/sanpham/luusanpham" method="post" enctype="multipart/form-data">

                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label class="form-group">Tên sản phẩm</label>
                                                            <input type="text" hidden name="maSanPham" class="form-control" value="0"  />
                                                            <input type="text" name="tenSanPham" class="form-control"  placeholder="Tên sản phẩm"  />
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-6 ">
                                                        <div class="row ">
                                                            <div class="col-md-12">
                                                                <div class="form-group row">
                                                                    <label class="col-sm-3 col-form-label">Danh mục</label>
                                                                    <div class="col-sm-9">
                                                                        <select name="maDanhMuc" class="form-control">
                                                                        <c:forEach items="${dm}" var="d">
                                                                            <option  value="<fmt:formatNumber value="${d.maDanhMuc}"></fmt:formatNumber>">${d.tenDanhMuc}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row ">
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <label class="col-sm-3 col-form-label">Nhãn hàng</label>
                                                                <div class="col-sm-9">
                                                                    <select name="maNhanHang" class="form-control">
                                                                        <c:forEach items="${nh}" var="n">
                                                                            <option  value="<fmt:formatNumber value="${n.maNhanHang}"></fmt:formatNumber>">${n.tenNhanHang}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <label class="col-sm-3 col-form-label">Giá</label>
                                                                <div class="col-sm-9">
                                                                    <input type="number" name="gia" class="form-control"  placeholder="Giá sản phẩm"  />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <label class="col-sm-3 col-form-label">Số lượng</label>
                                                                <div class="col-sm-9">
                                                                    <input type="number" name="soLuong" class="form-control"  placeholder="Số Lượng"  />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-6 ">
                                                    <div class="form-group">
                                                        <label>Mô tả</label>
                                                        <textarea class="form-control" name="moTa" rows="11"></textarea>
                                                    </div>
                                                    <div class="form-group" >
                                                        <label for="exampleInputUsername1">Chọn ảnh</label>
                                                        <div class="file-upload">
                                                            <div class="file-select"  id="ianh">
                                                                <div class="file-select-button" id="fileName">Choose File</div>
                                                                <div class="file-select-name" id="noFile">No file chosen...</div> 
                                                                <input type="file" name="productURL" id="chooseFile" accept="image/png, image/jpeg" onchange="file_changed()">

                                                            </div>
                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary mr-2">Lưu</button>
                                            <button class="btn btn-light">Hủy</button>
                                        </form>
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
            $('#chooseFile').bind('change', function () {
                var filename = $("#chooseFile").val();
                if (/^\s*$/.test(filename)) {
                    $(".file-upload").removeClass('active');
                    $("#noFile").text("No file chosen...");
                }
                else {
                    $(".file-upload").addClass('active');
                    $("#noFile").text(filename.replace("C:\\fakepath\\", ""));
                }
            });
            function file_changed() {
                var selectedFile = document.getElementById('chooseFile').files[0];
                var img = document.getElementById('img')
                $("#image").show();
                var reader = new FileReader();
                reader.onload = function () {
                    img.src = this.result

                }
                reader.readAsDataURL(selectedFile);
            }
        </script>
    </body>
</html>


