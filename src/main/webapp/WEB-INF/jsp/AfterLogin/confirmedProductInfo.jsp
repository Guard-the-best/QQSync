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
<%--                                <thead>--%>
<%--                                <tr>--%>
<%--                                    <th scope="col" class="border-0 bg-light" colspan="2">--%>
<%--                                        <div class="p-2 px-3 text-uppercase" style="background-color: #a6a5c4">Payment Details</div>--%>
<%--                                    </th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--&lt;%&ndash;                                <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <th scope="row" class="border-0">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        <div class="p-2">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <div class="ml-3 d-inline-block align-middle">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <h5 class="mb-0">Card Type:</h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <td class="border-0 align-middle">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <option value="volvo">Visa</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <option value="saab">WeChat</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <option value="opel">Alipay</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </tr>&ndash;%&gt;--%>
<%--                                <tr>--%>
<%--                                    <th scope="row" class="border-0">--%>
<%--                                        <div class="p-2">--%>
<%--                                            <div class="ml-3 d-inline-block align-middle">--%>
<%--                                                <h5 class="mb-0">Card Number:</h5>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </th>--%>
<%--                                    <td class="border-0 align-middle">--%>
<%--                                        <input type="text" style="width:50%;">--%>
<%--                                        &lt;%&ndash;                                        用个常见的算法Ajax实时判断它是否合法-吴止境&ndash;%&gt;--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <th scope="row" class="border-0">--%>
<%--                                        <div class="p-2">--%>
<%--                                            <div class="ml-3 d-inline-block align-middle">--%>
<%--                                                <h5 class="mb-0">Expiry Date (MM/YYYY):</h5>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </th>--%>
<%--                                    <td class="border-0 align-middle">--%>
<%--                                        <input type="text" style="width:50%;">--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                </tbody>--%>
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
                                                <h5 class="mb-0">Name:</h5>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input type="text" style="width:50%;" value="${Address.name}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0">Address:</h5>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input type="text" style="width:50%;" value="${address.detailedAddress}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0">City:</h5>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input type="text" style="width:50%;" value="${Address.city}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0">State:</h5>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input type="text" style="width:50%;" value="${Address.province}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
<%--                                <tr>--%>
<%--                                    <th scope="row" class="border-0">--%>
<%--                                        <div class="p-2">--%>
<%--                                            <div class="ml-3 d-inline-block align-middle">--%>
<%--                                                <h5 class="mb-0">Zip:</h5>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </th>--%>
<%--                                    <td class="border-0 align-middle">--%>
<%--                                        <input type="text" style="width:50%;">--%>
<%--                                        &lt;%&ndash;                                        用个常见的算法Ajax实时判断它是否合法-吴止境&ndash;%&gt;--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
                                <tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0">Country:</h5>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle">
                                        <input type="text" style="width:50%;" value="${Address.county}">
                                        <%--                                        用个常见的算法Ajax实时判断它是否合法-吴止境--%>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="submit" class="btn btn-success btn-sm" onclick="searchPage6('productInfoServlet')" value="Modify"/>

                        </form>
                    </div>
                    <!-- End -->
                </div>
            </div>
        </div>
    </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>

<script>
    function searchPage6(url) {
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