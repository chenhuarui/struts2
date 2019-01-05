package test.io.file;

import homework.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class testArrayList {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(5);

        Student student = new Student("0001","陈华",28);
        Student student2 = new Student("0002","李花",41);

//        list.add(student);
//        list.add(student2);

        System.out.println(list);
    }
}
