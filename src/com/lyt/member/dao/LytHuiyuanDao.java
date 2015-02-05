package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

}
