package homework.service;


import homework.entity.StuArray;
import homework.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryStuInfo {

    StuArray stuArray = new StuArray();

    //获得学生名单信息
    List<Student> students = stuArray.getList();

    List<Student> newStudents = new ArrayList<>();

    //整合查询String类型：学号和姓名
    public List<Student> queryString(String key, String attribute, String operation) {
        if (operation.equals("包含")) {
            if (attribute.equals("学号")) {
                for (Student stu : students) {
                    if (stu.getStuNo().indexOf(key) != -1) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (Student stu : students) {
                    if (stu.getStuName().indexOf(key) != -1) {
                        newStudents.add(stu);
                    }
                }
            }
        } else if (operation.equals("等于")) {
            if (attribute.equals("学号")) {
                for (Student stu : students) {
                    if (stu.getStuNo().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (Student stu : students) {
                    if (stu.getStuName().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            }
        }

        return newStudents;
    }

    //查询年龄
    public List<Student> queryAge(String key, String operation) {
        if (operation.equals("大于")) {
            for (Student stu : students) {
                if (stu.getAge() > Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("大于等于")) {
            for (Student stu : students) {
                if (stu.getAge() >= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("小于")) {
            for (Student stu : students) {
                if (stu.getAge() < Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }else if(operation.equals("小于等于")) {
            for (Student stu : students) {
                if (stu.getAge() <= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }

        return newStudents;
    }

}
