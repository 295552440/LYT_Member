package com.lyt.member.action;

import com.lyt.member.service.AdminService;

public class AdminAction extends BaseAction {
	
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
