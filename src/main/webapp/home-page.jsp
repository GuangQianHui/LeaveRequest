<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css ">

    <link rel="icon" type="image/png" href="images/chizhou2.png">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigv"
          crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="style/home-page-style.css">
    <link rel="stylesheet" type="text/css" href="style/absence-request-style.css">
<%--    <link rel="stylesheet" type="text/css" href="styles/home-page-management-messages-style.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="styles/home-page-management-users-style.css">--%>

    <!-- 引入Font Awesome图标字体库 -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Montserrat:wght@500;700&display=swap" rel="stylesheet">
</head>
<body>
<div id="sidebar">
<%--    <div id="toggle-sidebar">>></div> <!-- 侧边栏折叠/展开的切换按钮 -->--%>
    <h1>学生请假系统</h1>
    <div id="toggle-sidebar" title="折叠/展开侧边栏"><i class="fas fa-bars"></i></div>
    <a href="#" class="subpage-btn selected" data-url="sub-page/absence-request.jsp">请假申请</a>
    <a href="#" class="subpage-btn selected" data-url="Subpages/management-logs.jsp">个人请假信息</a>
<%--    <a href="#" class="subpage-btn selected" data-url="Subpages/management-users.jsp">用户管理</a>--%>
<%--    <a href="#" class="subpage-btn selected" data-url="Subpages/management-messages.jsp">留言管理</a>--%>
<%--    <a href="#" class="subpage-btn selected" data-url="Subpages/writing-logs.jsp">撰写日志</a>--%>
</div>
<div id="content">
    <div id="subpage-content">
        <%--++++++++++++++++--%>
        <h1>欢迎大家来使用我们的请假系统！</h1>
        <div class="rotating-widget" id="widget1">
            <div class="text">很高兴见到你！</div>
        </div>
        <div class="rotating-widget" id="widget2">
            <div class="text">皮卡~皮卡~</div>
        </div>
        <div class="rotating-widget" id="widget3">
            <div class="text">芜湖~芜湖~要放假啦！拉-啦！</div>
        </div>
        <div class="rotating-widget" id="widget4">
            <div class="text">我要圆了。</div>
        </div>
            <div class="rotating-widget" id="widget4">
                <div class="text">我要圆了。</div>
            </div>
        <script src="js/script.js"></script>
    </div>
</div>
<script type="text/javascript" src="js/home-page-js.js"></script>

</body>
</html>
