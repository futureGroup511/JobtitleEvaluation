package com.atfuture.utils;


import com.atfuture.interfaceUtils.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class CheckLoginInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		 //System.out.println("---------> 之前");
		 //String result = invocation.invoke(); // 放行
		 //System.out.println("---------> 之后");
		// return result;
		// 获取信息
		Role role=(Role) ActionContext.getContext().getSession().get("role");
		//System.out.println("学生" + student);
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL
		System.out.println(privUrl);
		// 如果未登录
		if (role==null) {
			//System.out.println("进来方法");
		/*if (ActionContext.getContext().getSession() == null || ActionContext.getContext().getSession().equals("")) {*/
			if (privUrl.startsWith("/loginAction")) { // "/user_loginUI", "/user_login"
				// 如果是去登录，就放行
				//System.out.println("放行");
				return invocation.invoke();
			} else {
				// 如果不是去登录，就转到登录页面
				System.out.println("去登陆");
				return "loginLy";
			}
		}
		//System.out.println("不进去方法 ");
		// 如果已登 录，就判断权限
		return invocation.invoke();
	}
}
