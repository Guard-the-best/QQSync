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
                        <form id="productInfo" action="javascript:void(0)" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light" colspan="2">
                                        <div class="p-2 px-3 text-uppercase" style="background-color: #a6a5c4">Payment Details</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Card Type:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <label>
                                            <select>
                                                <option value="volvo">Visa</option>
                                                <option value="saab">WeChat</option>
                                                <option value="opel">Alipay</option>
                                            </select>
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Card Number:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="CardNumber" name="CardNumber" type="text" style="width:50%;">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Expiry Date (MM/YYYY):</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="expiryDate" name="expiryDate" type="text" style="width:50%;">
                                    </td>
                                </tr>
                                </tbody>
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light" colspan="2">
                                        <div class="p-2 px-3 text-uppercase" style="background-color: #a6a5c4">Billing Address</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Name:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="Name2" name="Name2" type="text" style="width:50%;" value="${address.name}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Address:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="Address2" name="Address2" type="text" style="width:50%;" value="${address.detailedAddress}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Phone Number:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="PhoneNumber2" name="PhoneNumber2" type="text" style="width:50%;" value="${address.phoneNumber}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">City:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="City2" name="City2" type="text" style="width:50%;" value="${address.city}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">State:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="State2" name="State2" type="text" style="width:50%;" value="${address.province}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h6 class="mb-0">Country:</h6>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input id="Country2" name="Country2" type="text" style="width:50%;" value="${address.county}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="submit" class="btn btn-success" onclick="postProductData()" value="Confirm"/>

                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="reset" class="btn btn-info" value="Reset"/>
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
<script>

    function postProductData() {
        $.ajax({
            type: "post",
            url: "/makeOrder",
            data: $('#productInfo').serialize(),
            success: function (data) {
                console.log(data);
                $("#changePart").html(data);
            }
        })
    }

</script>