<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/show.css">

</head>
<body>
<div class="container emp-profile">

    <c:if test="${account.role == 'gv'}">
        <h1 >Lớp học của tôi</h1>
        <hr>
        <a href="/managerLopHoc?action=create" type="button" class="btn btn-success">Create</a>
        <br>
    </c:if>
    <c:if test="${account.role == 'admin'}">
        <h1>Quản lý lớp học</h1>
    </c:if>

    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="/managerLopHoc?lever=1">Tiểu Học</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="/managerLopHoc?lever=2">Trung Học</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="/managerLopHoc?lever=3">Trung Học Phổ Thông</a>
        </li>
    </ul>


    <!-- Tab panes -->
    <div class="tab-content">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Date</th>
                <th>Price</th>
                <th>Price GS</th>
                <th>Content</th>
                <th>Img</th>
                <th>Name GS</th>
                <th>Accept</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lh" items="${lopHocs}">
                <tr>
                    <td>${lh.id}</td>
                    <td>${lh.tenLopHoc}</td>
                    <td>${lh.ngayHoc}</td>
                    <td>${lh.hocPhi}</td>
                    <td>${lh.phiGiaSu}</td>
                    <td>${lh.moTa}</td>
                    <td><img src="${lh.hinhAnh}" width="200" height="170"></td>
                    <td>${lh.usernameGiaSu}</td>
                    <c:if test="${account.role == 'admin'}">
                        <c:if test="${lh.accept == 1}">
                            <td><a href="/managerLopHoc?action=unAccept&id=${lh.id}" type="button"
                                   class="btn btn-success">Đã Accept</a></td>
                        </c:if>
                        <c:if test="${lh.accept == 0}">
                            <td><a href="/managerLopHoc?action=accept&id=${lh.id}" type="button"
                                   class="btn btn-warning">Chưa Accept</a></td>
                        </c:if>
                    </c:if>

                    <c:if test="${account.role == 'gv'}">
                        <c:if test="${lh.accept == 1}">
                            <td><a href="#" type="button"
                                   class="btn btn-success">Đã Accept</a></td>
                        </c:if>
                        <c:if test="${lh.accept == 0}">
                            <td><a href="#" type="button"
                                   class="btn btn-warning">Chưa Accept</a></td>
                        </c:if>
                    </c:if>

                    <td><a href="/managerLopHoc?action=edit&id=${lh.id}" type="button"
                           class="btn btn-secondary">Edit</a></td>
                    <td><a onclick="deleteLH(${lh.id})" type="button"
                           class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <br>
    </div>
</div>



</div>

</body>
</html>
<script>
    function deleteLH(idLH) {
        let check = confirm('Xóa lớp học!')
        if (check) {
            location.href = "/managerLopHoc?action=delete&id=" + idLH;
        }
    }

    document.addEventListener("DOMContentLoaded", function () {
        // Lấy giá trị của tham số 'lever' từ URL
        const urlParams = new URLSearchParams(window.location.search);
        let leverParam = urlParams.get('lever');
        if (leverParam == null) {
            leverParam = "1";
        }
        // Lặp qua tất cả các thẻ 'a' trong danh sách và kiểm tra giá trị của 'href'
        const navLinks = document.querySelectorAll('.nav-link');
        navLinks.forEach((link) => {
            const href = link.getAttribute('href');
            // Kiểm tra nếu giá trị 'href' chứa giá trị của 'lever' trong tham số
            if (href.includes(leverParam)) {
                // Xóa lớp 'active' cho tất cả các thẻ 'a'
                navLinks.forEach((link) => {
                    link.classList.remove('active');
                });
                // Đặt active cho thẻ 'a' tương ứng
                link.classList.add('active');
            }
        });
    });

</script>
