<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Item ID</th>
        <th scope="col">Product ID</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Purchase</th>
        <th scope="col">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspADD</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${itemList}" var="itemResult">
    <tr class="card0" id="${itemResult.itemId}">
        <th scope="row"><br />${itemResult.itemId}</th>
        <td><br />${itemResult.productId}</td>
        <td><br />
            <c:forEach items="${itemResult.attributes}" var="attribute" varStatus="status">
                <c:if test="${attribute != null && status.index != 0}">,</c:if>
                ${attribute}
            </c:forEach>
        </td>
        <td><br />$ ${itemResult.listPrice}</td>
        <td>
            <button type="button" class="btn btn-info btn-sm" onclick="searchPage2(${itemResult.itemId})" href="javascript:void(0)">Buy</button>
        </td>
        <td>
            <button onclick="checkAnimal2(${itemResult.itemId})" type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#exampleModal">Cart</button>
        </td>
    </tr>

    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">消息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <strong>已成功添加至购物车！</strong>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-sm" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    function checkAnimal2(animalid) {
        $.ajax({
            type: "post",
            url: "/addToCart?itemId=" + animalid,
            data: {},
            success: function (data) {
            }
        })
    }

    function searchPage2(animalId) {
        checkAnimal2(animalId);
        $.ajax({
            type: "get",
            url: "/toCart",
            data: "",
            cache: false,
            success: function (data) {
                $("#changePart").html(data);
            }
        })
    }
</script>
<script>
    var d = document.getElementsByClassName('card0');
    for(var i=0;i<d.length;i++){
        d[i].onmouseover = function () {
            var id0 = this.id +100;
            var ele = document.getElementById(id0);
            var h = (this.id-10000)*60 +'px';
            console.log(h);
            ele.style.top = h;
            ele.style.visibility="visible";
        }
        d[i].onmouseout = function() {
            var id0 = this.id +100;
            var ele = document.getElementById(id0);
            ele.style.visibility="hidden";
        }
    }

    // $(".card0").hover(function() {
    //
    //     $(".card0").addClass('hover-show-bg');
    //     $(".card2").show();
    // },function(){
    //     $(".card2").removeClass('hover-show-bg');
    //     $(".card2").hide();
    // });
</script>
<c:forEach items="${itemList}" var="itemResult">
    <div style="position: fixed;z-index: 99;top:150px;left:90px;width: 300px;visibility: hidden;" class="card2" id="${itemResult.itemId}100">
        <img class="card2-img-top" src="../../../static/img/carousel3.jpg" alt="Card image" style="width:100%">
        <div class="card2-body">
            <h4 style="color: #ddbb99;" class="card2-title">${itemResult.productId}</h4>
            <p style="color: #ddbb99;" class="card2-text">${itemResult.itemId}</p>
            <a href="#" class="btn btn-primary">$ ${itemResult.listPrice}</a>
        </div>
    </div>
</c:forEach>