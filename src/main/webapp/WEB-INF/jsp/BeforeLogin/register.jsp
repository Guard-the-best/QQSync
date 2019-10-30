<style>
    .okmsg{
    color:green;
}
    .errormsg{
        color:red;
    }
</style>

<div id="register">

    <div id="form">
        <form id="registerForm" action="javascript:void (0)" method="post">
        <div class="logo">
            <h1 class="text-center head">Register</h1>
        </div>
        <div class="form-item">
            <p class="formLabel">UserID...</p>
            <input type="text" name="registerID" id="registerID" class="form-style" onblur="checkUserName()" autocomplete="off"/>
            <span id="isExistInfo"></span>
        </div>
        <div class="form-item">
            <p class="formLabel">Password...</p>
            <input type="password" name="registerPassword" id="registerPassword" class="form-style" />
            <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
        </div>
        <div class="form-item">
            <p class="formLabel">ConfirmPassword...</p>
            <input type="password" name="confirmPassword" id="confirmPassword" class="form-style" />
            <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
        </div>
        <div class="form-item">
            <input onclick="submitRegisterInfo()" type="submit" class="login pull-right" value="Regist">
            <div class="clear-fix"></div>
        </div>
        </form>
    </div>

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

    function checkUserName() {
        var username = document.getElementById('registerID').value;
        $.ajax({
            type: "post",
            url: "/isUsernameExist?username=" + username,
            data: {},
            success: function (data) {
                var msg =document.getElementById('isExistInfo');
                if(data=='Exist'){
                    msg.classList.add('okmsg');
                    msg.innerText='Valid UserName';
                }
                else if(data=='Not Exist'){
                    msg.classList.add('errormsg');
                    msg.innerText='Invalid UserName';
                }
            }
        })
    }


    function submitRegisterInfo() {
        $.ajax({
            type: "post",
            url: "/register",
            data: $('#registerForm').serialize(),
            success: function (data) {
                console.log(data);
                $("#formWrapper").html(data);
                alert("注册成功！")
            }
        })
    }

</script>