package com.lyt.member.util;

import java.util.Map;

import com.lyt.member.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginValidate extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		System.out.println("======拦截器开始工作=========================================");
		if ("/admin".equals(namespace)&&!"adminLogin".equals(actionName)) {
             System.out.print(namespace+"/"+actionName);
			// 获取session中保存的用户信息
			Map<String, Object> session = invocation.getInvocationContext()
					.getSession();
			Admin admin = (Admin) session.get("admin");
			if (admin == null) {
				// 未登录，返回登录页面
				System.out.println("拦截了");
				return "adminLogin";
			} else {
				// 已登录，继续执行剩余拦截器和action
				System.out.println("没拦截");
				return invocation.invoke();
			}

		} else {

			return invocation.invoke();

		}

	}

}