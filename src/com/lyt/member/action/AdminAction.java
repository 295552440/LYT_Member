package com.lyt.member.action;

import java.util.Map;

import com.lyt.member.entity.Admin;
import com.lyt.member.service.AdminService;
import com.opensymphony.xwork2.ActionContext;

public class AdminAction extends BaseAction {

	private AdminService adminService;
	private Admin admin;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 登录
	 */

	public String adminLogin() throws Exception {
		Admin admin0 = adminService.adminLogin(admin.getAdminName(),
				admin.getAdminPassword());
		if (admin0 != null) {
			session.put("admin", admin0);
			message = "登陆成功！";
			return "success";
		} else {
			message = "登录失败";
			return "error";
		}
	}

	/**
	 * checkOldPw
	 */

	public String checkOldPw() throws Exception {
		// System.out.println(admin.getAdminName()+admin.getAdminPassword());
		Admin admin0 = adminService.adminLogin(admin.getAdminName(),
				admin.getAdminPassword());
		
		if (admin0 != null) {
			message = "0";
		} else {
			message = "1";
		}
		return "success";
	}

	/**
	 * 注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {

		if (session.containsKey("admin")) {
			session.remove("admin");

			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 修改管理员信息
	 * 
	 * @return
	 */
	public String adminModify() throws Exception {
		System.out.println(admin.getId()+admin.getAdminName() + admin.getAdminPassword());
		if (adminService.adminModify(admin)) {
			session.put("admin", admin);
			message = "温馨提示：更改成功！您新的账户名称为：" + admin.getAdminName() + "，密码为："
					+ admin.getAdminPassword() + "。请妥善保管！";
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

}
