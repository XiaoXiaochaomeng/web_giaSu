<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/showLopHoc.css">
</head>
<body>
<div class="container emp-profile">
    <h1>Danh sách tất cả lớp học</h1>
    <div class="row">
        <c:forEach var="lh" items="${lopHocs}">
            <div class="col 3 table_thpt_item" align="center">
                <img src="${lh.hinhAnh}" alt="" width="200" height="160">
                <br>
                <hr>
                <button class="btn btn-success">${lh.tenLopHoc}</button>
                <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                <p>${lh.moTa}</p>
                <hr>
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>
<script>

</script>
