<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">Product ID</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>
    <%--    要用foreach循环--%>
        <c:forEach items="${productList}" var="productCategory">
            <tr>
                <th scope="row"><a onclick="searchPage4(${productCategory.productId})" href="javascript:void(0)">${productCategory.productId}</a></th>
                <td>${productCategory.productName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script>
    function searchPage4(Id1) {
        $.ajax({
            type: "get",
            url: '/viewProduct?productId=' + Id1,
            data: "",
            cache: false,
            success: function (data) {
                $("#changePart").html(data);
            }
        })
    }
</script>

