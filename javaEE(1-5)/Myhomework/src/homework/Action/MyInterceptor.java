package homework.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器
 * 判断用户是否登陆，没有登陆返回登陆页面
 * 登陆成功方可进行查询
 */
public class MyInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        //获取ActionContext
        ActionContext actionContext = actionInvocation.getInvocationContext();

        //获取user对象
        Object user = actionContext.getSession().get("user");

        if(user != null) {
            return actionInvocation.invoke();
        }else {
            actionContext.put("msg", "你未登陆，请先登录");
            return "login";
        }
    }
}

