package dao.Impl;

import dao.OperateDao;
import entity.ClazzEntity;
import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OperateDaoImpl implements OperateDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Object obj) {
        if(obj instanceof ClazzEntity) {

            ClazzEntity clazz = (ClazzEntity) obj;
            ClazzEntity clazzEntity = new ClazzEntity();
            clazzEntity.setId(clazz.getId());
            clazzEntity.setSerialNumber(clazz.getSerialNumber());
            getSession().save(clazz);

        }else {
            StudentEntity student = (StudentEntity) obj;
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setClassId(student.getClassId());
            studentEntity.setStudentId(student.getStudentId());
            studentEntity.setStudentName(student.getStudentName());
            studentEntity.setStudentAge(student.getStudentAge());
            getSession().save(student);
        }
    }

    @Override
    public void delete(Object object) {
        getSession().delete(object);
    }

    @Override
    public List<ClazzEntity> queryClass() {
        String hql = "from ClazzEntity";
        List<ClazzEntity> list = getSession().createQuery(hql).list();
        return list;
    }

    @Override
    public void update(Object obj) {
        getSession().update(obj);
    }

    @Override
    public List<Long> getRecordCount() {
        List<ClazzEntity> list = queryClass();
        List<Long> countList = new ArrayList<>();

        for (ClazzEntity clazzEntity: list) {
            String hql = "select count(*) from StudentEntity c where c.classId = "+clazzEntity.getId();
            Query count = getSession().createQuery(hql);
            countList.add((Long) count.uniqueResult());
        }
        return countList;
    }

    //查询到指定id的班级对象 并返回
    @Override
    public ClazzEntity selectById(String id) {
        String hql = "from ClazzEntity  c where c.id = :id";
        Query query = getSession().createQuery(hql).setParameter("id", id);
        return (ClazzEntity) query.uniqueResult();
    }

    //查询选择班级的所有学生 并返回学生信息列表
    @Override
    public List<StudentEntity> queryClassOfStudents(String classId) {
        String hql="from StudentEntity where classId = :id";
        List<StudentEntity> list = getSession().createQuery(hql).setParameter("id", classId ).list();
        return list;
    }

    //查询指定id的学生对象 即该条记录
    @Override
    public StudentEntity selectByStudentId(String id) {
        String hql ="from StudentEntity where studentId = :id";
        Query query = getSession().createQuery(hql).setParameter("id" , id);
        return (StudentEntity) query.uniqueResult();
    }

    //根据className来查询并返回对象
    @Override
    public ClazzEntity queryIdOfClass(String className) {
        String hql = "from ClazzEntity where serialNumber = :name";
        Query query = getSession().createQuery(hql).setParameter("name" , className);
        return (ClazzEntity) query.uniqueResult();
    }
}
