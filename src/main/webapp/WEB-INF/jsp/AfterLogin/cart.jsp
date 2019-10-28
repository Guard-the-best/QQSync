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
                               <c:forEach items="${Item}" var="itemCart">
                                <tr>
                                    <th scope="row">
                                        <div class="p-2">
                                            <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-3_cexmhn.jpg" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"><a onclick="checkAnimal(${itemCart.productId})" href="javascript:void(0)" class="text-dark d-inline-block">Lumix camera lense</a></h5><span class="text-muted font-weight-normal font-italic">Category: Electronics</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="align-middle"><strong>$79.00</strong></td>
                                    <td class="align-middle"><strong>
                                        <br />
                                        <div class="input-group mb-3">
                                            <input onblur="checkNum()" id="${Item.productId}" type="text" style="width:50%;">
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
                            <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                        </label>

                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                    <div class="p-4">
                        <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$390.00</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>$10.00</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold">$400.00</h5>
                            </li>
                        </ul><a href="#" class="btn btn-dark rounded-pill py-2 btn-block">Procceed to checkout</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    function addQuantity() {
        $.ajax({
            type: "post",
            url: "servlet",
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
    
    function checkNum() {
        var length = ${itemLength};
        var itemCart = ${Item};
        var number = new Array();
        for (i = 0; i < length; i++) {

            number[i] = document.getElementById(itemCart[i].productId);
        }
        $.ajax({
            type: "post",
            url:  'servlet',
            data: $('#addQ').serialize(),
            success: function (data) {
                }
        })
    }
</script>