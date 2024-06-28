package bean;

public class Parent {
    private String name;//家长姓名
    private String contact;//家长联系方式
    private final String student_id = new Student().getStudentId();


    public Parent() {
    }

    public Parent(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStudent_id() {
        return student_id;
    }
}
