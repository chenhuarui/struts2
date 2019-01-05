package homework.action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.ClazzEntity;
import homework.entity.StudentEntity;
import homework.service.OperateClass;
import homework.service.QueryStuInfo;
import org.apache.struts2.interceptor.RequestAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 根据条件查询符合的学生信息返回列表
 * 显示在页面上
 */
public class StuAction extends ActionSupport implements RequestAware {

    //班级姓名
    private String className;

    //属性
    private String attribute;

    //操作符
    private String operation;

    //输入的关键字
    private String key;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

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

    private Map<String, Object> application;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }

    QueryStuInfo queryStuInfo = new QueryStuInfo();

    public String queryStuInfo() {

        //根据className 查询Clazz表返回 id
        String id = new OperateClass().queryIdOfClass(className);
        System.out.println(id);

        //根据得到的id 查询Student表 返回list
        List<StudentEntity> students = new OperateClass().queryClassOfStudents(id);

        if(attribute.equals("年龄")) {
            students = queryStuInfo.queryAge(key,operation,students);
        }
        else {
            students = queryStuInfo.queryString(key,attribute,operation,students);
        }

        //保持与页面的相同
        application.put("classOfStudents", students);

        List<ClazzEntity> classList = new OperateClass().query();
        List<String> listName = new ArrayList<>();
        for(int i=0;i<classList.size();i++)
            listName.add(classList.get(i).getSerialNumber());
        application.put("listName", listName);

        return "success";
    }

}
