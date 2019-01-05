package homework.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import homework.entity.User;

/**
 * 登录Action
 */
public class LoginAction extends ActionSupport implements ModelDriven {

    User user = new User();

    @Override
    public Object getModel() {
        return this.user;
    }

    @Override
    public String execute() throws Exception {

        //获取ActionContext
        ActionContext actionContext = ActionContext.getContext();

        if(user.getUserName().equals("chr") && user.getPassword().equals("123")) {

            //将用户存储在session
            actionContext.getSession().put("user", user);
            return "success";
        }
        actionContext.put("msg", "用户名或密码不正确");
        return "failed";
    }
}
