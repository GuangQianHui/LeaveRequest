package bean;

import java.sql.Date;

public class Student {
    private int id;
    private String studentId;
    private String name;
    private String className;
    private String contact;
    private String email;
//    private String password;
    private String dormitory;
    private Date createdAt;
    private Date updatedAt;

    public Student() {
    }

    public Student(int id, String studentId, String name, String className, String contact, String email, String dormitory, Date createdAt, Date updatedAt) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.className = className;
        this.contact = contact;
        this.email = email;
        this.dormitory = dormitory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }
}
