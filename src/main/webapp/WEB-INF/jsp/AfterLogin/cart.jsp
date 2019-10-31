<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                    <!-- Shopping cart table -->
                    <div class="table-responsive">
                        <form id="addQ" action="javascript:void (0)" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Price</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Quantity</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Remove</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                               <c:forEach items="${lineItems}" var="itemCart">
                                <tr>
                                    <th scope="row">
                                        <div class="p-2">
                                            <img src="../../../static/img/carousel3.jpg" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"><a onclick="checkAnimal(${itemCart.itemId})" href="javascript:void(0)" class="text-dark d-inline-block">${itemCart.productName}</a></h5><span class="text-muted font-weight-normal font-italic">${itemCart.categoryName}</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="align-middle"><strong><c:out value="${itemCart.price}"/></strong></td>
                                    <td class="align-middle" ><strong>
                                        <br />
                                        <div class="input-group mb-3">
                                            <input id="1" onblur="checkNum()" id="${itemCart.itemId}" name="${itemCart.itemId}" type="text" style="width:50%;" value="${itemCart.quantity}">
                                            &nbsp&nbsp&nbsp&nbsp
                                            <button onclick="addQuantity()">
                                                <i class="fas fa-plus"></i>
                                            </button>

                                        </div>
                                    </strong></td>
                                    <td class="align-middle"><a href="#" class="text-dark">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                               </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <!-- End -->
                </div>
            </div>

            <div class="row py-5 p-4 bg-white rounded shadow-sm">
                <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                    <div class="p-4">
                        <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                        <label>
                            <textarea id="ps" name="ps" cols="30" rows="2" class="form-control"></textarea>
                        </label>

                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                    <div class="p-4">
                        <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong id="totalPrice1" name="totalPrice1">$${totalPrice}</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold" id="totalPrice2" name="totalPrice2">$${totalPrice}</h5>
                            </li>
                        </ul>
                        <a onclick="findPage('/toProductInfo')" href="javascript:void(0)" class="btn btn-dark rounded-pill py-2 btn-block">Procceed to checkout</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    function findPage(url) {
        $.ajax({
            type: "get",
            url: url,
            data: "",
            success: function (data) {
                console.log(data);
                $("#changePart").html(data);
            }
        })
    }

    function addQuantity() {
        $.ajax({
            type: "post",
            url: "/modifyQuantity",
            data: $('#addQ').serialize(),
            success: function (data) {
                console.log(data);
            }
        })
    }

    function checkAnimal(animalid) {
        $.ajax({
            type: "post",
            url: "/animalItemServlet?animalid=" + animalid,
            data: {},
            success: function (data) {
            }
        })
    }




</script>
<script>
    function checkNum() {
        var totalPrice1=document.getElementById('totalPrice1');
        var totalPrice2=document.getElementById('totalPrice2');
        var num = document.getElementById('1').value;
        var m = num*20;
            totalPrice1.innerText='$'+m;
            totalPrice2.innerText='$'+m;

        $.ajax({
            type: "post",
            url:  '/modifyQuantity',
            data: $('#addQ').serialize(),
            success: function (data) {
                // var totalPrice1 =document.getElementById('totalPrice1');
                // totalPrice1.innerText=data;
                // var totalPrice2 =document.getElementById('totalPrice2');
                // totalPrice2.innerText=data;
            }
        })
    }
</script>