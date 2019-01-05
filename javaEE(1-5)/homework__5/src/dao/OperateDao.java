package dao;

import entity.ClazzEntity;
import entity.StudentEntity;

import java.util.List;

public interface OperateDao {

    //添加班级和学生记录
    void add(Object obj);

    //删除班级和学生的记录
    void delete(Object object);

    //查询数据库中班级表所有班级信息
    List<ClazzEntity> queryClass();

    //更新班级信息(完善:需要设置id不能够修改)
    void update(Object obj);

    //查询各个班级的人数
    List<Long> getRecordCount();

    //查询到指定id的对象 即该条记录
    ClazzEntity selectById(String id);

    //查询选择班级的所有学生并返回学生信息列表
    List<StudentEntity> queryClassOfStudents(String classId);

    //查询指定id的对象 即该条记录
    StudentEntity selectByStudentId(String id);

    //根据name来查询并返回id
    ClazzEntity queryIdOfClass(String className);

}
