package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
 
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;


import com.lyt.member.entity.Admin;
@Transactional
public class AdminDao extends BaseDao {

	
	/**
	 * 管理员登录
	 * @param account
	 * @param password
	 * @return
	 */
	public Admin adminLogin(String account,String password){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Admin where adminName = ? and adminPassword = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, account);
		query.setParameter(1, password);
		List<Admin> mananagerlist=query.list();
		if(mananagerlist.size()>0){
			return mananagerlist.get(0);
		}else{
			return null;
		}
	}
		/**
		 * 修改管理员信息
		 * @param managerPassword
		 * @param managerAccount
		 * @param managerId
		 * @return
		 */
		public boolean updateAdmin(Admin admin){
			Session session = sessionFactory.getCurrentSession();
			session.update(admin);
		return true;
		}	

		
		
		
		
		
		
		
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
