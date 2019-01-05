package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.ClazzEntity;
import entity.StudentEntity;
import org.apache.struts2.interceptor.RequestAware;
import service.OperateClassService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassAction extends ActionSupport implements RequestAware {

    private OperateClassService classService;

    private Map<String, Object> application;

    private ClazzEntity clazzEntity;

    public ClazzEntity getClazzEntity() {
        return clazzEntity;
    }

    public void setClazzEntity(ClazzEntity clazzEntity) {
        this.clazzEntity = clazzEntity;
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

    //查询各个班级
    public String queryClass() {

        List<ClazzEntity> list = classService.query();
        List<Long> countList = classService.getCount();

        application.put("clazzEntities", list);
        application.put("countList", countList);

        return "success";
    }

    //新增班级
    public String addClass() {
        classService.add(clazzEntity);
        queryClass();
        return "success";
    }

    //删除班级
    public String deleteClass() {
        classService.delete(clazzEntity.getId());
        queryClass();
        return "success";
    }

    //更新班级信息
    public String updateClass() {
        classService.update(clazzEntity);
        queryClass();
        return "success";
    }

    //根据studentId获取数据库的该对象所有信息
    public String inputClass() {
        clazzEntity = classService.selectById(clazzEntity.getId());
        return INPUT;
    }

    //班级详情-展示所在该班级的学生
    public String detailsClass() {

        List<StudentEntity> list = classService.queryClassOfStudents(clazzEntity.getId());

        application.put("classOfStudents", list);

        application.put("listName", getListToPage());

        return "showClassOfStudents";
    }

    public List<String> getListToPage() {
        //显示选择班级的下拉框
        List<ClazzEntity> classList = classService.query();
        List<String> listName = new ArrayList<>();

        for(int i=0;i<classList.size();i++)
            listName.add(classList.get(i).getSerialNumber());

        return listName;
    }

}
