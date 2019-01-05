package homework.action;

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

        if (user != null){
            if (user.getUserName().equals("chr") && user.getPassword().equals("123"))
                return "success";
            else
                return "error";
        }else{
            return "error";
        }
    }

}
