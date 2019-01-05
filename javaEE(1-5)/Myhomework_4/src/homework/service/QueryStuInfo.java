package homework.service;


import homework.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据筛选条件来获取学生列表并返回
 */
public class QueryStuInfo {

    List<StudentEntity> newStudents = new ArrayList<>();

    //整合查询String类型：学号和姓名
    public List<StudentEntity> queryString(String key, String attribute, String operation, List<StudentEntity> students) {

        if (operation.equals("包含")) {
            if (attribute.equals("学号")) {
                for (StudentEntity stu : students) {
                    if (stu.getStudentId().contains(key)) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (StudentEntity stu : students) {
                    if (stu.getStudentName().contains(key)) {
                        newStudents.add(stu);
                    }
                }
            }
        } else if (operation.equals("等于")) {
            if (attribute.equals("学号")) {
                for (StudentEntity stu : students) {
                    if (stu.getStudentId().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (StudentEntity stu : students) {
                    if (stu.getStudentName().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            }
        }

        return newStudents;
    }

    //查询年龄
    public List<StudentEntity> queryAge(String key, String operation,List<StudentEntity> students) {
        if (operation.equals("大于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() > Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("大于等于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() >= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("小于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() < Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }else if(operation.equals("小于等于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() <= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }

        return newStudents;
    }

}
