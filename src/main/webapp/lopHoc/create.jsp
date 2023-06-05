<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/create.css">

</head>
<body>
<div class="container emp-profile">
    <h1>Tạo Lớp Học</h1>
    <form method="post" action="/managerLopHoc?action=create">
<%--        <input placeholder="id" name="id"><br>--%>
        <input placeholder="Tên Lớp Học" type="name"><br>
        <input placeholder="Giờ Bắt Đầu" type="number" name="hour"><br>
        <select name="lever">
            <option value="1">Cấp 1</option>
            <option value="2">Cấp 2</option>
            <option value="3">Cấp 3</option>
        </select>
        <input placeholder="date" name="date" type="date"><br>
        <input placeholder="Phí Lớp Học" name="price" type="number"><br>
        <input placeholder="Phí Gia Sư" name="priceGS" type="number"><br>
        <input placeholder="Nội Dung" type="content"><br>
        <input placeholder="Ảnh Lớp Học" type="img"><br>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>

</div>

</body>
</html>

