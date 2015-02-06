package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.cache.interceptors.TxInterceptor;
import org.springframework.transaction.annotation.Transactional;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.util.Constant;

@Transactional
public class LytHuiyuanDao extends BaseDao {
	public boolean addLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().save(lytHuiyuan);
		return true;
	}

	public boolean deleteLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().delete(lytHuiyuan);
		return true;
	}

	public boolean updateLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().update(lytHuiyuan);
		return true;
	}

	public List<LytHuiyuan> queryAllLytHuiyuan() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytHuiyuan";
		Query query = session.createQuery(hql);
		return query.list();
	}

	/**
	 * 通过id查询会员记录；
	 * @param id
	 * @return
	 */
	public LytHuiyuan queryById(String id) {
		LytHuiyuan lytHuiyuan = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytHuiyuan as l where l.id=?";
		Query query = session.createQuery(hql);
		query.setString(0, id);
		lytHuiyuan = (LytHuiyuan) query.uniqueResult();
		return lytHuiyuan;
	}
	/**
	 * 通过
	 * @param name
	 * @return
	 */
	public LytHuiyuan queryByName(String name) {
		return (LytHuiyuan) hibernateTemplate.find("from LytHuiyuan l where l.id= ?", name).get(0);
	}
	
	/**
	 * 通过会员卡号去查询；
	 * @param id
	 * @return
	 */
	public LytHuiyuan queryByCardId(String id) {
		LytHuiyuan lytHuiyuan = null;
		Session session = sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
			
			
			String hql = "from LytHuiyuan as l where l.hycardId=?";
			lytHuiyuan = (LytHuiyuan) session.createQuery(hql)
				.setString(0, id)
				.uniqueResult();
			
			
			tx.commit();
			return lytHuiyuan;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	
	}

	/**
	 * queryByOrder
	 */
	public List<LytHuiyuan> queryByOrder(String order, int startRow) {
		String hql = "from LytHuiyuan ";// 默认

		if ("date_desc".equals(order)) {
			hql = "from LytHuiyuan ORDER BY applyTime desc";
		} else if ("date".equals(order)) {
			hql = "from LytHuiyuan ORDER BY applyTime";
		} else if ("id_desc".equals(order)) {
			hql = "from LytHuiyuan ORDER BY hycardId desc";
		} else if ("id".equals(order)) {
			hql = "from LytHuiyuan ORDER BY hycardId";
		}

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}
	
	/**
	 * 按Hql查询
	 */
	public List<LytHuiyuan> queryByHql(String hql) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql);
		return query.list();
	}
	/**
	 * 查询数量
	 */
	public List<LytHuiyuan> querySize(String input, String searchInput) {
		String hql = "from LytHuiyuan ";// 默认

		if ("state_yes".equals(input)) {
			hql = "from LytHuiyuan  as l where l.hyState=1";
		} /*else if ("state_no".equals(input)) {
			hql = "from LytHuiyuan   as l where l.hyState=2";
		} */else if ("state_wait".equals(input)) {
			hql = "from LytHuiyuan   as l where l.hyState=0";
		} else if ("id".equals(input)) {

			hql = "from LytHuiyuan   as l where l.hycardId='" + searchInput + "'";
		} else if ("name".equals(input)) {

			hql = "from LytHuiyuan   as l where l.hyname='" + searchInput + "'";
		} else {
			hql = "from LytHuiyuan ";
		}

		return queryByHql(hql);
	}

	
	
	
	/**
	 * queryByState
	 */

	public List<LytHuiyuan> queryByState(String state, int startRow) {
		String hql = "from LytHuiyuan ";// 默认
		if ("state_yes".equals(state)) {
			hql = "from LytHuiyuan  as l where l.hyState=1 ORDER  BY applyTime desc";
		} /*else if ("state_no".equals(state)) {
			hql = "from LytHuiyuan   as l where l.hyState=2 ORDER BY applyTime desc";
		}*/ else if ("state_wait".equals(state)) {
			hql = "from LytHuiyuan   as l where l.hyState=0 ORDER BY applyTime desc";
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}
	/**
	 * queryBySearch
	 */
	public List<LytHuiyuan> queryBySearch(String searchBy, String searchInput,
			int startRow) {
		String hql = "from LytHuiyuan ORDER BY applyTime desc";// 默认

		if ("id".equals(searchBy)) {
			hql = "from LytHuiyuan   as l where l.hycardId='" + searchInput
					+ "' ORDER BY applyTime desc";
		} else if ("name".equals(searchBy)) {

			hql = "from LytHuiyuan   as l where l.hyname ='" + searchInput
					+ "' ORDER BY applyTime desc";
		}

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}

	
}
