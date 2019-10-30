<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="botDetect" uri="https://captcha.com/java/jsp" %>

<div id="login">
    <form action="/login" method="post">
        <div id="form">
            <div class="logo">
                <h1 class="text-center head">User Login</h1>
            </div>
            <div class="form-item">
                <c:if test="${loginError!=null}">
                    <div class="alert alert-danger alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-hidden="true">
                            &times;   </button>
                            ${loginError} </div>

                </c:if>
                <p class="formLabel">UserID...</p>
                <input type="text" name="email" id="email" class="form-style" autocomplete="off"/>
            </div>
            <div class="form-item">
                <p class="formLabel">Password...</p>
                <input type="password" name="password" id="password" class="form-style" />
                <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
                <p><a href="#" ><small>Forgot Password ?</small></a></p>
            </div>
            <div class="form-item">

                <botDetect:captcha id="loginCaptcha" userInputID="captchaCode" codeLength="4" imageWidth="200" codeStyle="ALPHA"/>
                <br />
                <input type="text" class="form-style" name="captchaCode" id="captchaCode" style="width: 60%;">
                <p class="formLabel2">Verification</p>
            </div>
            <br />
            <div class="form-item">
                <p class="pull-left"><a onclick="getPage2(url)" href="javascript:void(0)"><small>Register</small></a></p>
                <input type="submit" class="login pull-right" value="Log In">
                <div class="clear-fix"></div>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function(){
        var formInputs = $('input[type="text"],input[type="password"]');
        formInputs.focus(function() {
            $(this).parent().children('p.formLabel').addClass('formTop');
            $(this).parent().children('p.formLabel2').addClass('formTop2');
            $('div#formWrapper').addClass('darken-bg');
            $('div.logo').addClass('logo-active');
        });
        formInputs.focusout(function() {
            if ($.trim($(this).val()).length == 0){
                $(this).parent().children('p.formLabel').removeClass('formTop');
                $(this).parent().children('p.formLabel2').removeClass('formTop2');
            }
            $('div#formWrapper').removeClass('darken-bg');
            $('div.logo').removeClass('logo-active');
        });
        $('p.formLabel').click(function(){
            $(this).parent().children('.form-style').focus();
        });

        $('p.formLabel2').click(function(){
            $(this).parent().children('.form-style').focus();
        });
    });


    function getPage2(url) {
        $.ajax({
            type: "get",
            data: "",
            url: url,
            cache: false,
            success: function (data) {
                console.log(data);
                $("#formWrapper").html(data);
            }
        })
        // }
    }
</script>
