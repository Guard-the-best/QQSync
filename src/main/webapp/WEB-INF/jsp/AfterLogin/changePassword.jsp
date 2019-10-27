
<div class="blog">
    <!-- container -->
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <br />
            </div>
            <div class="col-md-4">
                <form id="changepasswordfrom" action="javascript:void(0)">
                    <h3>修改密码</h3>
                    <c:if test="${error!=null}">
                        <div class="alert alert-danger" role="alert">${error}</div>
                    </c:if>
                    <div class="form-group">
                        <label>原密码</label>
                        <input id="origin" name="origin" type="password" type="text" class="form-control"
                               placeholder="请输入您的原密码"/>
                    </div>
                    <div class="form-group">
                        <label>新密码</label>
                        <input id="new" name="new" type="password" type="text" class="form-control"
                               placeholder="请输入您的新密码"/>
                    </div>
                    <div class="form-group">
                        <label>确认密码</label>
                        <input id="confirm" name="confirm" type="password" type="text" class="form-control"
                               placeholder="请再次输入您的新密码"/>
                    </div>
                    <input type="submit" class="btn btn-success" onclick="changepassword()" value="OK"/>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <input type="reset" class="btn btn-info" value="Reset"/>
                </form>
            </div>
            <div class="col-md-2"><br /></div>
            <div class="col-md-4"><img src="../../../static/img/changepassword.jpg"></div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- //container -->
</div>

<script>
    function changepassword() {
        $.ajax({
            type: "post",
            url: "/servlet",
            data: $('#changepasswordfrom').serialize(),
            success: function(data) {
                console.log(data);
                alert("修改密码成功！");
            }
        })
    }

</script>












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