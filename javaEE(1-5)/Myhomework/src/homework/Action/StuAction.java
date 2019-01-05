package homework.Action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.Student;
import homework.entity.User;
import homework.service.QueryStuInfo;
import org.apache.struts2.interceptor.RequestAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StuAction extends ActionSupport implements RequestAware {

    //用户
    User user = new User();

    //属性
    private String attribute;

    //操作符
    private String operation;

    //输入的关键字
    private String key;

    private List<Student> studentList = new ArrayList<>();


    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    private Map<String, Object> application;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }


    QueryStuInfo queryStuInfo = new QueryStuInfo();


    public String queryStuInfo() {

        if(attribute.equals("年龄")) {
               studentList = queryStuInfo.queryAge(key,operation);
        }
        else {
            studentList = queryStuInfo.queryString(key,attribute,operation);
        }

        application.put("studentList", studentList);

        return "success";
    }

}
