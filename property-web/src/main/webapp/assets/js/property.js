/* 预检验手机号是否已注册 */
$(function () {
    var phoneLogin = $('#phoneLogin').val();
    /* 模态框传值 */
    $("#modalForgetPwdClick").click(function () {
        $("#phoneForgetPwd").val(phoneLogin);
    });
});