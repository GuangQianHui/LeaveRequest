package service;

import bean.LeaveApplication;

import java.util.List;

public interface LeaveApplicationService {
    void deleteLeaveApplication(int id);
    void addLeaveApplication(LeaveApplication leaveApplication);
    List<LeaveApplication> getAllLeaveApplication();
    //修改请假截止时间
    void updateLeaveApplicationDate(LeaveApplication leaveApplication);
}
