package homework.entity;

public class Student {

    public Student(String stuNo, String stuName, Integer age) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.age = age;
    }

    private String stuNo;

    private String stuName;

    private Integer age;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
