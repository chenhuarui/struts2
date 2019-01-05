package service.Impl;

import dao.OperateDao;
import entity.ClazzEntity;
import entity.StudentEntity;
import service.OperateClassService;

import java.util.List;

public class OperateClassServiceImpl implements OperateClassService {

    private OperateDao operateDao;

    public OperateDao getOperateDao() {
        return operateDao;
    }

    public void setOperateDao(OperateDao operateDao) {
        this.operateDao = operateDao;
    }


    @Override
    public List<ClazzEntity> query() {
        return operateDao.queryClass();
    }

    @Override
    public List<Long> getCount() {
        return operateDao.getRecordCount();
    }

    @Override
    public void add(ClazzEntity clazzEntity) {
        operateDao.add(clazzEntity);
    }

    @Override
    public void delete(String id) {
        ClazzEntity clazzEntity = new ClazzEntity();
        clazzEntity.setId(id);
        operateDao.delete(clazzEntity);
    }

    @Override
    public void update(ClazzEntity clazzEntity) {
        operateDao.update(clazzEntity);
    }

    @Override
    public ClazzEntity selectById(String id) {
        return operateDao.selectById(id);
    }

    @Override
    public List<StudentEntity> queryClassOfStudents(String id) {
        return operateDao.queryClassOfStudents(id);
    }

    @Override
    public String queryIdOfClass(String className) {
        return operateDao.queryIdOfClass(className).getId();
    }
}
