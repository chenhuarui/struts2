package service.Impl;

import dao.OperateDao;
import entity.StudentEntity;
import service.QueryStuInfoService;

import java.util.ArrayList;
import java.util.List;

public class QueryStuInfoServiceImpl implements QueryStuInfoService {

    private OperateDao operateDao;

    public OperateDao getOperateDao() {
        return operateDao;
    }

    public void setOperateDao(OperateDao operateDao) {
        this.operateDao = operateDao;
    }

    @Override
    public String queryIdOfClass(String className) {
        return operateDao.queryIdOfClass(className).getId();
    }

    @Override
    public List<StudentEntity> queryClassOfStudents(String classId) {
        return operateDao.queryClassOfStudents(classId);
    }

    @Override
    public List<StudentEntity> queryString(String key, String attribute, String operation, List<StudentEntity> students) {

        List<StudentEntity> newStudents = new ArrayList<>();

        if (operation.equals("包含")) {
            if (attribute.equals("学号")) {
                for (StudentEntity stu : students) {
                    if (stu.getStudentId().contains(key)) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (StudentEntity stu : students) {
                    if (stu.getStudentName().contains(key)) {
                        newStudents.add(stu);
                    }
                }
            }
        } else if (operation.equals("等于")) {
            if (attribute.equals("学号")) {
                for (StudentEntity stu : students) {
                    if (stu.getStudentId().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            } else {
                for (StudentEntity stu : students) {
                    if (stu.getStudentName().equals(key)) {
                        newStudents.add(stu);
                    }
                }
            }
        }

        return newStudents;
    }

    @Override
    public List<StudentEntity> queryAge(String key, String operation, List<StudentEntity> students) {
        List<StudentEntity> newStudents = new ArrayList<>();
        if (operation.equals("大于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() > Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("大于等于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() >= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        } else if (operation.equals("小于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() < Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }else if(operation.equals("小于等于")) {
            for (StudentEntity stu : students) {
                if (stu.getStudentAge() <= Integer.parseInt(key)) {
                    newStudents.add(stu);
                }
            }
        }

        return newStudents;
    }
}
