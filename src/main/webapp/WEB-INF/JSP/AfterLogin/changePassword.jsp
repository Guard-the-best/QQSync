<div class="container">
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
<%--            content--%>

        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>












<script>
    function changepassword() {
        var origin = $("#origin").val();
        var newdata = $("#new").val();
        var confirm = $("#confirm").val();
        $.ajax({
            type: "post",
            url: "/meeting/dochangepassword",
            data: {
                "origin": origin,
                "new": newdata,
                "confirm": confirm
            },
            error: function(request) {

            },
            success: function(data) {
                alert("更新成功！");
            }
        })
    }
</script>