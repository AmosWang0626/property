<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    <title>ProductPage</title>
    <link href="<%=basePath %>assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/property.css" rel="stylesheet">
</head>

<body>

<div class="container ssm-div">
    <!-- 导航栏 -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">产品管理后台</div>
            </div>
            <c:choose>
                <c:when test="${empty user_login}">
                    <ul class="nav navbar-nav pull-right" id="product-login">
                        <li><a href="login">登录</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right" id="product-logout">
                        <li><a><span id="greetings">美好的一天</span></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <span id="user-id"></span>
                                <span id="user-name">${user_login}</span>
                                <span class="caret"></span>
                                <ul class="dropdown-menu">
                                    <li role="presentation"><a href="#">修改资料</a></li>
                                    <li role="presentation"><a href="#">修改密码</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li role="presentation"><a href="login">退出登录</a></li>
                                </ul>
                            </a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>

    <!-- 产品增加 -->
    <button class="btn btn-default pull-right" type="button" data-toggle="modal" data-target="#modalProductAdd">新增</button>

    <!-- Modal 产品增加 -->
    <div class="modal fade" id="modalProductAdd" tabindex="-1" role="dialog" aria-labelledby="modalProductAddLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <form class="form-ssm" id="productAddForm" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title" id="modalProductAddLabel">增加产品</h4>
                    </div><!-- modal-header -->
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="sr-only" for="nameAddProduct">产品名称</label>
                            <input class="form-control" id="nameAddProduct" placeholder="产品名称" required
                                   autofocus>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="priceAddProduct">产品价格</label>
                            <input class="form-control" id="priceAddProduct" placeholder="产品价格" required>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="infoAddProduct">产品信息</label>
                            <input class="form-control" id="infoAddProduct" placeholder="产品信息" required>
                        </div>
                    </div><!-- modal-body -->
                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
                        <button class="btn btn-primary">增加</button>
                    </div><!-- modal-footer -->
                </form><!-- register -->

            </div><!-- modal-content -->
        </div>
    </div>

    <!-- 产品表格 -->
    <table class="table table-striped table-bordered table-hover table-responsive">
        <thead>
        <tr>
            <th>产品名</th>
            <th>价格</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="product-id"></td>
            <td>香蕉</td>
            <td>2.5</td>
            <td>进口香蕉</td>
            <td>
                <div class="btn-group" role="group" aria-label="操作">
                    <button class="btn btn-default btn-sm" type="button" data-toggle="modal"
                            data-target="#modalProductModify">修改
                    </button>
                    <button class="btn btn-default btn-sm" type="button">删除</button>
                </div>
            </td>
        </tr>
        </tbody>
    </table>

    <!-- Modal 产品修改 -->
    <div class="modal fade" id="modalProductModify" tabindex="-1" role="dialog"
         aria-labelledby="modalProductModifyLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <form class="form-ssm" id="productModifyForm" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title" id="modalProductModifyLabel">修改产品信息</h4>
                    </div><!-- modal-header -->
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="sr-only" for="nameModifyProduct">产品名称</label>
                            <input class="form-control" id="nameModifyProduct" placeholder="产品名称" required
                                   autofocus>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="priceModifyProduct">产品价格</label>
                            <input class="form-control" id="priceModifyProduct" placeholder="产品价格" required>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="infoModifyProduct">产品信息</label>
                            <input class="form-control" id="infoModifyProduct" placeholder="产品信息" required>
                        </div>
                    </div><!-- modal-body -->
                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
                        <button class="btn btn-primary">修改</button>
                    </div><!-- modal-footer -->
                </form><!-- register -->

            </div><!-- modal-content -->
        </div>
    </div>

    <!-- 分页条 -->
    <nav class="paging" aria-label="paging">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span>&laquo;&nbsp;上一页</span>
                </a>
            </li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span>下一页&nbsp;&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script src="<%=basePath %>assets/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath %>assets/js/bootstrap.min.js"></script>
<script src="<%=basePath %>assets/js/property.js"></script>
</body>
</html>
