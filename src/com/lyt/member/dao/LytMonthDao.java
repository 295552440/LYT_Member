package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.entity.LytMonth;
import com.lyt.member.util.Constant;

@Transactional
public class LytMonthDao extends BaseDao {
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
		} /*
		 * else if ("id_desc".equals(order)) { hql =
		 * "from LytMonth ORDER BY hycardId desc"; } else if
		 * ("id".equals(order)) { hql = "from LytMonth ORDER BY hycardId"; }
		 */

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}

	/**
	 * 查询数量
	 */
	public List<LytMonth> querySize(String input, String searchInput) {
		String hql = "from LytMonth ";// 默认
		if ("state_yes".equals(input)) {
			hql = "from LytMonth  as l where l.fanliState=1";
		} /*
		 * else if ("state_no".equals(input)) { hql =
		 * "from LytHuiyuan   as l where l.hyState=2"; }
		 */else if ("state_wait".equals(input)) {
			hql = "from LytMonth   as l where l.fanliState=0";
		} else if ("id".equals(input)) {
			hql = "from LytMonth   as l where l.tjrCardId='" + searchInput
					+ "'";
		} /*
		 * else if ("name".equals(input)) {
		 * 
		 * hql = "from LytMonth   as l where l.hyname='" + searchInput + "'"; }
		 */else {
			hql = "from LytMonth ";
		}

		return queryByHql(hql);
	}

	/**
	 * 按Hql查询
	 */
	public List<LytMonth> queryByHql(String hql) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql);
		return query.list();
	}

	/**
	 * queryByState
	 */

	public List<LytMonth> queryByState(String state, int startRow) {
		String hql = "from LytMonth ";// 默认
		if ("state_yes".equals(state)) {
			hql = "from LytMonth  as l where l.fanliState=1 ORDER  BY tjTime desc";
		} /*
		 * else if ("state_no".equals(state)) { hql =
		 * "from LytHuiyuan   as l where l.hyState=2 ORDER BY applyTime desc"; }
		 */else if ("state_wait".equals(state)) {
			hql = "from LytMonth   as l where l.fanliState=0 ORDER BY tjTime desc";
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
	public List<LytMonth> queryBySearch(String searchBy, String searchInput,
			int startRow) {
		String hql = "from LytMonth ORDER BY tjTime desc";// 默认

		if ("id".equals(searchBy)) {
			hql = "from LytMonth   as l where l.tjrCardId='" + searchInput
					+ "' ORDER BY tjTime desc";
		} /*
		 * else if ("name".equals(searchBy)) {
		 * 
		 * hql = "from LytMonth   as l where l.hyname ='" + searchInput +
		 * "' ORDER BY tjTime desc"; }
		 */

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// 可以取到一定范围内的数据，用来数据分页显示
		query.setFirstResult(startRow);// 设置结果集第一个数据的行数，注意：从0行开始计数
		query.setMaxResults(Constant.PAGE_SIZE);// 设置每页显示的数
		return query.list();
	}

	public void addLytMonth(LytMonth lytMonth) {
		hibernateTemplate.save(lytMonth);
	}

	public void updateRenShu(LytMonth lytMonth) {
		hibernateTemplate.update(lytMonth);
	}

	public List<LytMonth> queryByCardId(String cardId) {
		String hql = "from LytMonth where tjrCardId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, cardId);
		return query.list();
	}
	
	public LytMonth queryById(String id) {
		LytMonth lm = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytMonth as l where l.id=?";
		Query query = session.createQuery(hql);
		query.setString(0, id);
		lm = (LytMonth) query.uniqueResult();
		return lm;
	}
	public boolean update(LytMonth lm) {
		sessionFactory.getCurrentSession().update(lm);
		return true;
	}
}
