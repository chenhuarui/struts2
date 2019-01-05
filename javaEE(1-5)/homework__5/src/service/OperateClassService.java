package service;

import entity.ClazzEntity;
import entity.StudentEntity;

import java.util.List;

public interface OperateClassService {

    //查询班级列表
    List<ClazzEntity> query();

    //查询每个班级的人数
    List<Long> getCount();

    //新增班级
    void add(ClazzEntity clazzEntity);

    //删除指定的班级
    void delete(String id);

    //更新班级
    void update(ClazzEntity clazzEntity);

    //找到对应id的对象 即该条记录
    ClazzEntity selectById(String id);

    //根据classId返回该班级的所有学生信息列表
    List<StudentEntity> queryClassOfStudents(String id);

    //根据className找到相对应的id并返回
    String queryIdOfClass(String className);
}
