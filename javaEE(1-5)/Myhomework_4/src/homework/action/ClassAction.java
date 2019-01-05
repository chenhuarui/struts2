package homework.action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.ClazzEntity;
import homework.entity.StudentEntity;
import homework.service.OperateClass;
import org.apache.struts2.interceptor.RequestAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对班级信息的增删改查
 */
public class ClassAction extends ActionSupport implements RequestAware {

    private OperateClass operateClass = new OperateClass();

    private ClazzEntity clazzEntity;

    public ClazzEntity getClazzEntity() {
        return clazzEntity;
    }

    public void setClazzEntity(ClazzEntity clazzEntity) {
        this.clazzEntity = clazzEntity;
    }

    //查询各个班级
    public String queryClass() {

        List<ClazzEntity> list = operateClass.query();
        List<Long> countList = operateClass.getCount();

        application.put("clazzEntities", list);
        application.put("countList", countList);

        return "success";
    }

    private Map<String, Object> application;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }

    //新增班级
    public String addClass() {
        operateClass.add(clazzEntity);
        queryClass();
        return "success";
    }

    //删除班级
    public String deleteClass() {
        operateClass.delete(clazzEntity.getId());
        queryClass();
        return "success";
    }

    //更新班级信息
    public String updateClass() {
        operateClass.update(clazzEntity);
        queryClass();
        return "success";
    }

    //根据studentId获取数据库的该对象所有信息
    public String inputClass() {
        clazzEntity = operateClass.selectById(clazzEntity.getId());
        return INPUT;
    }

    //班级详情-展示所在该班级的学生
    public String detailsClass() {

        List<StudentEntity> list = operateClass.queryClassOfStudents(clazzEntity.getId());

        application.put("classOfStudents", list);

        //显示选择班级的下拉框
        List<ClazzEntity> classList = new OperateClass().query();
        List<String> listName = new ArrayList<>();

        for(int i=0;i<classList.size();i++)
            listName.add(classList.get(i).getSerialNumber());
        application.put("listName", listName);

        return "showClassOfStudents";
    }

}
