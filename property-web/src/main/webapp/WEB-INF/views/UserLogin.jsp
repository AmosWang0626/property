<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Login</title>
    <link href="<%=basePath %>assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/property.css" rel="stylesheet">
</head>

<body>
<div class="container ssm-div">
    <!-- 用户登录 -->
    <form class="form-ssm" action="realLogin" method="post" data-toggle="validator">
        <h3 class="form-login-heading">请先登录</h3>

        <div class="form-group">
            <label class="sr-only control-label" for="phoneLogin">手机号</label>
            <input class="form-control" id="phoneLogin" name="phoneLogin" type="tel" placeholder="请输入您的手机号"
                   pattern="^1[345789]\d{9}$" data-error="请注意您的手机号格式" required autofocus>
            <div class="help-block with-errors"></div>
        </div>

        <div class="form-group">
            <label class="sr-only control-label" for="pwdLogin">密码</label>
            <input class="form-control" id="pwdLogin" name="pwdLogin" type="password" placeholder="请输入您的密码"
                   data-minlength="6" data-error="密码长度不少于六位" required>
        </div>

        <a data-toggle="modal" data-target="#modalForgetPwd" id="modalForgetPwdClick">忘记密码</a>
        <div class="help-block with-errors" id="login-fail">${requestScope.user_login}</div>
        <button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
        <button class="btn btn-info btn-block" type="button" data-toggle="modal" data-target="#modalRegister">
            没有账号,注册一个吧
        </button>
    </form>

    <!-- 用户注册 -->
    <div class="modal fade" id="modalRegister" tabindex="-1" role="dialog" aria-labelledby="modalRegisterLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <form class="form-ssm" id="registerForm" action="register" method="post" data-toggle="validator">

                    <div class="modal-header">
                        <h4 class="modal-title" id="modalRegisterLabel">用户注册</h4>
                    </div><!-- modal-header -->

                    <div class="modal-body">
                        <div class="form-group">
                            <label class="sr-only" for="nameRegister">用户名</label>
                            <input class="form-control" id="nameRegister" name="nameRegister" type="tel"
                                   placeholder="用户名"
                                   data-minlength="2" data-error="用户名不能少于两位哦" required autofocus>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="phoneRegister">手机号</label>
                            <input class="form-control" id="phoneRegister" name="phoneRegister" type="tel"
                                   placeholder="请输入您的手机号"
                                   pattern="^1[345789]\d{9}$" data-error="请注意您的手机号格式" required autofocus>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="pwdRegister">密码</label>
                            <input class="form-control" id="pwdRegister" name="pwdRegister" type="password"
                                   placeholder="密码"
                                   data-minlength="6" data-error="密码长度不少于六位" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="inputPasswordConfirm">确认密码</label>
                            <input class="form-control" id="inputPasswordConfirm" type="password" placeholder="确认密码"
                                   data-match="#pwdRegister" data-error="两次密码不一致,请重新输入" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div><!-- modal-body -->

                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
                        <button class="btn btn-primary">注册</button>
                    </div><!-- modal-footer -->

                </form><!-- register -->

            </div><!-- modal-content -->
        </div>
    </div>

    <!-- 忘记密码 -->
    <div class="modal fade" id="modalForgetPwd" tabindex="-1" role="dialog" aria-labelledby="forgetPwdLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <form class="form-ssm" id="forgetPwdForm" action="forgetPassword" method="post"
                      data-toggle="validator">
                    <div class="modal-header">
                        <h4 class="modal-title" id="forgetPwdLabel">忘记密码</h4>
                    </div><!-- modal-header -->

                    <div class="modal-body">
                        <div class="form-group">
                            <label class="sr-only" for="name">用户名</label>
                            <input class="form-control" id="name" name="nameForgetPwd" type="tel"
                                   placeholder="用户名"
                                   data-minlength="2" data-error="用户名不能少于两位哦" required autofocus>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="phone">手机号</label>
                            <input class="form-control" id="phone" name="phoneForgetPwd" type="tel"
                                   placeholder="请输入您的手机号" value=""
                                   pattern="^1[345789]\d{9}$" data-error="请注意您的手机号格式" required autofocus><%--disabled--%>
                            <div class="help-block with-errors">请先填写登录时手机号</div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="password">密码</label>
                            <input class="form-control" id="password" name="pwdForgetPwd" type="password"
                                   placeholder="密码"
                                   data-minlength="6" data-error="密码长度不少于六位" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="pwdForgetPwdConfirm">确认密码</label>
                            <input class="form-control" id="pwdForgetPwdConfirm" type="password" placeholder="确认密码"
                                   data-match="#password" data-error="两次密码不一致,请重新输入" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div><!-- modal-body -->

                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
                        <button class="btn btn-primary">找回密码</button>
                    </div><!-- modal-footer -->

                </form><!-- register -->

            </div><!-- modal-content -->
        </div>
    </div>
    <!-- other -->
</div>
<script src="<%=basePath %>assets/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath %>assets/js/bootstrap.min.js"></script>
<script src="<%=basePath %>assets/js/validator.min.js"></script>
<script src="<%=basePath %>assets/js/property.js"></script>
</body>
</html>
