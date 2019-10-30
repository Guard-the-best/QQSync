<div class="container">
    <div class="row">
        <div class="col-md1-1"></div>
        <div class="col-md1-10">
            <div class="pb-5">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                            <!-- Shopping cart table -->
                            <div class="table-responsive">
                                <form>
                                    <table class="table">
<%--                                        <thead>--%>
<%--                                        <tr>--%>
<%--                                            <th scope="col" class="border-0 bg-light" colspan="2">--%>
<%--                                                <div class="p-2 px-3 text-uppercase" style="background-color: #a6a5c4">Profile Information</div>--%>
<%--                                            </th>--%>
<%--                                        </tr>--%>
<%--                                        </thead>--%>
<%--                                        <tbody>--%>
<%--                                        <tr>--%>
<%--                                            <th scope="row" class="border-0">--%>
<%--                                                <div class="p-2">--%>
<%--                                                    <div class="ml-3 d-inline-block align-middle">--%>
<%--                                                        <h5 class="mb-0">Language Preference:</h5>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </th>--%>
<%--                                            <td class="border-0 align-middle">--%>
<%--                                                <label>--%>
<%--                                                    something from select--%>
<%--                                                </label>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <th scope="row" class="border-0">--%>
<%--                                                <div class="p-2">--%>
<%--                                                    <div class="ml-3 d-inline-block align-middle">--%>
<%--                                                        <h5 class="mb-0">Favourite Category:</h5>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </th>--%>
<%--                                            <td class="border-0 align-middle">--%>
<%--                                                <label>--%>
<%--                                                    something from select--%>
<%--                                                </label>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        </tbody>--%>
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
                                                ${address.name}
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row" class="border-0">
                                                <div class="p-2">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0">NickName:</h5>
                                                    </div>
                                                </div>
                                            </th>
                                            <td class="border-0 align-middle">
                                                ${sessionScope.user.nickname}
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row" class="border-0">
                                                <div class="p-2">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0">Phone Number:</h5>
                                                    </div>
                                                </div>
                                            </th>
                                            <td class="border-0 align-middle">
                                                ${sessionScope.user.phoneNumber}
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
                                                ${address.city}
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
                                                ${address.province}
                                            </td>
                                        </tr>

                                        <tr>
                                            <th scope="row" class="border-0">
                                                <div class="p-2">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0">Country:</h5>
                                                    </div>
                                                </div>
                                            </th>
                                            <td class="border-0 align-middle">
                                                ${address.county}
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
                                    <input type="submit" class="btn btn-success" onclick="searchPage5('/toModifyInfoServlet')" value="Modify"/>

                                </form>
                            </div>
                            <!-- End -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md1-1"></div>
    </div>
</div>

<script>
    function searchPage5(url) {
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

