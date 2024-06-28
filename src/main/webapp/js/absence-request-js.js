
$(document).ready(function() {
    $('.checkbox-custom-indicator').click(function() {
        // 触发与之关联的复选框的点击事件
        $(this).prev('.checkbox-custom').click();
    });
    $("#submitLeaveRequest").click(function() {
        let overTwoDays;
        if ($("#overTwoDays").is(":checked")) {
            overTwoDays = '是';
        }else {
            overTwoDays = '否';
        }
        // 收集表单数据
        const student = {
            studentId: $("#student-id").val(),
            name: $("#name").val(),
            className: $("#class").val(),
            contact: $("#contact").val(),
            email: $("#email").val(),
            dormitory: $("#dorm").val()
        };
        const parent = {
            name: $("#parentName").val(),
            contact: $("#parentContact").val()
        };
        const data = {
            student: student,
            parent: parent,
            leaveType: $("#reason").val(),
            specificReasons: $("#specific_reasons").val(),
            startDate: $("#startDate").val(),
            endDate: $("#endDate").val(),
            isOverTwoDay: overTwoDays
        };

        // 发送 AJAX 请求
        $.ajax({
            type: "POST",
            url: "leaveRequest",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function() {
                // 处理成功响应
                alert("请假申请已提交！");
            },
            error: function() {
                // 处理错误响应
                alert("请假申请提交失败！");
            }
        });
    });
});
