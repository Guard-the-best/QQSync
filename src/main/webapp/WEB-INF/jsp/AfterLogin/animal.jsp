<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <th scope="row"><a onclick="searchPage4(url)" href="javascript:void(0)">${productCategory.productId}</a></th>
        <td>${productCategory.productName}</td>
    </tr>
</c:forEach>
    <tr>
        <th scope="row"><a href="#">ES-2</a></th></th>
        <td>Jacob</td>
    </tr>
    <tr>
        <th scope="row"><a href="#">ES-3<br /></a></th></th>
        <td>Larry the Bird<br /></td>
    </tr>
    </tbody>
</table>
<script>
    function searchPage4(url) {
        $.ajax({
            type: "get",
            url: url,
            data: "",
            cache: false,
            success: function (data) {
                $("#changePart").html(data);
            }
        })
    }
</script>

