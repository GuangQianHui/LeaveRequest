<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
    <link rel="icon" type="image/png" href="images/chizhou2.png">
    <link rel="stylesheet" href="style/login-style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
</head>
<body>
<div class="container">
    <img src="images/qingjiatubiao.png" alt="Login Icon" class="icon">
    <h2 class="login-title">学生请假系统</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form action="login" method="post">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div class="form-group">
            <label for="password">密  码：</label>
            <input type="password" id="password" name="password" required />
        </div>
        <input type="submit" value="登录" class="btn" />
    </form>
</div>

<div class="animated-shapes">
    <!-- 圆形 -->
    <div class="shape circle shape1"></div>
    <div class="shape circle shape4"></div>
    <!-- 正方形 -->
    <div class="shape square shape2"></div>
    <div class="shape square shape5"></div>
    <!-- 三角形 -->
    <div class="shape triangle shape3"></div>
    <div class="shape triangle shape6"></div>
</div>
</body>
</html>
