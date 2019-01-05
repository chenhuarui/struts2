package homework.action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.ClazzEntity;
import homework.entity.StudentEntity;
import homework.service.OperateClass;
import homework.service.OperateStudent;
import org.apache.struts2.interceptor.RequestAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对学生信息进行增删改查
 */
public class StudentAction extends ActionSupport implements RequestAware {

    private StudentEntity student;

    private Map<String, Object> application;

    OperateStudent operateStudent = new OperateStudent();


    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    //增加学生信息
    public String addStudent() {
        operateStudent.addStudent(student);
        commonPart();
        return "success";
    }


    //删除
    public String deleteStudent() {
        operateStudent.deleteStudent(student.getStudentId());
        commonPart();
        return "success";
    }


    //编辑学生信息
    public String updateStudent() {
        operateStudent.update(student);
        commonPart();
        return "success";
    }

    //获取页面上指定对象 并返回id
    //更新的时候
    public String inputStudent() {
        student = operateStudent.selectById(student.getStudentId());
        return INPUT;
    }

    public void getListToPage() {
        //显示选择班级的下拉框
        OperateClass classService = new OperateClass();
        List<ClazzEntity> classList = classService.query();
        List<String> listName = new ArrayList<>();

        for (int i = 0; i < classList.size(); i++)
            listName.add(classList.get(i).getSerialNumber());

        application.put("listName", listName);
    }

    //整合共有部分
    public void commonPart() {
        //返回列表
        List<StudentEntity> list = new OperateClass().queryClassOfStudents(student.getClassId());
        getListToPage();
        application.put("classOfStudents", list);
    }

}
