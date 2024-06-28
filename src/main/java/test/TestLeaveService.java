package test;

import bean.LeaveApplication;
import bean.Parent;
import bean.Student;
import dao.LeaveApplicationDao;
import dao.impl.LeaveApplicationDaoImpl;
import service.LeaveApplicationService;
import service.impl.LeaveApplicationServiceImpl;

import java.sql.Date;
import java.util.List;

public class TestLeaveService {
    public static void main(String[] args) {
//        Student student = new Student();
//        Date startDate = new Date(20231202);
//        Date endDate = new Date(22331102);
//        Parent parent = new Parent("马银","1872639");
//        LeaveApplication leaveApplication =new LeaveApplication();
//        leaveApplication.setStudent(student);
//        leaveApplication.setParent(parent);
//        leaveApplication.setLeaveType("事假");
//        leaveApplication.setSpecificReasons("只可意会不可言传");
//        leaveApplication.setStartDate(startDate);
//        leaveApplication.setEndDate(endDate);
//        leaveApplication.setIsOverTwoDay("是");
        LeaveApplicationDao leaveApplicationDao = new LeaveApplicationDaoImpl();
        LeaveApplicationService leaveApplicationService = new LeaveApplicationServiceImpl(leaveApplicationDao);
//        leaveApplicationService.addLeaveApplication(leaveApplication);
        List<LeaveApplication> allLeaveApplication = leaveApplicationService.getAllLeaveApplication();
        for (LeaveApplication leaveApplication : allLeaveApplication) {
            System.out.println(leaveApplication.getStudent().getStudentId());
            System.out.println(leaveApplication.getStudent().getName());
            System.out.println(leaveApplication.getStudent().getContact());
            System.out.println(leaveApplication.getStudent().getEmail());

        }
    }
}
