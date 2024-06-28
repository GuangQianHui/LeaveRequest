<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container">
<h1>请假条</h1>
<form id="leaveRequestForm">
    <div class="form-group">
        <label for="student-id">学号：</label>
        <input type="text" id="student-id" name="" required="required">
        <label for="name">姓名:</label>
        <input type="text" id="name" name="name" required="required"><br><br>
    </div>
    <div class="form-group">
        <label for="email">邮箱：</label>
        <input type="email" id="email" name="email" required><br><br>
    <label for="class">班级:</label>
    <input type="text" id="class" name="class" required><br><br>
    </div>
    <div class="form-group">
    <label for="contact">联系方式:</label>
    <input type="tel" id="contact" name="contact" maxlength="11" required><br><br>
<%--    </div>--%>
<%--    <div class="form-group">--%>
        <label for="dorm1">寝室号:</label>
<%--        <input type="number" id="dorm" name="dorm" required="required">--%>
        <input type="number" id="dorm1" name="dorm1" required="required">
        <label for="dorm2">栋</label>
        <input type="number" id="dorm2" name="dorm2" required="required">
        <br><br>
    </div>
    <div class="form-group">
    <label for="parentName">家长姓名:</label>
    <input type="text" id="parentName" name="parentName" required><br><br>
<%--    </div>--%>
<%--    <div class="form-group">--%>
    <label for="parentContact">家长联系方式:</label>
    <input type="tel" id="parentContact" name="parentContact" maxlength="11" required><br><br>
    </div>

    <div class="form-group">
    <label for="reason">请假事由:</label>
    <select id="reason" name="reason" required>
        <option value="事假">事假</option>
        <option value="病假">病假</option>
    </select><br><br>
<%--    </div>--%>
<%--    <div class="form-group">--%>
        <label for="specific_reasons">具体原因：</label><textarea id="specific_reasons" class="only-one-content" placeholder="与其赞同别人的话语，不如自己畅所欲言。" required></textarea>
    </div>
    <div class="form-group">
    <label for="startDate">请假开始时间:</label>
    <input type="date" id="startDate" name="startDate" required><br><br>
<%--    </div>--%>
<%--    <div class="form-group">--%>
    <label for="endDate">请假结束时间:</label>
    <input type="date" id="endDate" name="endDate" required><br><br>
    </div>
    <div class="form-group">
        <label class="checkbox-label" for="overTwoDays">是否超过两天</label>
        <input type="checkbox" id="overTwoDays" name="overTwoDays" class="checkbox-custom">
        <div class="checkbox-custom-indicator"></div>
    </div>
    <button type="button" id="submitLeaveRequest">提交请假申请</button>
</form>
<script src="js/absence-request-js.js" type="text/javascript"></script>
</div>
