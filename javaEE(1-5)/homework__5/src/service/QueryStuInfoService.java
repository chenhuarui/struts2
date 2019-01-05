package service;


import entity.StudentEntity;
import java.util.List;

/**
 * 根据筛选条件来获取学生列表并返回
 */
public interface QueryStuInfoService {

    //根据班级姓名查询对应的班级ID
    String queryIdOfClass(String className);

    //根据得到的classId 查询Student表 返回list
    List<StudentEntity> queryClassOfStudents(String classId);

    //整合查询String类型：学号和姓名
    List<StudentEntity> queryString(String key, String attribute, String operation, List<StudentEntity> students);

    //查询年龄
    List<StudentEntity> queryAge(String key, String operation,List<StudentEntity> students);
}
