package homework.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import homework.entity.Screen;
import homework.entity.Student;
import homework.service.QueryStuInfo;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * 根据条件进行查询并返回结果:studentList(符合条件的学生信息)
 */
public class StuAction extends ActionSupport implements RequestAware, ModelDriven {

    private Screen screen = new Screen();

    @Override
    public Object getModel() {
        return this.screen;
    }

    private Map<String, Object> application;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }

    /**
     * 查询方法
     */
    public String queryStuInfo() {

        //实例化方法类,调用查询方法
        List<Student> list = new QueryStuInfo().queryInfo(screen.getAttribute(), screen.getOperation(), screen.getKey());

        application.put("studentList", list);

        return "success";
    }
}
