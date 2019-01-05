package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ClazzEntity;
import entity.StudentEntity;
import org.apache.struts2.interceptor.RequestAware;
import service.OperateClassService;
import service.OperateStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentAction extends ActionSupport implements RequestAware {

    private Map<String, Object> application;

    private StudentEntity student;

    private OperateStudentService studentService;

    private OperateClassService classService;

    public OperateStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(OperateStudentService studentService) {
        this.studentService = studentService;
    }

    public OperateClassService getClassService() {
        return classService;
    }

    public void setClassService(OperateClassService classService) {
        this.classService = classService;
    }

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
        studentService.addStudent(student);
        commonPart();
        return "success";
    }


    //删除
    public String deleteStudent() {
        studentService.deleteStudent(student.getStudentId());
        commonPart();
        return "success";
    }


    //编辑学生信息
    public String updateStudent() {
        studentService.update(student);
        commonPart();
        return "success";
    }

    //获取页面上指定对象 并返回id
    //更新的时候
    public String inputStudent() {
        student = studentService.selectById(student.getStudentId());
        return INPUT;
    }

    public void getListToPage() {
        //显示选择班级的下拉框
        List<ClazzEntity> classList = classService.query();
        List<String> listName = new ArrayList<>();

        for (int i = 0; i < classList.size(); i++)
            listName.add(classList.get(i).getSerialNumber());

        application.put("listName", listName);
    }

    //整合共有部分
    public void commonPart() {
        //返回列表
        List<StudentEntity> list = studentService.getStudentListOfOperate(student.getClassId());
        getListToPage();
        application.put("classOfStudents", list);
    }

}
