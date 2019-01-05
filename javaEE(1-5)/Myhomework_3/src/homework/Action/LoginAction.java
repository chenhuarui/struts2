package homework.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import homework.entity.User;

/**
 * 登录Action
 * 判断用户名和密码是否符合
 */
public class LoginAction extends ActionSupport implements ModelDriven {

    private User user = new User();

    @Override
    public Object getModel() {
        return this.user;
    }

    @Override
    public String execute() {

        //获取ActionContext
        ActionContext actionContext = ActionContext.getContext();

        if(user.getUserName().equals("chr") && user.getPassword().equals("123")) {

            return "success";
        }
        actionContext.put("msg", "用户名或密码不正确");
        return "failed";
    }

}
