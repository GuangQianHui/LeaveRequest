package service.impl;

import bean.LeaveApplication;

import dao.LeaveApplicationDao;
import service.LeaveApplicationService;

import java.util.List;

public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    private final LeaveApplicationDao leaveApplicationDao;

    public LeaveApplicationServiceImpl(LeaveApplicationDao leaveApplicationDao) {
        this.leaveApplicationDao = leaveApplicationDao;
    }

    @Override
    public void deleteLeaveApplication(int id) {
        leaveApplicationDao.deleteLeaveApplication(id);
    }

    @Override
    public void addLeaveApplication(LeaveApplication leaveApplication) {
        leaveApplicationDao.addLeaveApplication(leaveApplication);
    }

    @Override
    public List<LeaveApplication> getAllLeaveApplication() {
        return leaveApplicationDao.getAllLeaveApplication();
    }

    @Override
    public void updateLeaveApplicationDate(LeaveApplication leaveApplication) {
        leaveApplicationDao.updateLeaveApplicationDate(leaveApplication);
    }
}
