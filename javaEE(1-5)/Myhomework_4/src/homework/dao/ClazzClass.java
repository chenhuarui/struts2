package homework.dao;

import homework.entity.ClazzEntity;
import homework.entity.StudentEntity;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClazzClass extends BaseClass {

    //添加班级以及学生记录
    public void add(Object obj) {

        if(obj instanceof ClazzEntity) {

            ClazzEntity clazz = (ClazzEntity) obj;
            ClazzEntity clazzEntity = new ClazzEntity();
            clazzEntity.setId(clazz.getId());
            clazzEntity.setSerialNumber(clazz.getSerialNumber());
            InitializeBase().save(clazzEntity);

        }else {
            StudentEntity student = (StudentEntity) obj;
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setClassId(student.getClassId());
            studentEntity.setStudentId(student.getStudentId());
            studentEntity.setStudentName(student.getStudentName());
            studentEntity.setStudentAge(student.getStudentAge());
            InitializeBase().save(studentEntity);

        }
        endBase();
    }

    //删除班级以及学生的记录
    public void delete(Object object) {
        InitializeBase().delete(object);
        endBase();
    }

    //查询数据库中班级表所有班级信息
    public List<ClazzEntity> query() {
        String hql = "from ClazzEntity ";
        List<ClazzEntity> list = InitializeBase().createQuery(hql).list();
        endBase();
        return list;
    }

    //更新班级或者是学生信息(完善:需要设置id不能够修改)
    public void update(Object obj) {
        InitializeBase().update(obj);
        endBase();
    }

    //查询各个班级的人数
    public List<Long> getRecordCount() {

        List<ClazzEntity> list = query();
        List<Long> countList = new ArrayList<>();

        for (ClazzEntity clazzEntity: list) {

            String hql = "select count(*) from StudentEntity where classId = "+clazzEntity.getId();
            Query count = InitializeBase().createQuery(hql);
            countList.add((Long) count.uniqueResult());
        }
        endBase();
        return countList;
    }

    //班级
    //查询到指定id的班级对象 并返回
    public ClazzEntity selectById(String id){
        String hql = "from ClazzEntity where id = :id";
        Query query = InitializeBase().createQuery(hql).setParameter("id", id);
        return (ClazzEntity) query.uniqueResult();
    }

    //查询选择班级的所有学生 并返回学生信息列表
    public List<StudentEntity> queryClassOfStudents(String id) {
        String hql="from StudentEntity where classId = :id";
        List<StudentEntity> list = InitializeBase().createQuery(hql).setParameter("id", id ).list();
        return list;
    }

    //查询指定id的学生对象 即该条记录
    public StudentEntity selectByStudentId(String id) {
        String hql ="from StudentEntity where studentId = :id";
        Query query = InitializeBase().createQuery(hql).setParameter("id" , id);
        return (StudentEntity) query.uniqueResult();
    }

    //根据className来查询并返回id
    public ClazzEntity qureyIdOfClass(String className) {
        String hql = "from ClazzEntity where serialNumber = :name";
        Query query = InitializeBase().createQuery(hql).setParameter("name" , className);
        return (ClazzEntity) query.uniqueResult();
    }

}


