<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                    <!-- Shopping cart table -->
                    <div class="table-responsive">
                        <form>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">OrderID</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">ProductName</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Quantity</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Date</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Price</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Address</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderList}" var="orderLine">
                                    <tr>
                                        <td class="border-0 align-middle"><strong>
                                                ${orderLine.orderId}
                                        </strong></td>
                                        <th scope="row" class="border-0">
                                            <div class="p-2">
                                                <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                <div class="ml-3 d-inline-block align-middle">
                                                    <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">${orderLine.name}</a></h5><span class="text-muted font-weight-normal font-italic d-block"></span>
                                                </div>
                                            </div>
                                        </th>
                                        <td class="border-0 align-middle"><strong>
                                            ${orderLine.quantity}
                                        </strong></td>
                                        <td class="border-0 align-middle"><strong>
                                            ${orderLine.date}
                                        </strong></td>
                                        <td class="border-0 align-middle"><strong>
                                            $ ${orderLine.price}
                                        </strong></td>
                                        <td class="border-0 align-middle"><strong>
                                                ${orderLine.address}
                                        </strong></td>

                                    </tr>
                                </c:forEach>

                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">ES-25987</a></h5><span class="text-muted font-weight-normal font-italic d-block">Category: ...</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle"><strong>2019-10-22,12:00</strong></td>
                                    <td class="border-0 align-middle"><strong>
                                        $168
                                    </strong></td>

                                </tr>

                                </tbody>
                            </table>
                        </form>
                    </div>
                    <!-- End -->
                </div>
            </div>
        </div>
    </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>