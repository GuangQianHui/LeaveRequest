package bean;

import java.sql.Date;

public class LeaveApplication {
    // 第一张表
    private Student student;

    private Parent parent;

    private String leaveType;//请假事由
    private String specificReasons;//请假具体原因

    private Date startDate;//请假开始时间
    private Date endDate;//请假截止时间
    private String isOverTwoDay;//是否超过两天

    private Date submittedAt;//提交时间
    private String reviewResult;//审核状态

    public LeaveApplication() {
    }

    public LeaveApplication(Student student, Parent parent, String leaveType, String specificReasons, Date startDate, Date endDate, String isOverTwoDay, Date submittedAt, String reviewResult) {
        this.student = student;
        this.parent = parent;
        this.leaveType = leaveType;
        this.specificReasons = specificReasons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isOverTwoDay = isOverTwoDay;
        this.submittedAt = submittedAt;
        this.reviewResult = reviewResult;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getSpecificReasons() {
        return specificReasons;
    }

    public void setSpecificReasons(String specificReasons) {
        this.specificReasons = specificReasons;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIsOverTwoDay() {
        return isOverTwoDay;
    }

    public void setIsOverTwoDay(String isOverTwoDay) {
        this.isOverTwoDay = isOverTwoDay;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }
}
