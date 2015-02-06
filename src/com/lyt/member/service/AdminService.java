package com.lyt.member.service;

import com.lyt.member.dao.AdminDao;
import com.lyt.member.entity.Admin;

public class AdminService {
	
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	
	/**
	 * 登录
	 */
	public Admin adminLogin(String account, String password) {
		 
	
			return adminDao.adminLogin(account, password);
		

	}	
	
	/**
	 * 修改管理员的个人信息
	 * 
	 * @param manager
	 * @return
	 */
	public boolean adminModify(Admin admin) {
		return adminDao.updateAdmin(admin);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}
