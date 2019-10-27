<div id="login">
    <form action="/login" method="post">
        <div id="form">
            <div class="logo">
                <h1 class="text-center head">User Login</h1>
            </div>
            <div class="form-item">
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
                <p class="pull-left"><a href="#"><small>Register</small></a></p>
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
            $('div#formWrapper').addClass('darken-bg');
            $('div.logo').addClass('logo-active');
        });
        formInputs.focusout(function() {
            if ($.trim($(this).val()).length == 0){
                $(this).parent().children('p.formLabel').removeClass('formTop');
            }
            $('div#formWrapper').removeClass('darken-bg');
            $('div.logo').removeClass('logo-active');
        });
        $('p.formLabel').click(function(){
            $(this).parent().children('.form-style').focus();
        });
    });
</script>
