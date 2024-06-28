package controller;

import bean.LeaveApplication;
import dao.LeaveApplicationDao;
import dao.impl.LeaveApplicationDaoImpl;
import service.LeaveApplicationService;
import service.impl.LeaveApplicationServiceImpl;
import utils.RequestResponseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/leaveRequest")
public class LeaveApplicationServlet extends HttpServlet {
    private LeaveApplicationService leaveApplicationService;

    @Override
    public void init()  {
        LeaveApplicationDao leaveApplicationDao = new LeaveApplicationDaoImpl();
        leaveApplicationService = new LeaveApplicationServiceImpl(leaveApplicationDao);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        List<LeaveApplication> leaveApplications = leaveApplicationService.getAllLeaveApplication();
        RequestResponseUtil.writeJsonResponse(response,leaveApplications); // 将List<Message>序列化为JSON字符串

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        //将数据序列化
        LeaveApplication leaveApplication = RequestResponseUtil.readJsonFromRequest(request, LeaveApplication.class);

//        String customHeader = request.getHeader ("X-Absence-Header");
//
//        if (Objects.equals(customHeader, "delete")) {
//            //删除指定ID的用户
//            leaveApplicationService.deleteLeaveApplication(leaveApplication.getId());
//        } else if (Objects.equals(customHeader, "add")){
//            leaveApplicationService.addLeaveApplication(leaveApplication);
//        }
        leaveApplicationService.addLeaveApplication(leaveApplication);
        System.out.println("学号\t" + leaveApplication.getStudent().getStudentId());
        System.out.println("姓名\t" + leaveApplication.getStudent().getName());
        System.out.println("班级\t" + leaveApplication.getStudent().getClassName());
        System.out.println("联系方式\t" + leaveApplication.getStudent().getContact());
        System.out.println("寝室\theeeee" + leaveApplication.getStudent().getDormitory());
        System.out.println("邮箱\thheeee" + leaveApplication.getStudent().getEmail());
        //
        System.out.println("家长姓名\teefefef" + leaveApplication.getParent().getName());
        System.out.println("家长联系方式\t" + leaveApplication.getParent().getContact());
        System.out.println("请假事由\t" + leaveApplication.getLeaveType());
        System.out.println("请假具体原因\t" + leaveApplication.getSpecificReasons());
        System.out.println("开始时间\t" + leaveApplication.getStartDate());
        System.out.println("截止时间\t" + leaveApplication.getEndDate());
        System.out.println("是否超过两天\t" + leaveApplication.getIsOverTwoDay());
    }
}

