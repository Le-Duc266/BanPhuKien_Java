<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
            <style>
                .product-img{
                    width: 100px !important;
                    height: auto  !important;
                    border-radius: 20% !important;
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

                            <h2 style="color: #e01717;text-align: center;">Bạn Không Đủ Quyền Để Truy Cập</h2>
                         
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
       
    </body>
</html>
