package dao.impl;

import bean.LeaveApplication;
import bean.Parent;
import bean.Student;
import dao.LeaveApplicationDao;
import utils.MySQLJDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveApplicationDaoImpl implements LeaveApplicationDao {

    @Override
    public void deleteLeaveApplication(int studentId) {
        String deleteSQL = "DELETE FROM absence_db.leaveRequest WHERE studentId = ?";
        int deletedRows = MySQLJDBCUtil.delete(deleteSQL, studentId);
        if (deletedRows == 1) {
            System.out.println("LeaveRequest delete successfully!");
        } else {
            System.out.println("LeaveReques delete failed!.");
        }

    }

    @Override
    public void addLeaveApplication(LeaveApplication leaveApplication) {
        //         插入数据示例
        String insertSQL1 = "INSERT INTO users (student_id,name,class,contact,email,dormitory) VALUES (?,?,?,?,?,?)";
        String insertSQL2 = "INSERT INTO parents (student_id,parent_name,parent_contact) VALUES (?,?,?)";
        String insertSQL3 = "INSERT INTO leaverequest" +
                "(studentId,parentName,leave_type,specific_reasons,start_date,end_date,is_over_two_day,review_result) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        //学生信息 id   | student_id name class contact email dormitory
        Student student = leaveApplication.getStudent();
        int studentInsertedRows = MySQLJDBCUtil.insert(insertSQL1,
                student.getStudentId(),
                student.getName(),
                student.getClassName(),
                student.getContact(),
                student.getEmail(),
                student.getDormitory());

        Parent parent = leaveApplication.getParent();
        int parentInsertedRows = MySQLJDBCUtil.insert(insertSQL2,
                parent.getStudent_id(),
                parent.getName(),
                parent.getContact());

        int leaveRequestInsertedRows = MySQLJDBCUtil.insert(insertSQL3,
                student.getStudentId(),
                parent.getName(),
                leaveApplication.getLeaveType(),
                leaveApplication.getSpecificReasons(),
                leaveApplication.getStartDate(),
                leaveApplication.getEndDate(),
                leaveApplication.getIsOverTwoDay(),
                leaveApplication.getReviewResult());
        if (studentInsertedRows == 1) {
            System.out.println("student Insert successfully!");
        } else {
            System.out.println("student Insert failed!.");
        }
        if (parentInsertedRows == 1) {
            System.out.println("parent Insert successfully!");
        } else {
            System.out.println("parent Insert failed!.");
        }if (leaveRequestInsertedRows == 1) {
            System.out.println("leaveRequest Insert successfully!");
        } else {
            System.out.println("leaveRequest Insert failed!.");
        }
    }

    @Override
    public List<LeaveApplication> getAllLeaveApplication() {
        List<LeaveApplication> leaveApplications = new ArrayList<>();
        // 查询数据
        String querySQL1 = "SELECT * FROM absence_db.leave_applications";
        String querySQL2 = "SELECT * FROM absence_db.users";
        String querySQL3 = "SELECT * FROM absence_db.parents";
        try {
            ResultSet resultSet1 = MySQLJDBCUtil.query(querySQL1);//请假条
            ResultSet resultSet2 = MySQLJDBCUtil.query(querySQL2);//学生
            ResultSet resultSet3 = MySQLJDBCUtil.query(querySQL3);//父母
            while (resultSet1.next()&& resultSet2.next()&&resultSet3.next()) {
                LeaveApplication leaveApplication = new LeaveApplication();
                //学生信息 id   | student_id name class contact email dormitory
                leaveApplication.getStudent().setStudentId(resultSet2.getString("student_id"));
                leaveApplication.getStudent().setName(resultSet2.getString("name"));
                leaveApplication.getStudent().setClassName(resultSet2.getString("class"));
                leaveApplication.getStudent().setContact(resultSet2.getString("contact"));
                leaveApplication.getStudent().setEmail(resultSet2.getString("email"));
                leaveApplication.getStudent().setDormitory(resultSet2.getString("dormitory"));
                //父母 parent_name parent_contact
                leaveApplication.getParent().setName(resultSet3.getString("parent_name"));
                leaveApplication.getParent().setContact(resultSet3.getString("parent_contact"));
                //请假条leave_type  specific_reasons start_date end_date submitted_at review_result
                leaveApplication.setLeaveType(resultSet1.getString("leave_type"));
                leaveApplication.setSpecificReasons(resultSet1.getString("specific_reasons"));
                leaveApplication.setStartDate(resultSet1.getDate("start_date"));
                leaveApplication.setEndDate(resultSet1.getDate("end_date"));
                leaveApplication.setSubmittedAt(resultSet1.getDate("submittedAt"));
                leaveApplication.setReviewResult(resultSet1.getString("review_result"));
                leaveApplications.add(leaveApplication);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return leaveApplications;
    }

    @Override
    public void updateLeaveApplicationDate(LeaveApplication leaveApplication) {
        // 更新数据示例
        String updateSQL = "UPDATE absence_db.leaverequest SET start_date = ?, end_date = ? WHERE studentId = ?";
        int updatedRows = MySQLJDBCUtil.update(updateSQL,
                leaveApplication.getStartDate(),
                leaveApplication.getEndDate(),
                leaveApplication.getStudent().getStudentId());
        if (updatedRows > 0) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("No user found with the provided ID.");
        }
    }
}


