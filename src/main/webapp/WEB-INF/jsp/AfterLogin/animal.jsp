
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">Product ID</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>
    <%--    要用foreach循环--%>
<c:forEach items="${list}" var="emp">

</c:forEach>
    <tr>
        <th scope="row"><a onclick="searchPage(url)" href="javascript:void(0)">ES-1</a></th>
        <td>Mark</td>
    </tr>
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


