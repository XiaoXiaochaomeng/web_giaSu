<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/edit.css">

</head>
<body>
<div class="container emp-profile">
    <h1>Sửa Thông Tin Lớp Học</h1>
    <form method="post">
        <input placeholder="id" name="id" value="${lopHoc.id}" hidden="hidden"><br>
        <input placeholder="Tên Lớp Học" name="name" type="name" value="${lopHoc.tenLopHoc}"><br>
        <input placeholder="usernameHS" name="usernameHS" value="${lopHoc.usernameHocSinh}" hidden="hidden"><br>
        <input placeholder="Giờ Bắt Đầu" name="hour" type="number" value="${lopHoc.gioHoc}"><br>
        <select name="lever" value="${lopHoc.lever}">
            <option value="1">Cấp 1</option>
            <option value="2">Cấp 2</option>
            <option value="3">Cấp 3</option>
        </select>
        <input placeholder="date" name="date" type="date" value="${lopHoc.ngayHoc}"><br>
        <input placeholder="Phí Lớp Học" name="price" type="number" value="${lopHoc.hocPhi}"><br>
        <input placeholder="Phí Gia Sư" name="priceGS" type="number" value="${lopHoc.phiGiaSu}"><br>
        <input placeholder="Nội Dung" name="content" type="content" value="${lopHoc.moTa}"><br>
        <input placeholder="Hình Ảnh" name="img" type="img" value="${lopHoc.hinhAnh}"><br>

        <button type="submit" class="btn btn-success">Submit</button>
    </form>

</div>

</body>
</html>

