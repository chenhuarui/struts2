package entity;

import homework.entity.Student;

import java.util.ArrayList;
import java.util.List;


public class StuArray {

    List<Student> list = new ArrayList<>();

    public StuArray() {
        this.list = list;
        Student student = new Student("0001","陈华",28);
        Student student2 = new Student("0002","李花",41);
        Student student3 = new Student("0013","张生",89);
        Student student4 = new Student("0104","刘德华",29);
        Student student5 = new Student("1102","刘德华",29);

        list.add(student);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
