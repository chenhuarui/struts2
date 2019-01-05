package service.Impl;

import dao.OperateDao;
import entity.StudentEntity;
import service.OperateStudentService;

import java.util.List;

public class OperateStudentServiceImpl implements OperateStudentService {

    private OperateDao operateDao;

    public OperateDao getOperateDao() {
        return operateDao;
    }

    public void setOperateDao(OperateDao operateDao) {
        this.operateDao = operateDao;
    }

    @Override
    public void addStudent(StudentEntity student) {
        operateDao.add(student);
    }

    @Override
    public void deleteStudent(String ID) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(ID);
        operateDao.delete(studentEntity);
    }

    @Override
    public void update(StudentEntity student) {
        operateDao.update(student);
    }

    @Override
    public StudentEntity selectById(String id) {
        return operateDao.selectByStudentId(id);
    }

    @Override
    public List<StudentEntity> getStudentListOfOperate(String id) {
        return operateDao.queryClassOfStudents(id);
    }
}
