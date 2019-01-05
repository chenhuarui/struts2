package homework.service;

import homework.dao.ClazzClass;
import homework.entity.ClazzEntity;
import homework.entity.StudentEntity;

import java.util.List;

public class OperateClass {

    private ClazzClass clazzClass = new ClazzClass();

    //查询班级列表
    public List<ClazzEntity> query() {
        return clazzClass.query();
    }

    //查询每个班级的人数
    public List<Long> getCount() {
        return clazzClass.getRecordCount();
    }

    //新增班级
    public void add(ClazzEntity clazzEntity) {
        clazzClass.add(clazzEntity);
    }

    //删除指定的班级
    public void delete(String id){
        ClazzEntity clazzEntity = new ClazzEntity();
        clazzEntity.setId(id);
        clazzClass.delete(clazzEntity);
    }

    //更新班级
    public void update(ClazzEntity clazzEntity) {
        clazzClass.update(clazzEntity);
    }

    //找到对应id的对象 即该条记录
    public ClazzEntity selectById(String id){
        return clazzClass.selectById(id);
    }

    //根据classId返回该班级的所有学生信息列表
    public List<StudentEntity> queryClassOfStudents(String id) {
        return clazzClass.queryClassOfStudents(id);
    }

    //根据className找到相对应的id并返回
    public String queryIdOfClass(String className) {
        return clazzClass.qureyIdOfClass(className).getId();
    }

}
