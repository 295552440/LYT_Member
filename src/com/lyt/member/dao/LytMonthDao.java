package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

 

import com.lyt.member.entity.LytMonth;
import com.lyt.member.util.Constant;

@Transactional
public class LytMonthDao extends BaseDao{
	public List<LytMonth> queryAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytMonth";
		Query query = session.createQuery(hql);
		return query.list();
	}


	/**
	 * queryByOrder
	 */
	public List<LytMonth> queryByOrder(String order, int startRow) {
		String hql = "from LytMonth";// 默认

		if ("date_desc".equals(order)) {
			hql = "from LytMonth ORDER BY tjTime desc";
		} else if ("date".equals(order)) {
			hql = "from LytMonth ORDER BY tjTime";
		} /*else if ("id_desc".equals(order)) {
			hql = "from LytMonth ORDER BY hycardId desc";
		} else if ("id".equals(order)) {
			hql = "from LytMonth ORDER BY hycardId";
		}*/

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}





}
