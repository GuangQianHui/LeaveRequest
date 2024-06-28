package dao;

import bean.LeaveApplication;
import bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface LeaveApplicationDao {
    void deleteLeaveApplication(int id);
    void addLeaveApplication(LeaveApplication leaveApplication);
    List<LeaveApplication> getAllLeaveApplication();
    //修改请假截止时间
    void updateLeaveApplicationDate(LeaveApplication leaveApplication);
}
