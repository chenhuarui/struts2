package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ClazzEntity;
import entity.StudentEntity;
import org.apache.struts2.interceptor.RequestAware;
import service.OperateClassService;
import service.QueryStuInfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 根据条件查询符合的学生信息返回列表
 * 显示在页面上
 */
public class CriteriaQueriesAction extends ActionSupport implements RequestAware {

    private QueryStuInfoService queryStuInfoService;

    private OperateClassService classService;

    public QueryStuInfoService getQueryStuInfoService() {
        return queryStuInfoService;
    }

    public void setQueryStuInfoService(QueryStuInfoService queryStuInfoService) {
        this.queryStuInfoService = queryStuInfoService;
    }

    public OperateClassService getClassService() {
        return classService;
    }

    public void setClassService(OperateClassService classService) {
        this.classService = classService;
    }

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


    public String queryStuInfo() {

        //根据className 查询Clazz表返回 id
        String id = queryStuInfoService.queryIdOfClass(className);

        //根据得到的classId 查询Student表 返回list
        List<StudentEntity> students = queryStuInfoService.queryClassOfStudents(id);

        if(attribute.equals("年龄"))
            students = queryStuInfoService.queryAge(key,operation,students);

        else
            students = queryStuInfoService.queryString(key,attribute,operation,students);

        //保持与页面的相同
        application.put("classOfStudents", students);

        List<ClazzEntity> classList = classService.query();
        List<String> listName = new ArrayList<>();
        for(int i=0;i<classList.size();i++)
            listName.add(classList.get(i).getSerialNumber());
        application.put("listName", listName);

        return "success";
    }

}
