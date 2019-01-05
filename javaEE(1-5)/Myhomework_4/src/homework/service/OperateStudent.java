package homework.service;

import homework.dao.ClazzClass;
import homework.entity.StudentEntity;

public class OperateStudent {

    ClazzClass clazzClass = new ClazzClass();

    //新增学生信息
    public void addStudent(StudentEntity student) {
        clazzClass.add(student);
    }

    //删除指定学生信息
    public void deleteStudent(String ID) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(ID);
        clazzClass.delete(studentEntity);
    }

    //编辑指定学生信息
    public void update(StudentEntity student) {
        clazzClass.update(student);
    }

    //根据studentId查询指定学生对象并返回
    public StudentEntity selectById(String id) {
        return clazzClass.selectByStudentId(id);
    }
}
