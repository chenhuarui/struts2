package service;

import entity.StudentEntity;

import java.util.List;

public interface OperateStudentService {

    //新增学生信息
    void addStudent(StudentEntity student);

    //删除指定学生信息
    void deleteStudent(String ID);

    //编辑指定学生信息
    void update(StudentEntity student);

    //根据studentId查询指定学生对象并返回
    StudentEntity selectById(String id);

    //返回该操作学生的班级的学生列表
    List<StudentEntity> getStudentListOfOperate(String id);
}
